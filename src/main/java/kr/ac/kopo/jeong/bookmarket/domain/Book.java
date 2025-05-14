package kr.ac.kopo.jeong.bookmarket.domain;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class Book {
    @Pattern(regexp = "isbn[0-9]+")
    private String bookId;
    @Size(min = 4, max = 50)
    private String name;
    @Min(0)
    @Digits(integer = 8, fraction = 2)
    @NotNull
    private BigDecimal unitPrice;
    private String author;
    private String description;
    private String publisher;
    private String category;
    private long unitsInStock;
    private String releaseDate;
    private String condition;
    private String fileName;
    private MultipartFile bookImage;
}
