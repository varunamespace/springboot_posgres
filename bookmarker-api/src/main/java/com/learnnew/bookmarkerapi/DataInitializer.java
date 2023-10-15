package com.learnnew.bookmarkerapi;

import com.learnnew.bookmarkerapi.domain.Bookmark;
import com.learnnew.bookmarkerapi.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.time.Instant;

@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Bookmark(null,"learner", Instant.now()));
        repository.save(new Bookmark(null,"poradd",Instant.now()));
        repository.save(new Bookmark(null,"haloo",Instant.now()));
    }
}
