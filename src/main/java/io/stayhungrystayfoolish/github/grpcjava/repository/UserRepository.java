package io.stayhungrystayfoolish.github.grpcjava.repository;

import io.stayhungrystayfoolish.github.grpcjava.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bonismo@hotmail.com on 2019/3/11 10:22 AM
 *
 * @Description:
 * @Version: 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
