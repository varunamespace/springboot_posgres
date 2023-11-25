package com.learnnew.bookmarkerapi.api;

import com.learnnew.bookmarkerapi.domain.Bookmark;
import com.learnnew.bookmarkerapi.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
/*@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})*/
class BookmarkControllerTest {
    @Autowired
    private MockMvc mvc;

    /*BookmarkRepository repository;
    private List<Bookmark> bookmarks;

    void setUp(){
        bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark(null,"test_containers", Instant.now()));
        repository.saveAll(bookmarks);
    }*/

    @Test
    public void shouldGetBookmarks() throws Exception{
        mvc.perform(get("/bookmarks"))
                .andExpect(status().isOk());
    }
    @Test
    public void checkTotalElements() throws Exception{
        mvc.perform(get("/bookmarks"))
                .andExpect(jsonPath("$.totalElements",CoreMatchers.equalTo(2)));
    }
}