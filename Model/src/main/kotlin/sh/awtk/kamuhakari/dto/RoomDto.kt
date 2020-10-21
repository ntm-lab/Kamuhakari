package sh.awtk.kamuhakari.dto

import sh.awtk.kamuhakari.vo.MailList
import sh.awtk.kamuhakari.vo.NumOfParticipants
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.RoomRawId
import sh.awtk.kamuhakari.vo.UserId

data class RoomDto(
    val id: RoomId,
    val owner: UserId,
    val numOfParticipants: NumOfParticipants,
    val mailList: MailList = MailList(mutableListOf())
)