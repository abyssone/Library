package com.example.library.services;

import com.example.library.models.Rental;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.RentalRepository;
import com.example.library.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public List<Rental> findAll(){
        List<Rental> result = rentalRepository.findAll();
        return result;
    }
    public void save(Rental rental){
        rentalRepository.save(rental);
    }
    public void save(String bookTitle, String librarianEmail, String readerEmail){
        log.info("In rental service object" + bookTitle, librarianEmail, readerEmail);
        Rental rental = new Rental();
        rental.setBook(bookRepository.findByTitle(bookTitle).get(0));
        rental.setLibrarian(userRepository.findByEmail(librarianEmail));
        rental.setReader(userRepository.findByEmail(readerEmail));
        rentalRepository.save(rental);
    }
}
