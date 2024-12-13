package com.miage.oil.controller;

import com.miage.oil.entity.Dice;
import com.miage.oil.entity.DiceRollLog;
import com.miage.oil.repository.DiceRepository;
import com.miage.oil.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiceController {
    @Autowired
    private final DiceRepository diceRepository;
    private final DiceService diceService;

    public DiceController(DiceRepository diceRepository, DiceService diceService) {
        this.diceRepository = diceRepository;

        this.diceService = diceService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/rollDice")
    public int rollDice() {
        return diceService.rollDices(1).get(0);
    }

    @GetMapping("/rollDices/{X}")
    public List<Integer> rollDices(@PathVariable int X) {
        return diceService.rollDices(X);

    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> diceLogs() {
        return diceRepository.findAll();
    }
}
