package ar.edu.unlam.marvelcharactersunlam2.utils

import okio.ByteString.Companion.encodeUtf8

object HashGenerator {
    fun md5(string: String) : String {
        return try {
            val byteString = string.encodeUtf8()
            byteString.md5().hex()
        } catch (e: Exception) {
            ""
        }
    }
}