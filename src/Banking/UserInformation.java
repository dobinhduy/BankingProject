package Banking;


public class UserInformation
{
	String userName;
	String email;
	String phoneNo;
	String address;
	String occupation;
	String sex;
	String birthdate;
	String createDay;
    
	public UserInformation(String username, String email, String phoneNo, String address,
			String occupation, String sex, String birthdate,String crD)
	{
		
		this.userName=username;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.occupation = occupation;
		this.sex = sex;
		this.birthdate = birthdate;
		this.createDay=crD;
	} 
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCreateDay() {
		return createDay;
	}

	public void setCreateDay(String createDay) {
		this.createDay = createDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String toString()
	{
		return  "User name: " + userName + "\n" + "Email: " +email + "\n"
				+"Phone number: " + phoneNo + "\n" +"Address: "+ address + "\n" +
				"Occupation: " + occupation + "\n" +"Sex: " + sex
				+ "\n" + "Birthday: " +birthdate+ "\n"+ "Create Day: "+ createDay ;
	}
	
	
	
}
