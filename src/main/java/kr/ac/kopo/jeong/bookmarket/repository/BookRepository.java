package kr.ac.kopo.jeong.bookmarket.repository;

import kr.ac.kopo.jeong.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category);
}
