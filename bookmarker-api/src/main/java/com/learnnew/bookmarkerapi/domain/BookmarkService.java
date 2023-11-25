package com.learnnew.bookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.time.Instant;
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
        //Page<BookmarkDTO> bookmarkPage = repository.findAll(pageable).map(bookmark -> bookmarkMa+
        // pper.toDto(bookmark)); bookmark to bookmarkDTO
        Page<BookmarkDTO> bookmarkPage = repository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkPage);
    }

    @Transactional
    public BookmarksDTO searchBookmarks(String query, Integer page){
        int pageNo = page < 1 ? 0 : page - 1;
        PageRequest pageable = PageRequest.of(pageNo,10, Sort.Direction.DESC,"createdAt");
        Page<BookmarkDTO> bookmarkPage = repository.searchBookmarks(query,pageable);
        Page<BookmarkVM> bookmarkPage1 = repository.findByTitleContainsIgnoreCase(query,pageable);
        return new BookmarksDTO(bookmarkPage);
    }

    public BookmarkDTO createBookmark(CreateBookmarkRequest request){
        Bookmark bookmark = new Bookmark(null,request.getTitle(),Instant.now());
        Bookmark bookmarkSaved = repository.save(bookmark);
        return bookmarkMapper.toDto(bookmarkSaved);
    }
    public List<Bookmark> getAllBookmarks(){
        return repository.findAll();
    }
}
