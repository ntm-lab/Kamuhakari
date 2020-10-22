package sh.awtk.kamuhakari.exposed.repository

import sh.awtk.kamuhakari.dto.RoomDto
import sh.awtk.kamuhakari.exception.ObjectNotFoundException
import sh.awtk.kamuhakari.exposed.table.RoomEntity
import sh.awtk.kamuhakari.exposed.table.RoomTable
import sh.awtk.kamuhakari.exposed.table.UserEntity
import sh.awtk.kamuhakari.interfaces.IRoomRepository
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

class RoomRepository : IRoomRepository {
    override fun create(room: RoomDto): RoomDto = RoomEntity.new {
        rawId = room.id.value
        owner =
            UserEntity.findById(room.owner.value) ?: throw ObjectNotFoundException("fail to find user")
        numOfParticipants = room.numOfParticipants.value
    }.toDto()

    override fun findBy(roomId: RoomId): RoomDto =
        RoomEntity.find { RoomTable.rawId eq roomId.value }.firstOrNull()?.toDto()
            ?: throw ObjectNotFoundException("room id ${roomId.value} is not found")

    override fun findBy(userId: UserId): RoomDto =
        RoomEntity.find { RoomTable.owner eq userId.value }.firstOrNull()?.toDto()
            ?: throw ObjectNotFoundException("user ${userId.value} is not found")

    override fun update(room: RoomDto): RoomDto =
        RoomEntity.find { RoomTable.rawId eq room.id.value }.firstOrNull()?.also {
            it.rawId = room.id.value
            it.owner = UserEntity.findById(room.owner.value)
                ?: throw ObjectNotFoundException("user ${room.owner.value} is not found")
            it.numOfParticipants = room.numOfParticipants.value
        }?.toDto() ?: throw ObjectNotFoundException("room id ${room.id} is not found")

    override fun close(room: RoomDto): RoomId {
        TODO("Not yet implemented")
    }

}