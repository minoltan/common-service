package com.amitech.springcommonservice.demos.springboot.transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
}
