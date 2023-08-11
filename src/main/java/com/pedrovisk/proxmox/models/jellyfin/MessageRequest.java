package com.pedrovisk.proxmox.models.jellyfin;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageRequest {

    String header;
    String text;
    int timeoutMs;
}
