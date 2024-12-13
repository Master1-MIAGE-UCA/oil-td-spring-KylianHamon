package com.miage.oil.repository;
import com.miage.oil.entity.DiceRollLog;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DiceRepository extends JpaRepository<DiceRollLog, Long> {
}