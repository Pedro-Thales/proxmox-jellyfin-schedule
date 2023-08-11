package com.pedrovisk.proxmox.models.jellyfin;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Capabilities{
    @JsonProperty("PlayableMediaTypes") 
    public ArrayList<String> playableMediaTypes;
    @JsonProperty("SupportedCommands") 
    public ArrayList<String> supportedCommands;
    @JsonProperty("SupportsMediaControl") 
    public boolean supportsMediaControl;
    @JsonProperty("SupportsContentUploading") 
    public boolean supportsContentUploading;
    @JsonProperty("SupportsPersistentIdentifier") 
    public boolean supportsPersistentIdentifier;
    @JsonProperty("SupportsSync") 
    public boolean supportsSync;
}
