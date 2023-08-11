package com.pedrovisk.proxmox.models.proxmox;

import lombok.*;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Swap{
    public long free;
    public long total;
    public int used;
}
