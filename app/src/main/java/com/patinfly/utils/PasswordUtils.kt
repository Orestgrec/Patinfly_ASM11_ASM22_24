package com.patinfly.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.util.Base64


object PasswordUtils {
    // Generate a random salt
    @Throws(NoSuchAlgorithmException::class)
    fun getSalt(): String {
        val sr = SecureRandom.getInstance("SHA1PRNG")
        val salt = ByteArray(16)
        sr.nextBytes(salt)
        return Base64.getEncoder().encodeToString(salt)
    }

    // Hash a password with the given salt
    @Throws(NoSuchAlgorithmException::class)
    fun hashPassword(password: String, salt: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        md.update(Base64.getDecoder().decode(salt))
        val hashedPassword = md.digest(password.toByteArray())
        return Base64.getEncoder().encodeToString(hashedPassword)
    }
}