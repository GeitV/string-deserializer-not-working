package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class PingTest(
    @Client("/") private val client: HttpClient
) : StringSpec({

    fun doRequest(data: String?): String? {
        val name = if (data == null) "null" else "\"$data\""
        val request = HttpRequest.POST(
            "/ping", """{"name": $name, "otherField": 123}"""
        )

        val response = client.toBlocking().exchange(request, String::class.java)
        response.status shouldBe HttpStatus.OK
        return response.body()
    }

    "send null to ping endpoint" {
        doRequest(null) shouldBe "pong"
    }

    "send empty string to ping endpoint" {
        doRequest("") shouldBe "pong"
    }

    "send msg to ping endpoint, give back sent data" {
        doRequest("random") shouldBe "random"
    }

})