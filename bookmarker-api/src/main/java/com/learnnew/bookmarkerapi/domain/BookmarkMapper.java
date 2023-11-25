package com.learnnew.bookmarkerapi.domain;

import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
    public BookmarkDTO toDto(Bookmark bookmark){
        BookmarkDTO dto = new BookmarkDTO(bookmark.getId(),bookmark.getTitle(),bookmark.getCreatedAt());
        return dto;
    }
}
