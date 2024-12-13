package com.miage.oil.service;

import com.miage.oil.entity.Dice;
import com.miage.oil.entity.DiceRollLog;
import com.miage.oil.repository.DiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {
    @Autowired
    private DiceRepository diceRepository;

    public List<Integer> rollDices(int X) {
        Dice dice = new Dice();
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < X; ++i) {
            dice.roll();
            results.add(dice.getValue());
        }

        // save in repository
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(X);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRepository.save(log);
        return results;
    }
}
