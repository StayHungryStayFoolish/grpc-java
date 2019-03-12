package io.stayhungrystayfoolish.github.grpcjava.service;

import io.stayhungrystayfoolish.github.grpcjava.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by bonismo@hotmail.com on 2019/3/11 10:44 AM
 *
 * @Description:
 * @Version: 1.0
 */
public interface UserService {

    User save(User user);

    Optional<User> findById(Long id);
}

