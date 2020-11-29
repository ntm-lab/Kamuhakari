package sh.awtk.kamuhakari.exposed.repository

import sh.awtk.kamuhakari.dto.UserDto
import sh.awtk.kamuhakari.interfaces.IUserRepository
import sh.awtk.kamuhakari.vo.OneTimeURL
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

class UserRepository:IUserRepository {
    override fun create(user: UserDto): UserDto {
        TODO("Not yet implemented")
    }

    override fun findBy(userId: UserId): UserDto {
        TODO("Not yet implemented")
    }

    override fun findBy(roomId: RoomId): UserDto {
        TODO("Not yet implemented")
    }

    override fun findBy(url: OneTimeURL): UserDto {
        TODO("Not yet implemented")
    }

    override fun update(user: UserDto): UserDto {
        TODO("Not yet implemented")
    }

    override fun disable(userId: UserId) {
        TODO("Not yet implemented")
    }

}