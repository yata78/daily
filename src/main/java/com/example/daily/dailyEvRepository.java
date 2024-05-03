package com.example.daily;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dailyEvRepository extends JpaRepository<dailyEv, Integer> {

}
