package com.example.library.services;

import com.example.library.models.Book;
import com.example.library.models.Image;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.library.repositories.BookRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> listBook(){
        List<Book> list = bookRepository.findAll();
        return list;
    }
    public List<Book> listBook(String title){

        List<Book> list = title == null || title == "" ? bookRepository.findAll() : bookRepository.findByTitleContains(title);
        return list;
    }
    public void saveBook(Book book, MultipartFile imageFile) throws IOException {
        Image image;
        if(imageFile.getSize() != 0){
            image = ImageService.toImageEntity(imageFile);
            book.setImage(image);
            image.setBook(book);
        }
        bookRepository.save(book);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById((id));
    }
    public Book getBook(Long id){
        return bookRepository.findById(id).orElse(null);
    }
}
