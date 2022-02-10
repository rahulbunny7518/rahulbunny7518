package TestAutomation.TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestCatalogue2 {
	
	
	@Test
	public void testCatalogueAddBook()
	{
		Catalogue cat=new Catalogue();
		cat.addBook(new Book(1,"Angels & Demons","Dan Brown"));
		
		assertEquals(cat.getCatalogueSize(), 1);
	}
	
	@Test
	public void testCatalogueRemoveBook()
	{
		Catalogue ct=new Catalogue();
		ct.addBook(new Book(1,"Book1","Author1"));
		
		System.out.println(ct.getCatalogueSize());


		//ct.removeBook(1);
		
		//System.out.println("size "+ct.getCatalogueSize());
		
		//assertEquals(ct.getCatalogueSize(), 0);
	}

}
