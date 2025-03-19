package kr.ac.kopo.jeong.bookmarket.repository;

import kr.ac.kopo.jeong.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> bookList = new ArrayList<>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        bookList.add(book1);
        book1.setBookId("isbn0001");
        book1.setName("스프링부트완전정복");
        book1.setUnitPrice(BigDecimal.valueOf(35000));
        book1.setAuthor("송미영");
        book1.setDescription("《개념부터 실전 프로젝트까지 스프링 부트 완전정복》은 기능 위주의 실습으로 스프링 부트의 기본 개념과 원리를 쉽게 익힐 수 있습니다. 체계적인 단계별 실습으로 전반적인 코딩 지식을 얻고 쇼핑몰 구축 프로젝트 실습으로 실전 웹 애플리케이션 개발을 위한 이해력과 응용력을 높일 수도 있습니다.");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT교재");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2024/12/31");
        book1.setCondition("신규도서");

        bookList.add(book1);
    }

    @Override
    public List<Book> getAllBookList() {
        return bookList;
    }
}
