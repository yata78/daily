package com.example.daily;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface dailyEvRepository extends JpaRepository<dailyEv, Long> {

    @Query(value = "SELECT * FROM daily_ev WHERE id = ?1", nativeQuery = true)
    Optional<dailyEv> findByIdCustom(Long id);
}
