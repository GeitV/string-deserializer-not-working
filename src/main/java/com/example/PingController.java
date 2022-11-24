package com.example;

import com.example.model.Ping;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@Controller("/ping")
class PingController {

    @Post
    @ExecuteOn(TaskExecutors.IO)
    String ping(Ping request) {
        if (request.getName() == null) {
            return "pong";
        }
        return request.getName();
    }
}
