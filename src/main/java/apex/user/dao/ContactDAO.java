package apex.user.dao;

import apex.user.vo.User;

public interface ContactDAO {
	public void addContact(User user);
	public void updateContact(User user);
	public User getContact(int id);
	public void deleteContact(int id);
}
