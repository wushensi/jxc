/*1：设计一个银行帐户类，具有户名，帐号，余额等 属性，以及存款、取款等方法，并对此
类进行测试*/
package cn.javass.c6.work;

import java.util.Scanner;

public class Zy01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account=new Account();
		account.initAccount(account);
		System.out.println(account);
		//account.withdraw(account);
		//account.deposit(account);
	}

}
class Account{
	private String accountId;
	private String name;
	private double balance;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(Account account){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入取款金额/t");
		double cash=scan.nextDouble();
		account.setBalance(account.getBalance()-cash);
		System.out.println("本次取款"+cash+" ，账户余额剩余"+account.getBalance());
		System.out.println(account);
	}
	
	public void deposit(Account account){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入存款金额/t");
		double cash=scan.nextDouble();
		account.setBalance(account.getBalance()+cash);
		System.out.println("本次存款"+cash+" ，账户余额剩余"+account.getBalance());
		System.out.println(account);
	}
	
	public void initAccount(Account account){
		account.setAccountId("1");
		account.setName("user");
		account.setBalance(123.321);
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name
				+ ", balance=" + balance + "]";
	}
}
