package com.learnnew.bookmarkerapi.domain;

import com.learnnew.bookmarkerapi.BookmarkDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    @Autowired
    private final BookmarkRepository repository;
    public BookmarkDTO getBookmarks(Integer page){
        int pageNo = page < 1 ? 0 : page - 1;
        PageRequest pageable = PageRequest.of(page,10, Sort.Direction.DESC,"createdAt");
        return new BookmarkDTO(repository.findAll(pageable));
    }
    public List<Bookmark> getAllBookmarks(){
        return repository.findAll();
    }
}
