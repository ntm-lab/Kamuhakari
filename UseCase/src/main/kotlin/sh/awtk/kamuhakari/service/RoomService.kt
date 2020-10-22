package sh.awtk.kamuhakari.service

import org.joda.time.DateTime
import sh.awtk.kamuhakari.dto.RoomDto
import sh.awtk.kamuhakari.dto.UserDto
import sh.awtk.kamuhakari.interfaces.IRoomRepository
import sh.awtk.kamuhakari.interfaces.IRoomService
import sh.awtk.kamuhakari.interfaces.IUserRepository
import sh.awtk.kamuhakari.vo.OneTimeURL
import sh.awtk.kamuhakari.vo.RoomId
import sh.awtk.kamuhakari.vo.UserId

class RoomService(
    private val userRepository: IUserRepository,
    private val roomRepository: IRoomRepository
) : IRoomService {
    override fun create(roomDto: RoomDto): List<UserDto> {
        val id = ""// TODO:  UUID生成
        val userList: MutableList<UserDto> = mutableListOf()
        roomRepository.create(roomDto)
        for (i in 0..roomDto.numOfParticipants.value) {
            userList.add(
                userRepository.create(
                    UserDto(
                        UserId(0),
                        RoomId(id),
                        OneTimeURL(""),//todo: one time urlの生成
                        true
                    )
                )
            )
        }
        return userList
    }
}