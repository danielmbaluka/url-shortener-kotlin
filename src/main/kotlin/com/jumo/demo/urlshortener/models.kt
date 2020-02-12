package com.jumo.demo.urlshortener

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "urls")
class Url(
        @Id
        @GeneratedValue
        val id: Int = 0,
        val shortUrl: String,
        val longUrl: String
) {

}