package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.model.Book;

public interface IBookService {

	Book addBookDetails(BookDTO bookDTO);

	void deleteBookDetails(long bookId);

	List<Book> getBooks();

	Book getBookById(long bookId);

	Book updateBookById(long bookId, BookDTO bookDTO);

	Book getBookByName(String bookName);

	Book updateBookQuantity(long bookId, long quantity);

	Book updateBookPrice(long bookId, long price);

}
