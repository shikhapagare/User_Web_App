package apex.user.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import apex.user.vo.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private JdbcTemplate templet;
	
	@Override
	public void addUser(User user) {
		
		System.out.println("UserDAOImpl:addUser():Start");
		
		String firstName=user.getFirstName();
		System.out.println(firstName);
		String middleName=user.getMiddleName();
		String lastName=user.getLastName();
		String gender=user.getGender();
		String address=user.getAddress();
		String city=user.getCity();
		String state=user.getState();
		String country=user.getCountry();
		String phoneNumber=user.getPhoneNumber();
		String bankName=user.getBankName();
		String accNo=user.getAccountNO();
		String ssnNo=user.getSsnNO();
		templet.update(
				"insert into user (f_name,m_name,l_name,gender,address,city,state,country,phone_number,bank_name,account_no,ssn_no) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)",firstName,middleName,lastName,gender,address,city,state,country,phoneNumber,bankName,accNo,ssnNo);
		System.out.println("UserDAOImpl:addUser():End");		
	}

	@Override
	public void updateUser(User user) {
		Integer id = user.getId();
		String firstName=user.getFirstName();
		System.out.println(firstName);
		String middleName=user.getMiddleName();
		String lastName=user.getLastName();
		String gender=user.getGender();
		String address=user.getAddress();
		String city=user.getCity();
		String state=user.getState();
		String country=user.getCountry();
		String phoneNumber=user.getPhoneNumber();
		String bankName=user.getBankName();
		String accNo=user.getAccountNO();
		String ssnNo=user.getSsnNO();
		templet.update("update user set f_name=?,m_name=?,l_name=?,gender=?,address=?,city=?,state=?,country=?,phone_number=?,bank_name=?,account_no=?,ssn_no=? where id=?",
				firstName,middleName,lastName,gender,address,city,state,country,phoneNumber,bankName,accNo,ssnNo,id);	
	}

	@Override
	public int deleteUser(int id) {
		int i = templet.update("delete from user where id=?",id);
		return i;
	}

	@Override
	public User getUserById(int id) {
		Map<String,Object> mapObj = (Map<String,Object>)templet.queryForMap("select * from user where id = ?",id);
		if(mapObj.isEmpty()) {
			return null;
		}else {
			return convertMapToUserObject(mapObj);
		}
	}
	
	public User convertMapToUserObject(Map<String, Object> mapObj) {
		
		User user = new User();
		user.setId((Integer)mapObj.get("id"));
		user.setFirstName((String)mapObj.get("f_name"));
		user.setMiddleName((String)mapObj.get("m_name"));
		user.setLastName((String)mapObj.get("l_name"));
		user.setGender((String)mapObj.get("gender"));
		user.setAddress((String)mapObj.get("address"));
		user.setCity((String)mapObj.get("city"));
		user.setState((String)mapObj.get("state"));
		user.setCountry((String)mapObj.get("country"));
		user.setPhoneNumber((String)mapObj.get("phone_number"));
		user.setBankName((String)mapObj.get("bank_name"));
		user.setAccountNO((String)mapObj.get("account_no"));
		user.setSsnNO((String)mapObj.get("ssn_no"));
		return user;
	}

}
