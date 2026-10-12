package dev.idris.content_calendar.controller;

import dev.idris.content_calendar.model.Content;
import dev.idris.content_calendar.repository.ContentControllerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/Content")
public class ContentController {
    private final ContentControllerRepository repository;

    // DI!
    public ContentController(ContentControllerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

    @PutMapping("/{id}")
    public void update(
        @RequestBody Content content,
        @PathVariable Integer id
    ) {
        repository.upsert(content, id);
    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable Integer id
    ) {
        repository.delete(id);
    }
}