package com.BookStore;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Author {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	
	    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	    private List<BookStore> books;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<BookStore> getBooks() {
			return books;
		}
		public void setBooks(List<BookStore> books) {
			this.books = books;
		}
		@Override
		public String toString() {
			return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
		}
		public Author() {
			super();
		
		}
		public Author(int id, String name, List<BookStore> books) {
			super();
			this.id = id;
			this.name = name;
			this.books = books;
		}
		
	    
	}