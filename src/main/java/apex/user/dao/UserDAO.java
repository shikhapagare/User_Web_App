package apex.user.dao;

import apex.user.vo.User;

public interface UserDAO {
	public void addUser(User user);
	public void updateUser(User user);
	public int deleteUser(int id);
	public User getUserById(int id);
}
