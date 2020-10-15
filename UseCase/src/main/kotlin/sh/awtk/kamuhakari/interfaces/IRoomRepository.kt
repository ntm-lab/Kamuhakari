package sh.awtk.kamuhakari.interfaces

import sh.awtk.kamuhakari.dto.Room
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

interface IRoomRepository {
    fun create(room: Room): Room
    fun findBy(roomId: RoomId): Room
    fun findBy(userId: UserId): Room
    fun update(room: Room): Room
    fun close(room: Room): RoomId
}