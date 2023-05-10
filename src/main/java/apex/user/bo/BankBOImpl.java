package apex.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apex.user.dao.BankDAO;
import apex.user.vo.User;

@Service
public class BankBOImpl implements BankBO {

	@Autowired
	BankDAO bankDAO =null;
	@Override
	public void addBankDtl(User user) {
		bankDAO.addBankDtl(user);
	}

	@Override
	public void updateBankDtl(User user) {
		
	}

	@Override
	public User getBankDtl(int id) {
		return null;
	}

	@Override
	public void deleteBankDtl(int id) {
		
	}

}
