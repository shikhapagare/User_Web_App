package apex.user.bo;

import apex.user.vo.User;

public interface BankBO {

	public void addBankDtl(User user);
	public void updateBankDtl(User user);
	public User getBankDtl(int id);
	public void deleteBankDtl(int id);
}
