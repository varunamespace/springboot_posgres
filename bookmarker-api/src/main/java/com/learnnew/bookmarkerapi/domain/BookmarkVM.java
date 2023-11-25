package com.learnnew.bookmarkerapi.domain;

import java.time.Instant;

public interface BookmarkVM {
    Long getId();
    String getTitle();
    Instant getCreatedAt();
}
