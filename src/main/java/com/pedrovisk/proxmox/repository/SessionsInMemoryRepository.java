package com.pedrovisk.proxmox.repository;


import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Repository
public class SessionsInMemoryRepository {

    private static final Map<String, Date> SESSIONS = new HashMap<>();


    public Date get(String sessionId) {
        return SESSIONS.get(sessionId);
    }

    public void insert(String sessionId, Date date) {
        SESSIONS.put(sessionId, date);
    }

    public void remove(String sessionId) {
        SESSIONS.remove(sessionId);
    }

}
