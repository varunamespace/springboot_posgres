package com.learnnew.bookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository repository;
    private final BookmarkMapper bookmarkMapper;
    @Transactional
    public BookmarksDTO getBookmarks(Integer page){
        int pageNo = page < 1 ? 0 : page - 1;
        PageRequest pageable = PageRequest.of(pageNo,10, Sort.Direction.DESC,"createdAt");
        //Page<BookmarkDTO> bookmarkPage = repository.findAll(pageable).map(bookmark -> bookmarkMapper.toDto(bookmark)); bookmark to bookmarkDTO
        Page<BookmarkDTO> bookmarkPage = repository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkPage);
    }
    public List<Bookmark> getAllBookmarks(){
        return repository.findAll();
    }
}
