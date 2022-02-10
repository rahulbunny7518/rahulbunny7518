package TestAutomation.TestNG;
import java.util.ArrayList;

public class Member {
	private int memberID;
	private String firstName;
	private String lastName;
	private String city;
	private int age;
	private MemberStatus status;
	private ArrayList<Book> issuedBookList;
	
	/*
	 * public Member() { this.issuedBookList=new ArrayList<Book>();
	 * 
	 * }
	 */
	public Member(int memberID, String firstname, String lastName, String city, int age) {
		
		//this();
	
		this.memberID = memberID;
		this.firstName = firstname;
		this.lastName = lastName;
		this.city = city;
		this.age = age;
		this.status = MemberStatus.ACTIVE;

		this.issuedBookList=new ArrayList<Book>();
	}
	
	
	
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MemberStatus getStatus() {
		return status;
	}
	public void setStatus(MemberStatus status) {
		this.status = status;
	}
	public ArrayList<Book> getIssuedBookList() {
		return issuedBookList;
	}
	public void setIssuedBookList(ArrayList<Book> issuedBookList) {
		this.issuedBookList = issuedBookList;
	}
	
	
	
	
	public void activate()
	{
		this.status = MemberStatus.ACTIVE;
	}
	
	public void deActivate()
	{
		this.status = MemberStatus.INACTIVE;
	}
	
	
	public void issueBook(Book book)
	{
		this.issuedBookList.add(book);
	}


}
