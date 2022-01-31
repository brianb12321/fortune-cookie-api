package com.brianb12321.fortunecookie.services.implementations;

import com.brianb12321.fortunecookie.models.FortuneModel;
import com.brianb12321.fortunecookie.repositories.FortuneRepository;
import com.brianb12321.fortunecookie.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FortuneServiceImpl implements FortuneService {

    private final FortuneRepository repository;

    @Autowired
    @Lazy
    public FortuneServiceImpl(FortuneRepository repository) {
        this.repository = repository;
    }

    @Override
    public long[] getAllFortuneId() {
        return repository.getAllFortuneIdUsingMisfortuneIsTrue();
    }

    @Override
    public long[] getAllMisfortuneId() {
        return repository.getAllFortuneIdUsingMisfortuneIsFalse();
    }

    @Override
    public Optional<FortuneModel> getFortuneById(long id) {
        return repository.findById(id);
    }
}