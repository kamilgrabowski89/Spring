package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {


        Set<Author> authorSet = new HashSet<>();
        authorSet.add(new Author("Kamil", "Grabowski"));
        authorSet.add(new Author("Robert", "Grabowski"));

        Book book = new Book();
        book.setTitle("Title book");
        book.setAuthorSet(authorSet);

        Category category = new Category("News");
        book.setCategory(category);
        book.setAuthorSet(authorSet);
        bookRepository.save(book);


//        List<Book> all = bookRepository.findAll();
//        for (Book b: all){
//            System.out.println(b.getTitle());
//            System.out.println(b.getAuthor());
//            System.out.println(b.getCategory());


    }
}
