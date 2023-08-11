package com.pedrovisk.proxmox.models.jellyfin;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FullNowPlayingItem{
    @JsonProperty("Size") 
    public long size;
    @JsonProperty("Container") 
    public String container;
    @JsonProperty("IsHD") 
    public boolean isHD;
    @JsonProperty("IsShortcut") 
    public boolean isShortcut;
    @JsonProperty("Width") 
    public int width;
    @JsonProperty("Height") 
    public int height;
    @JsonProperty("ExtraIds")
    public ArrayList<Object> extraIds;
    @JsonProperty("DateLastSaved") 
    public Date dateLastSaved;
    @JsonProperty("RemoteTrailers") 
    public ArrayList<RemoteTrailer> remoteTrailers;
    @JsonProperty("SupportsExternalTransfer") 
    public boolean supportsExternalTransfer;
}
