package io.stayhungrystayfoolish.github.grpcjava.service.impl;

import io.stayhungrystayfoolish.github.grpcjava.domain.User;
import io.stayhungrystayfoolish.github.grpcjava.repository.UserRepository;
import io.stayhungrystayfoolish.github.grpcjava.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by bonismo@hotmail.com on 2019/3/11 10:45 AM
 *
 * @Description:
 * @Version: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
