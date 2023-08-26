package com.example.library.repositories;

import com.example.library.models.Book;
import com.example.library.models.Rental;
import com.example.library.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    Rental findByLibrarian(User librarian);
    Rental findByReader(User reader);
    Rental findByBook(Book book);
}
