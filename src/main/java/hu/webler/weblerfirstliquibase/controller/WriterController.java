package hu.webler.weblerfirstliquibase.controller;

import hu.webler.weblerfirstliquibase.entity.Writer;
import hu.webler.weblerfirstliquibase.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WriterController {

    private final WriterService writerService;

    @GetMapping("/writers")
    public List<Writer> renderAllWriters() {
        return writerService.findAllWriters();
    }

    @PostMapping("/writers")
    public Writer addNewWriter(@RequestBody Writer writer) {
        return writerService.saveWriter(writer);
    }

    @DeleteMapping("/writers/{id}")
    public void deleteWriter(@PathVariable Long id) {
        writerService.deleteWriter(id);
    }
}
