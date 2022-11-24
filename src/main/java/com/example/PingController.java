package com.example;

import com.example.model.Ping;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/ping")
class PingController {

    @Post
    String ping(Ping request) {
        if (request.getName() == null) {
            return "pong";
        }
        return request.getName();
    }
}
