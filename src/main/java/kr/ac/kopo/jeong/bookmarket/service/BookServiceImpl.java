package kr.ac.kopo.jeong.bookmarket.service;

import kr.ac.kopo.jeong.bookmarket.domain.Book;
import kr.ac.kopo.jeong.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    public Book getBookById(String bookId) {
        return bookRepository.getBookById(bookId);
    }
}
