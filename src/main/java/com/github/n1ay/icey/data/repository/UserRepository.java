package com.github.n1ay.icey.data.repository;

import com.github.n1ay.icey.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
