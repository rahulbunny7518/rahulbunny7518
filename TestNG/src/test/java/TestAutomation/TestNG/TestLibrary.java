package TestAutomation.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import TestAutomation.TestNG.exception.BookDoesNotExist;
import TestAutomation.TestNG.exception.MemberDoesNotExist;
import TestAutomation.TestNG.exception.MemberIsInactive;

public class TestLibrary {

	Library lib;
	
	
	@BeforeGroups(groups = {"basicOperation","Alltests"})
	public void initializeLibrary()
	{
		lib = new Library();
		lib.setCatalouge(new Catalogue());
		lib.setAdmin(new Admin(lib));
		
		System.out.println("Initializing Library");
		
		lib.getCatalouge().addBook(new Book(1, "Angels & Demons", "Dan Brown"));
		lib.getCatalouge().addBook(new Book(2, "Lost Symbol", "Dan Brown"));
		lib.getCatalouge().addBook(new Book(3, "Ramayana", "Valmiki"));
	}
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testAddMember()
	{
		System.out.println(lib.getMembers().size());
		
		int initialSize = lib.getMembers().size();
		lib.addMember(new Member(4, "Hanish", "Rao", "Adb", 22));
		assertEquals(lib.getMembers().size(), initialSize + 1);
		
		System.out.println(lib.getMembers().size());

		
	}
	
	@Test(groups = {"basicOperation","Alltests"}, dataProvider = "csvdataprovider2")
	public void testAddMember(int memberID, String firstname, String lastName, String city, int age)
	{
		int initialSize = lib.getMembers().size();
		lib.addMember(new Member(memberID, firstname, lastName, city, age));
		assertEquals(lib.getMembers().size(), initialSize + 1);
	}
	
	
	
	@DataProvider(name = "csvdataprovider")
	private Object[][] csvReader() throws Exception
	{
		Object[][] data = new Object[100][5];
		int index = 0;
		  CSVReader reader = new CSVReader(new FileReader("src/main/resources/Input.csv"));
	      
	      String line[];
	      while ((line = reader.readNext()) != null) {
	         data[index][0] = Integer.parseInt(line[0]);
	         data[index][1] = line[1];
	         data[index][2] = line[2];
	         data[index][3] = line[3];
	         data[index][4] = Integer.parseInt(line[4]);
	         index++;
	      }
	      reader.close();
	      return data;
	      
	}
	
	
	
	@DataProvider(name = "csvdataprovider2")
	private Iterator<Object[]> csvReader2() throws Exception
	{
		List<Object[]> data = new ArrayList();
		
		  CSVReader reader = new CSVReader(new FileReader("src/main/resources/Input.csv"));
	      String line[];
	      while ((line = reader.readNext()) != null) {
	    	  Object[] member = new Object[5];
	         member[0] = Integer.parseInt(line[0]);
	         member[1] = line[1];
	         member[2] = line[2];
	         member[3] = line[3];
	         member[4] = Integer.parseInt(line[4]);
	         
	         data.add(member);
	         
	      }
	      reader.close();
	    
	      return data.iterator();
	      
	}
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testActivateUser()
	{
		int initialSize = lib.getMembers().size();
		

		lib.addMember(new Member(5,"Pavan","Fraud","USA",23));
		//Member mb=new Member(5,"Pavan","Fraud","USA",23);
		//lib.addMember(mb);
		//mb.activate();
		//lib.addMember(mb);
		
		lib.findMemberById(5).activate();
		assertEquals(lib.getMembers().size(), initialSize+1);
		
		assertEquals(lib.findMemberById(5).getStatus(),MemberStatus.ACTIVE);
	}
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testdeActivateUser()
	{
		int initialSize = lib.getMembers().size();
		Member mb=new Member(6,"Daya","Koppula","Nirmal",23);
		lib.addMember(mb);
		mb.deActivate();
		
		assertEquals(lib.findMemberById(6).getStatus(),MemberStatus.INACTIVE);



	}
	
	
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testIssueBook()
	{
		
		
		Book bk=new Book(10, "Pushpa", "Sukumar");
		Member mb=new Member(13,"Karthik","Reddy","Warangal",23);
		
		lib.addMember(mb);

		lib.getCatalouge().addBook(bk);//this is optional
		//mb.issueBook(bk);
		
		lib.findMemberById(13).issueBook(bk);
		System.out.println(lib.findMemberById(13).getIssuedBookList().size());

		assertEquals(lib.findMemberById(13).getIssuedBookList().size(),1);
	}
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testFindMemberById()
	{
		Member mb=lib.findMemberById(1);
		assertNotNull(mb);
		
		Member mb2=lib.findMemberById(122);
		assertNull(mb2);
		
		
	}
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testAssignBookToMember() throws MemberDoesNotExist, MemberIsInactive, BookDoesNotExist
	{
		Book bk=new Book(11, "PushpaTheRule", "Sukku");
		lib.getCatalouge().addBook(bk);
		lib.addMember(new Member(14,"Calcy","Batch","Shamashabad",23));
		lib.getAdmin().assignBookToMember(11,14);
		
		assertEquals(lib.findMemberById(14).getIssuedBookList().size(),1);

	}
	
	
	
	
	
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testAddBook()
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();
		lib.getCatalouge().addBook(new Book(6,"Baahubali","SS Rajamouli"));
		
		//assertEquals(lib.getCatalouge().getBooks().size(),initialSize+1);this is also correct
		assertEquals(lib.getCatalouge().getCatalogueSize(),initialSize+1);
		
		Book book=lib.getCatalouge().findBookById(3);
		assertEquals(book.getNameOfTheBook(),"Ramayana");
		assertEquals(book.getAuthorOfTheBook(),"Valmiki");
		
		
		
	}
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testRemoveBook()
	{
		System.out.println(lib.getCatalouge().getCatalogueSize());
		//lib.getCatalouge().addBook(new Book(6,"Baahubali","SS Rajamouli"));
		int initialSize = lib.getCatalouge().getCatalogueSize();
		lib.getCatalouge().removeBook(6);
		
		System.out.println(lib.getCatalouge().getCatalogueSize());

		
		assertEquals(lib.getCatalouge().getCatalogueSize(),initialSize-1);
	}
	
	
	@Test(groups = {"basicOperation","Alltests"})
	public void testSearchByBookName()
	{
		Book book = lib.getCatalouge().searchBook("Pushpa");
		
		assertNotNull(book);
	
	}
	
	@Test(groups = {"Alltests","basicOperation"})
	public void testAddToLibrary() throws Exception
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();
		lib.getCatalouge().addToLibrary(new Book(25, "Baahu", "Raj"));
		
		
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize + 1);
		
	}
	
	@Test(groups = {"Alltests","basicOperation"})
	public void testFindBookById()
	{
		Book bt=lib.getCatalouge().findBookById(1);
		assertNotNull(bt);
	}

	

	
	
	
}
