package ar.edu.unlam.marvelcharactersunlam2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform