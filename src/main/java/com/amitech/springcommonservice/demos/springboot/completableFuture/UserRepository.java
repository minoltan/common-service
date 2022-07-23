package com.amitech.springcommonservice.demos.springboot.completableFuture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
