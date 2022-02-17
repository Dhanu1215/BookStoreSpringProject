package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.UserRepository;

/**
 * PersonService : Business logic
 * 
 * @author praja
 *
 */
@Service
public class BookService implements IBookService {

	/**
	 * Introducing Dao layer to store the data in database
	 */
	@Autowired
	private BookRepository bookrepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserService service;

	/**
	 * Call Get method
	 * 
	 * @return : book details
	 */
	@Override
	public List<Book> getBooks() {
		return bookrepo.findAll();
	}

	/**
	 * Call Get method
	 * 
	 * @param id : book Id
	 * @return : book details
	 */
	@Override
	public Book getBookById(long bookId) {
		return bookrepo.findById(bookId).get();
	}

	/**
	 * Call post method to add details
	 * 
	 * @param bookDTO : book details
	 * @return : details
	 */
	@Override
	public Book addBookDetails(BookDTO bookDTO) {
		Book details = null;
		details = new Book(bookDTO);
		return bookrepo.save(details);
	}

	/**
	 * Call delete method to remove book details
	 * 
	 * @param id : book id
	 * @return : book id which is deleted
	 */
	@Override
	public void deleteBookDetails(long bookId) {
		bookrepo.deleteById(bookId);
	}

	/**
	 * Call put method to update details
	 * 
	 * @param bookDTO : book details
	 * @return : details
	 */
	@Override
	public Book updateBookById(long bookId, BookDTO bookDTO) {
		Book details = this.getBookById(bookId);
		details.updateBookData(bookDTO);
		return bookrepo.save(details);
	}

	/**
	 * Get book by book name
	 * 
	 * @param bookName
	 * @return
	 */
	@Override
	public Book getBookByName(String bookName) {
		return bookrepo.findByBookName(bookName);
	}

	/**
	 * Update book quantity with reference of book id.
	 * 
	 * @param bookId
	 * @param quantity
	 * @return
	 */
	@Override
	public Book updateBookQuantity(long bookId, long quantity) {
		Book details = this.getBookById(bookId);
		details.setQuantity(quantity);
		return bookrepo.save(details);
	}

	/**
	 * Update book price by book id.
	 * 
	 * @param bookId
	 * @param price
	 * @return
	 */
	@Override
	public Book updateBookPrice(long bookId, long price) {
		Book details = this.getBookById(bookId);
		details.setPrice(price);
		return bookrepo.save(details);
	}

}
