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
public class NowPlayingItem{
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("OriginalTitle") 
    public String originalTitle;
    @JsonProperty("ServerId") 
    public String serverId;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("DateCreated") 
    public Date dateCreated;
    @JsonProperty("HasSubtitles") 
    public boolean hasSubtitles;
    @JsonProperty("Container") 
    public String container;
    @JsonProperty("PremiereDate") 
    public Date premiereDate;
    @JsonProperty("ExternalUrls") 
    public ArrayList<ExternalUrl> externalUrls;
    @JsonProperty("Path") 
    public String path;
    @JsonProperty("EnableMediaSourceDisplay") 
    public boolean enableMediaSourceDisplay;
    @JsonProperty("OfficialRating") 
    public String officialRating;
    @JsonProperty("ChannelId") 
    public Object channelId;
    @JsonProperty("Overview") 
    public String overview;
    @JsonProperty("Taglines") 
    public ArrayList<String> taglines;
    @JsonProperty("Genres") 
    public ArrayList<String> genres;
    @JsonProperty("CommunityRating") 
    public double communityRating;
    @JsonProperty("RunTimeTicks") 
    public long runTimeTicks;
    @JsonProperty("ProductionYear") 
    public int productionYear;
    @JsonProperty("ProviderIds") 
    public ProviderIds providerIds;
    @JsonProperty("IsHD") 
    public boolean isHD;
    @JsonProperty("IsFolder") 
    public boolean isFolder;
    @JsonProperty("ParentId") 
    public String parentId;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("Studios") 
    public ArrayList<Studio> studios;
    @JsonProperty("GenreItems") 
    public ArrayList<GenreItem> genreItems;
    @JsonProperty("LocalTrailerCount") 
    public int localTrailerCount;
    @JsonProperty("SpecialFeatureCount") 
    public int specialFeatureCount;
    @JsonProperty("PrimaryImageAspectRatio") 
    public double primaryImageAspectRatio;
    @JsonProperty("MediaStreams") 
    public ArrayList<MediaStream> mediaStreams;
    @JsonProperty("VideoType") 
    public String videoType;
    @JsonProperty("ImageTags") 
    public ImageTags imageTags;
    @JsonProperty("BackdropImageTags") 
    public ArrayList<String> backdropImageTags;
    @JsonProperty("ImageBlurHashes") 
    public ImageBlurHashes imageBlurHashes;
    @JsonProperty("Chapters") 
    public ArrayList<Chapter> chapters;
    @JsonProperty("LocationType") 
    public String locationType;
    @JsonProperty("MediaType") 
    public String mediaType;
    @JsonProperty("Width") 
    public int width;
    @JsonProperty("Height") 
    public int height;
}
