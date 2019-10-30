package wen.mockmvc.repository;

import wen.mockmvc.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockRepository extends JpaRepository<User, Long> {
}

