package sh.awtk.kamuhakari.exposed.table

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.Column
import sh.awtk.kamuhakari.dto.RoomDto
import sh.awtk.kamuhakari.vo.NumOfParticipants
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

object RoomTable : LongIdTable("Room") {
    var rowId: Column<String> = varchar("row_id", 256)
    var owner: Column<EntityID<Long>> = reference("owner", UserTable)
    var numOfParticipants: Column<Int> = integer("participants")
}

class RoomEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<RoomEntity>(RoomTable)

    var rowId by RoomTable.rowId
    var owner by UserEntity referencedOn RoomTable.owner
    var numOfParticipants by RoomTable.numOfParticipants
    fun toDto(): RoomDto {
        return RoomDto(
            RoomId(rowId),
            UserId(owner.id.value),
            NumOfParticipants(numOfParticipants)
        )
    }
}