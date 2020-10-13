package sh.awtk.kamuhakari.viewmodel

import kotlinx.serialization.Serializable

@Serializable
data class RoomRequest(
    val num_of_participants: Int,
    val mail_list: List<String>
)