package com.pingidentity.am.viewmodel

import com.pingidentity.davinci.DaVinci
import com.pingidentity.davinci.module.Oidc

val daVinci = DaVinci {
    module(Oidc) {
        clientId = "3aaaf130-cbc9-48f8-8bd2-0d08af33f7a1"
        discoveryEndpoint = "https://auth.pingone.com/3c374847-4a70-43c5-a5d1-43d5b54b0ff6/as/.well-known/openid-configuration"
        scopes = mutableSetOf("profile")
        redirectUri = "https://www.aeromexico.com"
        display = "Test config"
    }
}