package com.jumo.demo.urlshortener

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository: JpaRepository<Url, Long>{

    fun findByShortUrl(shortUrl: String): Url?

    fun existsByShortUrl(shortUrl: String): Boolean

}