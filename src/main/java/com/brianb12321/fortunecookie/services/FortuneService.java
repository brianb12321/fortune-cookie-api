package com.brianb12321.fortunecookie.services;

import com.brianb12321.fortunecookie.models.FortuneModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface FortuneService {
    long[] getAllFortuneId();
    long[] getAllMisfortuneId();

    Optional<FortuneModel> getFortuneById(long id);
}
