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
public class ProviderIds{
    @JsonProperty("Tmdb") 
    public String tmdb;
    @JsonProperty("Imdb") 
    public String imdb;
}
