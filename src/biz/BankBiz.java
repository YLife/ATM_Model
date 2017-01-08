package biz;

/**
 * 业务层接口
 * @author YangLun
 *
 */
public interface BankBiz {
	
	int TRADETYPE_DEPOSIT = 1;
	int TRADETYPE_WITHDRAW = 2;
	String A = "Accout is not exist !";
	String P = "Password is wrong !";
	String S = "Success !";
	String B = "Balance is not enough !";
	String E = "Error !";
	String MSO = "The modified password can not match the original password !";
	
	/**
	 * 查询该账户是否存在
	 * @param cardId
	 * @return
	 */
	String findAccount(String cardId);
	
	/**
	 * 校验账户信息是否正确
	 * @param cardId
	 * @param pwd
	 * @return
	 */
	String checkAccount(String cardId , String pwd);
	
	/**
	 * 查询余额
	 * @param cardId
	 * @return
	 */
	double getBalance(String cardId);
	
	/**
	 * 存款
	 * @param cardId
	 * @return
	 */
	String deposit(String cardId , double money);
	
	/**
	 * 取款
	 * @param cardId
	 * @param money
	 * @return
	 */
	String withDraw(String cardId , double money);
	
	/**
	 * 转账
	 * @param outCardId
	 * @param inCardId
	 * @param money
	 * @return
	 */
	String trans(String outCardId , String inCardId , double money);
	
	/**
	 * 修改密码
	 * @param cardId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	String modifyPwd(String cardId , String oldPwd , String newPwd);
}
