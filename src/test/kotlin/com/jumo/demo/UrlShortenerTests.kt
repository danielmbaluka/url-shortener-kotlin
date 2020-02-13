package com.jumo.demo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlShortenerTests {
    @Test
    fun add(){
        Assertions.assertEquals(1, 1)
    }
}