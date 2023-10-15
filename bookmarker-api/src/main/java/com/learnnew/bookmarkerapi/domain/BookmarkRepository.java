package com.learnnew.bookmarkerapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {

}
