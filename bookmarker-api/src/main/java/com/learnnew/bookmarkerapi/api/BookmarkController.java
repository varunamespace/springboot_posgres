package com.learnnew.bookmarkerapi.api;

import com.learnnew.bookmarkerapi.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookmarkController {
    @Autowired
    private final BookmarkService bookmarkService;
    @RequestMapping("/index")
    public String helloBookmark(){
        return "Hello bookmarks";
    }
    @RequestMapping("/bookmarks")
    public BookmarksDTO getByPage(@RequestParam(name = "page",defaultValue = "1") Integer page,@RequestParam(name = "query",required = false) String query)
    {
        if(query== null || query.trim().length()==0){
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query,page);
    }
    @RequestMapping("/bookmark")
    public List<Bookmark> getAll(){
        return bookmarkService.getAllBookmarks();
    }

    @PostMapping("/bookmarks")
    public BookmarkDTO createBookmarks(@RequestBody @Valid CreateBookmarkRequest request){
        return bookmarkService.createBookmark(request);
    }
}
