package hu.webler.weblerfirstliquibase.repository;

import hu.webler.weblerfirstliquibase.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
