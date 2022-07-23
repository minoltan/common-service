package com.amitech.springcommonservice.demos.springboot.ModalParentChild;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
}
