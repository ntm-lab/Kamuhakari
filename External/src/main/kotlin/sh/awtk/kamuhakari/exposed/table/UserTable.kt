package sh.awtk.kamuhakari.exposed.table

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.Column
import org.joda.time.DateTime

object UserTable : LongIdTable("User") {
    var roomId: Column<EntityID<Long>> = reference("room_id", RoomTable)
    var oneTimeURL: Column<String> = varchar("one_time_url", 256)
    var expiredAt: Column<DateTime> = datetime("expired_at")
}

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(UserTable)

    var roomId by RoomEntity referencedOn UserTable.roomId
    var oneTimeURL by UserTable.oneTimeURL
    var expiredAt by UserTable.expiredAt
}