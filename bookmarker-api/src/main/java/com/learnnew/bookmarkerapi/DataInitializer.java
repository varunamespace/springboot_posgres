package com.learnnew.bookmarkerapi;

import com.learnnew.bookmarkerapi.domain.Bookmark;
import com.learnnew.bookmarkerapi.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Bookmark(null,"learner",Instant.now()));
        repository.save(new Bookmark(null, "leaner",Instant.now()));
    }
}

