package sh.awtk.kamuhakari.interfaces

import sh.awtk.kamuhakari.dto.TokenPair

interface IURLAuthenticateService {
    fun authURL(key: String): TokenPair
    fun disableURL(key: String)
}