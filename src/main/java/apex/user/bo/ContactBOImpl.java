package apex.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apex.user.dao.ContactDAO;
import apex.user.vo.User;

@Service
public class ContactBOImpl implements ContactBO {

	@Autowired
	ContactDAO contactDAO = null;
	@Override
	public void addContact(User user) {
		contactDAO.addContact(user);
	}

	@Override
	public void updateContact(User user) {
		
	}

	@Override
	public User getContact(int id) {
		return null;
	}

	@Override
	public void deleteContact(int id) {
		
	}

}
