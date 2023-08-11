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
public class RemoteTrailer{
    @JsonProperty("Url") 
    public String url;
    @JsonProperty("Name") 
    public String name;
}
