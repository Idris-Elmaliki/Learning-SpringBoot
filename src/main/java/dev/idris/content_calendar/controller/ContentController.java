package dev.idris.content_calendar.controller;

import dev.idris.content_calendar.model.Content;
import dev.idris.content_calendar.repository.ContentControllerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Content")
public class ContentController {
    private final ContentControllerRepository repository;

    public ContentController(ContentControllerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }
}