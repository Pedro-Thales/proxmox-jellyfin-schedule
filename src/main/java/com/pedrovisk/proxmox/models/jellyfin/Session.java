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
public class Session {
    @JsonProperty("PlayState") 
    public PlayState playState;
    @JsonProperty("AdditionalUsers") 
    public ArrayList<Object> additionalUsers;
    @JsonProperty("Capabilities") 
    public Capabilities capabilities;
    @JsonProperty("RemoteEndPoint") 
    public String remoteEndPoint;
    @JsonProperty("PlayableMediaTypes") 
    public ArrayList<String> playableMediaTypes;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("UserId") 
    public String userId;
    @JsonProperty("UserName") 
    public String userName;
    @JsonProperty("Client") 
    public String client;
    @JsonProperty("LastActivityDate") 
    public Date lastActivityDate;
    @JsonProperty("LastPlaybackCheckIn") 
    public Date lastPlaybackCheckIn;
    @JsonProperty("DeviceName") 
    public String deviceName;
    @JsonProperty("NowPlayingItem") 
    public NowPlayingItem nowPlayingItem;
    @JsonProperty("FullNowPlayingItem") 
    public FullNowPlayingItem fullNowPlayingItem;
    @JsonProperty("DeviceId") 
    public String deviceId;
    @JsonProperty("ApplicationVersion") 
    public String applicationVersion;
    @JsonProperty("IsActive") 
    public boolean isActive;
    @JsonProperty("SupportsMediaControl") 
    public boolean supportsMediaControl;
    @JsonProperty("SupportsRemoteControl") 
    public boolean supportsRemoteControl;
    @JsonProperty("NowPlayingQueue") 
    public ArrayList<Object> nowPlayingQueue;
    @JsonProperty("NowPlayingQueueFullItems") 
    public ArrayList<Object> nowPlayingQueueFullItems;
    @JsonProperty("HasCustomDeviceName") 
    public boolean hasCustomDeviceName;
    @JsonProperty("ServerId") 
    public String serverId;
    @JsonProperty("SupportedCommands") 
    public ArrayList<String> supportedCommands;
}
