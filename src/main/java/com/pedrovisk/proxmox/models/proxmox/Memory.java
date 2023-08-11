package com.pedrovisk.proxmox.models.proxmox;

import lombok.*;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Memory{
    public long total;
    public long used;
    public long free;
}
