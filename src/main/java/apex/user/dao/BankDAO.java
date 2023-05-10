package apex.user.dao;

import apex.user.vo.User;

public interface BankDAO {

	public void addBankDtl(User user);
	public void updateBankDtl(User user);
	public User getBankDtl(int id);
	public void deleteBankDtl(int id);
}
