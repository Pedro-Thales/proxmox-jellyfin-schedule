# Proxmox Integration

This project was created to be an integration to the Jellyfin api and the Proxmox Api, because I want to turn off my 
server, if the server is idle and nobody is watching, to save energy.

## Running
Running with the docker image you need to override the properties with environment variables as below:
```
JELLYFIN_API-URL=https://jellyfinapi-url.com/ 
JELLYFIN_AUTH-TOKEN=Token

PROXMOX_API-URL=https://proxmoxapi-url.com/
PROXMOX_AUTH-TOKEN=Token
```
##### You can do the same thing for each property in the applications.properties file.


This property
```
jellyfin.paused-session-timeout=5
```
Will be this environment variable: 
```
JELLYFIN_PAUSED-SESSION-TIMEOUT=5
```

Spring knows implicitly to look for env_variables of the same name as property with the . and camelcase replaced by _

---
## Build
### Requirements

In order to use this project you need to create a properties file called: 'secrets.properties'.

This file must contain these required properties:
```
jellyfin.api-url=https://jellyfinapi-url.com/ 
jellyfin.auth-token=Token

proxmox.api-url=https://proxmoxapi-url.com/
proxmox.auth-token=Token
```

You must change the values of those properties to the correct value that works for you.


### For further build information read the file HELP.md



