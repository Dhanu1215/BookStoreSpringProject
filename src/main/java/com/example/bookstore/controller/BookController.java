package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.dto.ResponseDTO;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.IBookService;

/**
 * Rest Controller to handle the all rest calls
 * 
 * @RestController : BookController
 * @author praja
 */
@RestController
@CrossOrigin
@RequestMapping("/bookstore")
public class BookController {

	/**
	 * @Autowired : Marks a constructor, field, setter method, or configure method
	 *            as to be autowired by Spring's dependency injection facilities.
	 */
	@Autowired
	private IBookService bookservice;

	/**
	 * Call Get method to handle get call It returns book details
	 * 
	 * @return : Http Status & book details
	 */
	@RequestMapping("/getbooks")
	public ResponseEntity<ResponseDTO> getBooks() {
		List<Book> bookList = null;
		bookList = bookservice.getBooks();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", bookList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call Get method It returns book details by book Id
	 * 
	 * @param id : book Id
	 * @return : book details of the person
	 */
	@GetMapping("/get/{bookId}")
	public ResponseEntity<ResponseDTO> getBookById(@PathVariable("bookId") long bookId) {
		Book book = null;
		book = bookservice.getBookById(bookId);
		ResponseDTO respDTO = new ResponseDTO("Get book by id call successful", book);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call put method to update details It update the book details of person by id.
	 * 
	 * @param bookDTO : book details.
	 * @return : details
	 */
	@PutMapping("/update/{bookId}")
	public ResponseEntity<ResponseDTO> updateBookById(@PathVariable("bookId") long bookId,
			@RequestBody BookDTO bookDTO) {
		Book book = null;
		book = bookservice.updateBookById(bookId, bookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Book Details Successfully", book);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method to add details It creates the book details
	 * 
	 * @param bookDTO : book details
	 * @return : details
	 */
	@PostMapping("/addbook")
	public ResponseEntity<ResponseDTO> addBookDetails(@RequestBody BookDTO bookDTO) {
		Book book = null;
		book = bookservice.addBookDetails(bookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Book Details Successfully", book);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call delete method to remove book details It delete the book details by book
	 * id
	 * 
	 * @param id : book id
	 * @return : book id which is deleted
	 */
	@DeleteMapping("/remove/{bookId}")
	public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable("bookId") long bookId) {
		bookservice.deleteBookDetails(bookId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Book details Successfully", "Deleted id : " + bookId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Get book by book name
	 * 
	 * @param bookName
	 * @return
	 */
	@GetMapping("/getbook/{bookName}")
	public ResponseEntity<ResponseDTO> getBookByName(@PathVariable("bookName") String bookName) {
		Book book = null;
		book = bookservice.getBookByName(bookName);
		ResponseDTO respDTO = new ResponseDTO("Get book by name call successful", book);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Update book quantity with reference of book id.
	 * 
	 * @param bookId
	 * @param quantity
	 * @return
	 */
	@PutMapping("/updateqty/{bookId}/{bookQty}")
	public ResponseEntity<ResponseDTO> updateBookQuantity(@PathVariable("bookId") long bookId,
			@PathVariable("bookQty") long quantity) {
		Book book = null;
		book = bookservice.updateBookQuantity(bookId, quantity);
		ResponseDTO respDTO = new ResponseDTO("Book Qty updated successfully", book);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Update book price by book id.
	 * 
	 * @param bookId100
	 * @param price
	 * @return
	 */
	@PutMapping("/updateprice/{bookId}/{bookprice}")
	public ResponseEntity<ResponseDTO> updateBookPrice(@PathVariable("bookId") long bookId,
			@PathVariable("bookprice") long price) {
		Book book = null;
		book = bookservice.updateBookPrice(bookId, price);
		ResponseDTO respDTO = new ResponseDTO("Book price updated successfully", book);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
