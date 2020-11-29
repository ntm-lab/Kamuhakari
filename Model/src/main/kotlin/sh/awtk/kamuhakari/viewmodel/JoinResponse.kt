package sh.awtk.kamuhakari.viewmodel

import kotlinx.serialization.Serializable

@Serializable
data class JoinResponse(
    val room_id: String
)