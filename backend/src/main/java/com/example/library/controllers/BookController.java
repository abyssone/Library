package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.models.User;
import com.example.library.services.BookService;
import com.example.library.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final UserService userService;

    @GetMapping("/")
    public List<Book> main(@RequestParam(name = "title", required = false) String title, Principal principal, Model model){
//        model.addAttribute("main", bookService.listBook(title));
//        model.addAttribute("user", userService.getUserByPrincipal(principal));
        if(principal != null) log.info(principal.toString());
        return bookService.listBook();
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
    public Book presentBook(@PathVariable Long id, Model model){
//        model.addAttribute("book", bookService.getBook(id));
//        model.addAttribute("image", bookService.getBook(id).getImage());
        return bookService.getBook(id);
    }
}
