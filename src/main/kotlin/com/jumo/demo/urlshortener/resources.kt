package com.jumo.demo.urlshortener

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/urls")
class UrlsController(@Autowired private val service: LinkService) {

    @GetMapping("")
    fun getUrls(model: Model): List<UrlDto> = service.findAll()

    @PostMapping("")
    fun createUrl(@RequestBody urlDto: UrlDto): UrlDto {
        val instance: Url = service.createUrl(urlDto)
        return UrlDto(instance.longUrl, service.createUrlFromHash(instance.shortUrl))
    }

}

@Controller
class RedirectController(private val service: LinkService) {

    @GetMapping("/{shortUrl}")
    fun redirect(@PathVariable("shortUrl") shortUrl: String): ResponseEntity<Any> {
        val url: Url? = service.findByShortUrl(shortUrl)

        if (url == null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            val headers = HttpHeaders()
            headers.add("Location", url.longUrl)
            return ResponseEntity("", headers, HttpStatus.FOUND)
        }
    }
}