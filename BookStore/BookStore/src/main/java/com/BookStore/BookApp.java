package com.BookStore;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class BookApp {

			public static void main(String []a) {
			EntityManagerFactory factory = null;
				
		   try { 
			//connecting to database using persistence unit
					factory  = Persistence.createEntityManagerFactory("mn");
					EntityManager em = factory.createEntityManager();
					
					
		System.out.println("-----WELCOME TO BOOKSTORE DATABASES-----");
		  
		  
		BookStore book1 = new BookStore(1, "Whereabouts" , "Jhumpa lahiri", 599.0 , 30);
		BookStore book2 = new BookStore(2, "The Cristmas Pig" , "JK Rowling", 699.0 , 12);
		BookStore book3 = new BookStore(3, "Anamica" , "Suryakanth" ,  499.0 , 25);
		BookStore book4 = new BookStore(4, "Area Of Darkness" , "V.S.Naipal" , 899.0 , 10 );
		
						

		  BookDAO bDAO = new BookDAO(em);
		  
		  bDAO.createBookStore(book1);
		  bDAO.createBookStore(book2);
		  bDAO.createBookStore(book3);
		  bDAO.createBookStore(book4);
					
		    System.out.println("  Data added successfully  ");
					
	System.out.println("---------------------------------------------");

					int  newid = 3;
					String newbookname ="The Lean Startup" ;
					String newauthorname = "Eric Ries" ;
					double newprice = 999.0;
					int newstock = 45;
			
					
			bDAO.UpdateBookStore(newid, newbookname, newauthorname, newprice, newstock);
					
			
			System.out.println(" Data updated successfully ");
			
	     System.out.println("-----------------------------------------------");	
			
			System.out.println("  BookStore details based on the id  :");
							
							Optional<BookStore> bk1 = bDAO.getById(1);
							System.out.println(bk1);
							 
							bDAO.getById(1);
							
		       System.out.println("  Details of all the bookstore  ");	
							
							List<BookStore> allbk = bDAO.getAll();
			                System.out.println(allbk);
							
							System.out.println("  Data removes based on id : ");
							
							bDAO.removeById(1);
							
							System.out.println(" 1st record is removed ");

							
			System.out.println(" Data removed successfully  ");
			
		 System.out.println("-----------------------------------------------");	

			
		 System.out.println("____WELCOME TO AUTHOR DETAILS___");

         
         AuthorDAO authorDAO = new AuthorDAO(em);

        
         Author author1 = new Author();
         author1.setName("Jhumpa lahiri");

         Author author2 = new Author();
         author2.setName("JK Rowling");

         authorDAO.saveAuthor(author1);
         authorDAO.saveAuthor(author2);

        
         List<Author> allAuthors = authorDAO.findAllAuthors();
         System.out.println("All Authors: " + allAuthors);

         Author updatedAuthor = authorDAO.findAuthorById(1).orElse(null);
         if (updatedAuthor != null) {
             updatedAuthor.setName("Updated Author");
             authorDAO.updateAuthor(updatedAuthor);
         }

       
         authorDAO.removeAuthor(2);

    
         List<Author> updatedAuthors = authorDAO.findAllAuthors();
         System.out.println("Updated Authors: " + updatedAuthors);
			}
		   
		   
				catch (HibernateException e) {
							 e.printStackTrace();
							
						}
				catch (Exception e) {
						 e.printStackTrace();
						// System.out.println(" Exception ");
						}

		        	}
		
	
}
