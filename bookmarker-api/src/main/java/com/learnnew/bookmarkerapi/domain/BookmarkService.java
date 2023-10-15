package com.learnnew.bookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    @Autowired
    private final BookmarkRepository repository;
    public List<Bookmark> getBookmarks(){
        return repository.findAll();
    }
}
