package CRUDstudentDatabaseMariaDB;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String postCode;
	private String postOffice;
	
	public Student() {
		
		
	}
	public Student(int id, String firstName, String lastName,String streetAddress,String postCode, String postOffice){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.postCode = postCode;
		this.postOffice = postOffice;
		
	}
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName =" + lastName + ", streetAddress =" + streetAddress +", postCode = "+ postCode+ ", postOffice ="+postOffice+"]";
	}

}
