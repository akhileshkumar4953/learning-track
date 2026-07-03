package com.learningtrack.learning_track.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.learningtrack.learning_track.dto.request.TopicRequest;
import com.learningtrack.learning_track.dto.response.TopicResponse;
import com.learningtrack.learning_track.service.TopicService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/topics")
@RequiredArgsConstructor
@CrossOrigin
public class TopicController {

    private final TopicService service;

    @PostMapping
    public TopicResponse save(@Valid @RequestBody TopicRequest request) {
        return service.save(request);
    }

    @GetMapping
    public List<TopicResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TopicResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public TopicResponse update(@PathVariable Long id,
                                @RequestBody TopicRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<TopicResponse> search(@RequestParam String keyword) {

        return service.search(keyword);

    }

    @GetMapping("/page")
    public Page<TopicResponse> page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getAll(page, size);

    }
    

    

    
    @GetMapping("/status/{status}")
    public List<TopicResponse> getByStatus(@PathVariable com.learningtrack.learning_track.enums.Status status) {

        return service.getByStatus(status);

    }
    
    @GetMapping("/priority/{priority}")
    public List<TopicResponse> getByPriority(@PathVariable com.learningtrack.learning_track.enums.Priority priority) {

        return service.getByPriority(priority);

    }
    
    @PatchMapping("/{id}/complete")
    public TopicResponse markCompleted(@PathVariable Long id) {

        return service.markCompleted(id);

    }

}