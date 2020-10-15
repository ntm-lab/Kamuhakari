package sh.awtk.kamuhakari.interfaces

import sh.awtk.kamuhakari.dto.User
import sh.awtk.kamuhakari.vo.OneTimeURL
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

interface IUserRepository {
    fun create(user: User): User
    fun findBy(userId: UserId): User
    fun findBy(roomId: RoomId): User
    fun findBy(url: OneTimeURL): User
    fun update(user: User): User
    fun disable(userId: UserId)
}