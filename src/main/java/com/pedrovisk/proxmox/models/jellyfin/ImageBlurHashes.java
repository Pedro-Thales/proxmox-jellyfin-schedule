package com.pedrovisk.proxmox.models.jellyfin;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageBlurHashes{
    @JsonProperty("Backdrop") 
    public Backdrop backdrop;
    @JsonProperty("Primary") 
    public Primary primary;
    @JsonProperty("Logo") 
    public Logo logo;
}
