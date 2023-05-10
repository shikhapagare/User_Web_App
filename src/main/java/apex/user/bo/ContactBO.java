package apex.user.bo;

import apex.user.vo.User;

public interface ContactBO {
	public void addContact(User user);
	public void updateContact(User user);
	public User getContact(int id);
	public void deleteContact(int id);
}
