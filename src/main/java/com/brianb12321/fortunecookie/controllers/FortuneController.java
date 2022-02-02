package com.brianb12321.fortunecookie.controllers;

import com.brianb12321.fortunecookie.models.FortuneModel;
import com.brianb12321.fortunecookie.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping(path="/api/v1/fortune")
public class FortuneController {
    private final FortuneService fortuneService;

    @Autowired
    public FortuneController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @GetMapping
    public Optional<FortuneModel> GetRandomFortune() {
        long[] fortunes = fortuneService.getAllFortuneId();
        long[] misfortunes = fortuneService.getAllMisfortuneId();

        Random random = new Random();
        int randomValue = random.nextInt(100);
        if(misfortunes.length > 0 && randomValue > 90) {
            return fortuneService.getFortuneById(misfortunes[random.nextInt(misfortunes.length)]);
        }
        if(fortunes.length > 0) {
            return fortuneService.getFortuneById(fortunes[random.nextInt(fortunes.length)]);
        }
        return Optional.empty();
    }
    @GetMapping("{fortuneId}")
    public FortuneModel getFortuneById(@PathVariable long fortuneId) {
        Optional<FortuneModel> model = fortuneService.getFortuneById(fortuneId);

        if(model.isEmpty()) {
            throw new IllegalArgumentException(String.format("The fortune id %d does not exist", fortuneId));
        }

        return model.get();
    }

    @PostMapping
    public void addFortune(@RequestBody FortuneModel body) {
        fortuneService.addFortuneModel(body);
    }
}