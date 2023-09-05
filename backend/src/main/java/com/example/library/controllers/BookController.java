package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public List<Book> main(@RequestParam(name = "title", required = false) String title, Principal principal){
        if(principal != null) log.info(principal.toString());
        log.info(title);
        return bookService.listBook(title);
    }
    @PostMapping("/bookcreate")
    public String createBook(@RequestParam("imageFile") MultipartFile imageFile, Book book) throws IOException{
        bookService.saveBook(book, imageFile);
        return "redirect:/";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public Book presentBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

}
