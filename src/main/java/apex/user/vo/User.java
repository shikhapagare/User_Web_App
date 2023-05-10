package apex.user.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class User {

	private int id;
	@NotBlank(message="First Name should not be blank")
	private String firstName;

	private String lastName;
	private String middleName;
	private String gender;
	
	@NotBlank(message="Address should not be blank")
	private String address;
	
	@NotBlank(message="City should not be blank")
	private String city;
	
	@NotBlank(message="State should not be blank")
	private String state;
	
	@NotBlank(message="Country should not be blank")
	private String country;
	
	@Min(value= 10, message = "Length of Phone Number should be 10.")
	private String phoneNumber;
	
	private String bankName;
	
	@NotBlank(message="Account Number should not be blank")
	private String accountNO;
	
	@NotBlank(message="SSN Number should not be blank")
	private String ssnNO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNO() {
		return accountNO;
	}
	public void setAccountNO(String accountNO) {
		this.accountNO = accountNO;
	}
	public String getSsnNO() {
		return ssnNO;
	}
	public void setSsnNO(String ssnNO) {
		this.ssnNO = ssnNO;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", gender=" + gender + ", address=" + address + ", city=" + city + ", state=" + state + ", country="
				+ country + ", phoneNumber=" + phoneNumber + ", bankName=" + bankName + ", accountNO=" + accountNO
				+ ", ssnNO=" + ssnNO + "]";
	}
	
	
}
