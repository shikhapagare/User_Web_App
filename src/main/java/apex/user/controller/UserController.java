package apex.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import apex.user.bo.BankBO;
import apex.user.bo.ContactBO;
import apex.user.bo.UserBO;
import apex.user.vo.User;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserBO userBO = null;
	
	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
	
	@RequestMapping("/entryadduser.do")
	public String entryAddUser(@ModelAttribute("user")User user) {

	       return "PersonalInfo";
	}
	
	@RequestMapping("/adduser.do")
	public String addUser( @ModelAttribute("user") @Valid User user,BindingResult result){
		
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getGender());
		
		System.out.println("1111 "+result.hasErrors());
		
		return "ContactInfo";
		
		/*
		 * if (result.hasErrors()) { return "PersonalInfo"; }else { return
		 * "ContactInfo"; }
		 */
	}
	
	@RequestMapping("/addcontact.do")
	public String addContact(@ModelAttribute("user")@Valid User user,BindingResult result) {
		
		System.out.println(user.getAddress());
		System.out.println(user.getCity());
		System.out.println(user.getState());
		System.out.println(user.getCountry());
		System.out.println(user.getPhoneNumber());

		/*
		if (result.hasErrors()) {
	        return "ContactInfo";
	    }else {
	    	return "BankInfo";
	    }*/
		
		return "BankInfo";
	}
	
	@RequestMapping("/addbank.do")
	public String addBankDtl(@ModelAttribute("user") @Valid User user,BindingResult result,SessionStatus status) {
		
		System.out.println(user.getBankName());
		System.out.println(user.getAccountNO());
		System.out.println(user.getSsnNO());
		
		status.setComplete();
		
		/*
		if (result.hasErrors()) {
	        return "BankInfo";
	    }else {
	    	//userBO.addUser(user);
	    	return "Success";
	    }
		*/
		userBO.addUser(user);
		
    	return "Success";
	}
	
	@RequestMapping("/updateuser.do")
	public String updateUser(@ModelAttribute("user") User user){
		return "UpdateUser";
	}
	
	@RequestMapping("/updateuserbyid.do")
	public String updateUserById(@ModelAttribute("user") User user,Model model){
		System.out.println("User Id "+user.getId());
		
		User userObj = userBO.getUserById(user.getId());
		System.out.println(userObj.getFirstName());
		System.out.println(userObj.getPhoneNumber());
		System.out.println(userObj.getGender());
		System.out.println(userObj.getAccountNO());
		System.out.println(userObj.getSsnNO());
		
		if(userObj!=null) {
			model.addAttribute("userObj", userObj);
			return "UpdateUserDtl";
		} else {
			return "ErrorPage";
		}
		
	}
	
	@RequestMapping("/updateuserdtl.do")
	public String updateUserDtl(@ModelAttribute("user") User user,SessionStatus status){
		
		System.out.println("User Id "+user.getId());
		System.out.println(user.getFirstName());
		System.out.println(user.getPhoneNumber());
		System.out.println(user.getGender());
		System.out.println(user.getAccountNO());
		System.out.println(user.getSsnNO());
		
		userBO.updateUser(user);
		status.setComplete();
		return "Success";
	}
	
	@RequestMapping("/viewuser.do")
	public String vieweUser(@ModelAttribute("user") User user){
		
		return "ViewUser";
	}
	
	@RequestMapping("/viewuserdtl.do")
	public String viewUserById(@ModelAttribute("user") User user,Model model){
		
		System.out.println("User Id "+user.getId());
		
		User userObj = userBO.getUserById(user.getId());
		if(userObj!=null) {
			model.addAttribute("viewUser", userObj);
			return "ViewUserDtl";
		}else {
			return "ErrorPage";
		}
		
	}
	
	@RequestMapping("/deleteuser.do")
	public String deleteUser(@ModelAttribute("user") User user){
		
		return "DeleteUser";
	}
	
	@RequestMapping("/deleteuserdtl.do")
	public String deleteUserDtl(@ModelAttribute("user") User user,Model model){
		System.out.println("User Id "+user.getId());
		model.addAttribute("id", user.getId());
		
		model.addAttribute("fName",user.getFirstName());
		Boolean flag = userBO.deleteUser(user.getId());
		System.out.println("flag "+flag);

		if(flag) {
			return "DeleteUserSuccess";
		}else {
			return "ErrorPage";
		}
	}

}
