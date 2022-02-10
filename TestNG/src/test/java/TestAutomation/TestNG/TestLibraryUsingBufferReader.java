package TestAutomation.TestNG;

import static org.testng.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import org.testng.annotations.*;
public class TestLibraryUsingBufferReader {
	Library lib;
	final static String DELIMITER = ",";
	private static final String a = null;
	private static File csvFile = new File("src/test/resources/input.csv");
	@DataProvider(name = "Hello")
	public Object[][] membernames() {
		BufferedReader br = null;
		BufferedReader br1 = null;
		String str = null;
		String header[] = null;
		int row = 0;
		try {
			br1 = new BufferedReader(new FileReader("src/test/resources/input.csv"));
			while ((str = br1.readLine()) != null) {
				row++;
			}
		} catch (Exception e) {
		}
		int count = 0;
		Object[][] arr = new Object[row - 1][5];
		int index = 0;
		try {
			br = new BufferedReader(new FileReader("src/test/resources/input.csv"));
			while ((str = br.readLine()) != null) {
				if (count == 0) {
					header = str.split(",");
				} else {
					Object a[] = str.split(",");
					arr[index] = a;
					index++;
				}
				count++;
			}
		} catch (Exception e) {
		}
		return arr;
	}
	//	
	@Test(dataProvider = "Hello")
	public void testLibraryaddmember(int id, String fname, String lname, String city, int age,String status) {
		lib = new Library();
	
		System.out.println("Calling test add Member for : " + fname);
		//int initialSize = lib.getMembers();
		//lib.addNewMember(new Member(id, fname, lname, city, age,status));
		//assertEquals(lib.getMembers(), initialSize + 1);
	}
}


