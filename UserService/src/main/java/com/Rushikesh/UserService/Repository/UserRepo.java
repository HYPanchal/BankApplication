package com.Rushikesh.UserService.Repository;

import com.Rushikesh.UserService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User getBybankCode(String code);
}
