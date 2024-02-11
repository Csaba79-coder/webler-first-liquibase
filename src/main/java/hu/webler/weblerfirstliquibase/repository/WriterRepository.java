package hu.webler.weblerfirstliquibase.repository;

import hu.webler.weblerfirstliquibase.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {

    Optional<Writer> findById(Long id);
    Writer findWritersByNameIgnoreCase(String name);
}
