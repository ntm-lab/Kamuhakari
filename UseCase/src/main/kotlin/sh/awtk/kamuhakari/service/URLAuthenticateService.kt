package sh.awtk.kamuhakari.service

import org.joda.time.DateTime
import sh.awtk.kamuhakari.dto.TokenPair
import sh.awtk.kamuhakari.exception.AuthenticationException
import sh.awtk.kamuhakari.interfaces.IURLAuthenticateService
import sh.awtk.kamuhakari.interfaces.IUserRepository
import sh.awtk.kamuhakari.jwt.JWTFactory
import sh.awtk.kamuhakari.vo.OneTimeURL

class URLAuthenticateService(
    private val userRepository: IUserRepository
) : IURLAuthenticateService {
    override fun authURL(key: String): TokenPair {
        val user = userRepository.findBy(OneTimeURL(key))
        if (!user.isActiveURL && DateTime.now() > user.expireAt) throw AuthenticationException(
            "out dated url",
            "無効なURLです"
        )
        user.isActiveURL = false
        userRepository.update(user)
        val aToken = JWTFactory.newToken(user.id.value, user.roomId.value, user.expireAt)
        return TokenPair(
            aToken,
            "not implemented"
        )
    }

    override fun disableURL(key: String) {
        val user = userRepository.findBy(OneTimeURL(key)).also { it.isActiveURL = false }
        userRepository.update(user)
    }
}