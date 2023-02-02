package com.tts;
import java.util.HashMap;

public class Library {
	// Add the missing implementation to this class

	// Instance variables:
	HashMap<String, Book> books = new HashMap<>();
	static String OpeningHours = "9am to 5pm";
	String address;

	// Constructor:
	public Library(String address) {
		this.address = address;
	}

	// Methods:
	public void addBook(Book book) {
		books.put(book.getTitle(), book);
	}

	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from " + OpeningHours);
	}

	public void printAddress() {
		System.out.println(address);
	}

	// finds out if book is borrowed or not:
	// if book is not borrowed, it will let you borrow it.
	// else if it's already borrowed it'll let you know
	// else if the book is not in the catalog it'll let you know.
	private void borrowBook(String title) {
		if (books.containsKey(title) && books.get(title).isBorrowed()==false) {
			books.get(title).borrowed();			
			System.out.println("You have successfully borrowed " + title + ".");
		} 
		else if (books.containsKey(title) && books.get(title).isBorrowed() == true) {
			System.out.println("Sorry, this book is already borrowed");
		} else {
			if (!books.containsKey(title)) {
				System.out.println("Sorry, this book is not in our catalog.");
			}
		}
	}
	
	//if the library does not have that book/books it'll let you know
	//if the library does have that book/books it'll show the ones 
	//available.
	public void printAvailableBooks() {
		if (books.isEmpty()) {
			System.out.println("No book in catalog");
		}
		for (String availBooks : books.keySet()) {
			if (books.get(availBooks).isBorrowed() == false) {
				System.out.println(availBooks);
			}
		}
	}

	//finds out if the book is burrowed and if so let's you return it
	//else if the book has not been burrowed it'll let you know
	public void returnBook(String title) {
		if (books.containsKey(title) && books.get(title).isBorrowed() == true) {
			// return the book
			books.get(title).returned();
			System.out.println("You successfully returned " + title);
		} else {
			System.out.println("Sorry, book cannot be returned because it has not been burrowed.");
		}
	}
	

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();

		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}

}
