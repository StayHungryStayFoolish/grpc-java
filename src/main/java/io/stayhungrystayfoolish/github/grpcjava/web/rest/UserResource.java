package io.stayhungrystayfoolish.github.grpcjava.web.rest;

import io.stayhungrystayfoolish.github.grpcjava.domain.User;
import io.stayhungrystayfoolish.github.grpcjava.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by bonismo@hotmail.com on 2019/3/11 10:50 AM
 *
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {


        logger.debug("REST find user by id : {}", id);
        Optional<User> user = userService.findById(id);
        return ResponseEntity.of(user);
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.debug("REST create user : {}", user);
        User newUser = userService.save(user);
        return ResponseEntity.ok().body(newUser);
    }
}
