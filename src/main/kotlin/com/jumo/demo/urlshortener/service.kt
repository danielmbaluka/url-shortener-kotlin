package com.jumo.demo.urlshortener

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LinkService(@Autowired private val repository: UrlRepository) {
    val PORT: String = "8081"

    fun generateHash(): String {
        var hash = java.util.UUID.randomUUID().toString().substring(0, 4)

        while (repository.existsByShortUrl(hash)) {
            hash = java.util.UUID.randomUUID().toString().substring(0, 4)
        }

        return hash
    }

    fun createUrl(urlDto: UrlDto): Url {
        return repository.save(Url(0, generateHash(), urlDto.url))
    }

    fun createUrlFromHash(hash: String) = "http://localhost:$PORT/$hash"

    fun findByShortUrl(shortUrl: String) = repository.findByShortUrl(shortUrl)

    fun findAll() = repository.findAll().map { url -> UrlDto(url.longUrl, createUrlFromHash(url.shortUrl)) }
}