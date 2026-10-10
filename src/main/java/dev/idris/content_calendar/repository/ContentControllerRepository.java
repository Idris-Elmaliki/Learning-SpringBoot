package dev.idris.content_calendar.repository;

import dev.idris.content_calendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentControllerRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentControllerRepository() {}

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }
}