package com.pedrovisk.proxmox.models.jellyfin;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Chapter{
    @JsonProperty("StartPositionTicks") 
    public Object startPositionTicks;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("ImagePath") 
    public String imagePath;
    @JsonProperty("ImageDateModified") 
    public Date imageDateModified;
    @JsonProperty("ImageTag") 
    public String imageTag;
}
