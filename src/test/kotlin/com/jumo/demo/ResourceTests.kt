package com.jumo.demo

import com.jumo.demo.urlshortener.UrlDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@DataJpaTest
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResourceTests @Autowired constructor() {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `When Url does not exist then response is 404`(){

        val result = testRestTemplate.getForEntity("/api/v1/urls", UrlDto::class.java)
        Assertions.assertEquals(result.statusCode, HttpStatus.NOT_FOUND)

    }

}