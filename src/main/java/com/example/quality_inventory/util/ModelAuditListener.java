package com.example.quality_inventory.util;


import com.example.quality_inventory.Action;
import com.example.quality_inventory.client.HistoryLogClient;
import com.example.quality_inventory.dto.AuditLogDto;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Slf4j
public class ModelAuditListener {
    private static HistoryLogClient historyLogClient;
    @Autowired
    public void init(HistoryLogClient historyLogClient) {
        ModelAuditListener.historyLogClient = historyLogClient;
    }
    @PostPersist
    public void afterCreate(Object entity) {
        dispatch(entity, Action.CREATE);
    }

    @PostUpdate
    public void afterUpdate(Object entity) {
        dispatch(entity, Action.UPDATE);
    }

    @PostRemove
    public void afterDelete(Object entity) {
        dispatch(entity, Action.DELETE);
    }

    private void dispatch(Object entity, Action action) {
        try {
            AuditLogDto request = new AuditLogDto();
            request.setTableName(entity.getClass().getSimpleName().toLowerCase());
            request.setAction(action);
            request.setChangedData(entity.toString());
            request.setRecordId(extractEntityId(entity));
            request.setIpAddress(captureCurrentRequestIp());
                       log.info("auditlog details"+request);
            historyLogClient.sendAuditLog(request);
        } catch (Exception e) {
            System.err.println("Audit tracing failed silently: " + e.getMessage());
        }
    }

    private Integer extractEntityId(Object entity) {
        try {
            var field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            return (Integer) field.get(entity);
        } catch (Exception e) {
            return null;
        }
    }

    private String captureCurrentRequestIp() {
        ServletRequestAttributes attribs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attribs != null) {
            HttpServletRequest request = attribs.getRequest();
            String proxiedHeader = request.getHeader("X-Forwarded-For");
            return (proxiedHeader == null) ? request.getRemoteAddr() : proxiedHeader.split(",")[0].trim();
        }
        return "INTERNAL_SERVICE_THREAD";
    }
}
