package com.omkar.springboot_kafka.repository;

import com.omkar.springboot_kafka.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends JpaRepository<Employ, Long> {
}
