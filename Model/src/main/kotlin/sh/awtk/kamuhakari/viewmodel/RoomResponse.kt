package sh.awtk.kamuhakari.viewmodel

import kotlinx.serialization.Serializable

@Serializable
data class RoomResponse(
    val invite_links: List<String>,
    val access_token: String
)