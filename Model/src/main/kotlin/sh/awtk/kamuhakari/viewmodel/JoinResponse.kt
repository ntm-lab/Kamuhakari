package sh.awtk.kamuhakari.viewmodel

import kotlinx.serialization.Serializable

@Serializable
data class JoinResponse(
    val access_token: String
)