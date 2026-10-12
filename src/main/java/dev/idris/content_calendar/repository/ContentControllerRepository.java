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
import java.util.stream.IntStream;

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

        Content c2 = new Content(
                2,
                "My Second Blog",
                "My second blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(c);
        contentList.add(c2);
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    public void upsert(Content content, Integer id) {
        int foundIndex = IntStream.range(0, contentList.size())
                .filter(i -> contentList.get(i).id().equals(id))
                .findFirst()
                .orElse(-1);

        if(foundIndex != -1) {
            contentList.set(foundIndex, content);
        }
        else {
            contentList.add(content);
        }
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}