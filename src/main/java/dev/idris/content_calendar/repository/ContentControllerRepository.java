package dev.idris.content_calendar.repository;

import dev.idris.content_calendar.model.Content;
import dev.idris.content_calendar.model.Status;
import dev.idris.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentControllerRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentControllerRepository() {}

    @PostConstruct
    public void init() {
        Content c = new Content(
           1,
           "My First Blog",
           "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(c);
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }
}