package sh.awtk.kamuhakari.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.util.*

object JWTFactory {
    lateinit var algorithm: Algorithm
    lateinit var issuer: String
    lateinit var audience: String
    lateinit var verifyer: JWTVerifier

    fun init() {
        this.verifyer = JWT.require(algorithm).withAudience(audience).withIssuer(issuer).build()
    }

    fun newToken(userId: Long): String {
        return JWT.create().withIssuer(issuer).withAudience(audience).withClaim("user_id", userId)
                .withExpiresAt(calcExpires()).sign(algorithm)
    }

    private fun calcExpires(): Date = DateTime.now(DateTimeZone.UTC).plusDays(7).toDate()
}