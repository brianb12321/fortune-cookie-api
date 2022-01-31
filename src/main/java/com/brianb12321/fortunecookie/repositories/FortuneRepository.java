package com.brianb12321.fortunecookie.repositories;

import com.brianb12321.fortunecookie.models.FortuneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FortuneRepository extends JpaRepository<FortuneModel, Long> {
    @Query(value = "SELECT fortune_id FROM dbo.fortune WHERE is_misfortune = 1", nativeQuery = true)
    long[] getAllFortuneIdUsingMisfortuneIsTrue();
    @Query(value = "SELECT fortune_id FROM dbo.fortune WHERE is_misfortune = 0", nativeQuery = true)
    long[] getAllFortuneIdUsingMisfortuneIsFalse();
}