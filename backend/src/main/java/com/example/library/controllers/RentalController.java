package com.example.library.controllers;

import com.example.library.models.Rental;
import com.example.library.models.User;
import com.example.library.services.RentalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RentalController {
    private final RentalService rentalService;
    @GetMapping("/rental")
    public String rental(){
        return "rental";
    }
    @PostMapping("/rental")
    public ResponseEntity<?> saveRental(@RequestParam("bookTitle") String bookTitle,
                                     @RequestParam("readerEmail") String readerEmail) {
        log.info("In rental controller object" + bookTitle +  readerEmail);
        User lib = new User();
        try {
            lib = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if(bookTitle != null                && !bookTitle.isEmpty()
                && readerEmail != null      && !readerEmail.isEmpty()) {
            rentalService.save(bookTitle, lib.getEmail(), readerEmail);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @GetMapping("/rental-list")
    public List<Rental> rentalList() {
        List<Rental> list = rentalService.findAll();
        return list;
    }
}
