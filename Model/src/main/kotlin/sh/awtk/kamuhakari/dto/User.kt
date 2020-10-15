package sh.awtk.kamuhakari.dto

import org.joda.time.DateTime
import sh.awtk.kamuhakari.vo.OneTimeURL
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

data class User(
    val id: UserId,
    val roomId: RoomId,
    val oneTimeURL: OneTimeURL,
    var isActive: Boolean = false,
    val expireAt: DateTime = DateTime.now().plusDays(7)
)