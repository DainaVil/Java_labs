package com.example.tests.repository;

import com.example.tests.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRoleID(Long roleID);
}
