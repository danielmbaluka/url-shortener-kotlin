package com.jumo.demo

import com.jumo.demo.urlshortener.Url
import com.jumo.demo.urlshortener.UrlRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
class RepositoryTests @Autowired constructor(val entityManager: TestEntityManager, val urlRepository: UrlRepository) {
    @Test
    fun `When findByShortUrl then return Url`(){
        val shortUrl = "goog"
        val longUrl = "http://google.com"

        val google = Url(0,shortUrl, longUrl)

        entityManager.persist(google)
        entityManager.flush()

        val found = urlRepository.findByShortUrl(shortUrl)
        Assertions.assertEquals(google.id, found?.id)
    }
}