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
public class MediaStream{
    @JsonProperty("Codec") 
    public String codec;
    @JsonProperty("TimeBase") 
    public String timeBase;
    @JsonProperty("VideoRange") 
    public String videoRange;
    @JsonProperty("VideoRangeType") 
    public String videoRangeType;
    @JsonProperty("DisplayTitle") 
    public String displayTitle;
    @JsonProperty("NalLengthSize") 
    public String nalLengthSize;
    @JsonProperty("IsInterlaced") 
    public boolean isInterlaced;
    @JsonProperty("IsAVC") 
    public boolean isAVC;
    @JsonProperty("BitRate") 
    public int bitRate;
    @JsonProperty("BitDepth") 
    public int bitDepth;
    @JsonProperty("RefFrames") 
    public int refFrames;
    @JsonProperty("IsDefault") 
    public boolean isDefault;
    @JsonProperty("IsForced") 
    public boolean isForced;
    @JsonProperty("Height") 
    public int height;
    @JsonProperty("Width") 
    public int width;
    @JsonProperty("AverageFrameRate") 
    public double averageFrameRate;
    @JsonProperty("RealFrameRate") 
    public double realFrameRate;
    @JsonProperty("Profile") 
    public String profile;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("AspectRatio") 
    public String aspectRatio;
    @JsonProperty("Index") 
    public int index;
    @JsonProperty("IsExternal") 
    public boolean isExternal;
    @JsonProperty("IsTextSubtitleStream") 
    public boolean isTextSubtitleStream;
    @JsonProperty("SupportsExternalStream") 
    public boolean supportsExternalStream;
    @JsonProperty("PixelFormat") 
    public String pixelFormat;
    @JsonProperty("Level") 
    public int level;
    @JsonProperty("Language") 
    public String language;
    @JsonProperty("Title") 
    public String title;
    @JsonProperty("ChannelLayout") 
    public String channelLayout;
    @JsonProperty("Channels") 
    public int channels;
    @JsonProperty("SampleRate") 
    public int sampleRate;
    @JsonProperty("LocalizedUndefined") 
    public String localizedUndefined;
    @JsonProperty("LocalizedDefault") 
    public String localizedDefault;
    @JsonProperty("LocalizedForced") 
    public String localizedForced;
    @JsonProperty("LocalizedExternal") 
    public String localizedExternal;
}
