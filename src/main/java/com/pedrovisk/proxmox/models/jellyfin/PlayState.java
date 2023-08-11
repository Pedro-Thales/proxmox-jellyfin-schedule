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
public class PlayState{
    @JsonProperty("PositionTicks") 
    public long positionTicks;
    @JsonProperty("CanSeek") 
    public boolean canSeek;
    @JsonProperty("IsPaused") 
    public boolean isPaused;
    @JsonProperty("IsMuted") 
    public boolean isMuted;
    @JsonProperty("AudioStreamIndex") 
    public int audioStreamIndex;
    @JsonProperty("SubtitleStreamIndex") 
    public int subtitleStreamIndex;
    @JsonProperty("MediaSourceId") 
    public String mediaSourceId;
    @JsonProperty("PlayMethod") 
    public String playMethod;
    @JsonProperty("RepeatMode") 
    public String repeatMode;
}
