package sh.awtk.kamuhakari.dto

import sh.awtk.kamuhakari.vo.OneTimeURL
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

data class User(
    val id: UserId,
    val roomId: RoomId,
    val oneTimeURL: OneTimeURL,
    val isActive: Boolean = false
)