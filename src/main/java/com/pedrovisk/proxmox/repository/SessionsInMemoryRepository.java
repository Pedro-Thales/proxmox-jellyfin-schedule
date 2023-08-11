package com.pedrovisk.proxmox.repository;


import com.pedrovisk.proxmox.utils.MeasureRunTime;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Repository
public class SessionsInMemoryRepository {

    private static final Map<String, Date> SESSIONS = new HashMap<>();

    @MeasureRunTime
    public Date get(String sessionId) {
        return SESSIONS.get(sessionId);
    }
    @MeasureRunTime
    public void insert(String sessionId, Date date) {
        SESSIONS.put(sessionId, date);
    }
    @MeasureRunTime
    public void remove(String sessionId) {
        SESSIONS.remove(sessionId);
    }

}
