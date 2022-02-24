package com.codeclan.example.flickbait.repositories;

import com.codeclan.example.flickbait.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
