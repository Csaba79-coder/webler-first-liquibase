package hu.webler.weblerfirstliquibase.service;

import hu.webler.weblerfirstliquibase.entity.Writer;
import hu.webler.weblerfirstliquibase.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WriterService {

    private final WriterRepository writerRepository;

    public List<Writer> findAllWriters() {
        return writerRepository.findAll();
    }

    public Writer saveWriter(Writer writer) {
        return writerRepository.save(writer);
    }

    public void deleteWriter(Long id) {
        Writer writer = findWriterById(id);
        writerRepository.delete(writer);
    }

    public Writer findWriterById(Long id) {
        /*Optional<Writer> existingWriter = writerRepository.findById(id);
        if (existingWriter.isPresent()) {
            return existingWriter.get();
        } else {
            throw new RuntimeException("Writer not found with id: " + id);
        }*/
        return writerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Writer not found with id: " + id));
    }

    public Writer findWriterByName(String name) {
        return writerRepository.findWritersByNameIgnoreCase(name);
    }
}
