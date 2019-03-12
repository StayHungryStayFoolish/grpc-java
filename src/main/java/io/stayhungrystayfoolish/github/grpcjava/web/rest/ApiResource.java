package io.stayhungrystayfoolish.github.grpcjava.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com on 2019/3/8 10:23 AM
 *
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
public class ApiResource implements Serializable {

    @GetMapping("/test")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("Hello world !");
    }
}


