package com.learnnew.bookmarkerapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CreateBookmarkRequest {
    @NotEmpty(message = "Title should be mentioned")
    private String title;
}
