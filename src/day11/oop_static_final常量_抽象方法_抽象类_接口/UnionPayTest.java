package day11.oop_static_final常量_抽象方法_抽象类_接口;

import java.util.Scanner;

//银行卡系统
public class UnionPayTest {
	public static void main(String[] args) {
		ICBCImpl card1 = new ICBCImpl(2000,"123456"); //工行卡
		ICBC	 card2 = new ICBCImpl(2000,"123456"); //工行卡
		
		UnionPay card3 = new ABCImpl(2000,"123456"); //银联卡
		Scanner input = new Scanner(System.in);
		System.out.println("请输入密码：");
		String pwd = input.next();
		if(card3.checkPwd(pwd)){
			System.out.println("请输入金额：");
			double money = input.nextDouble();
			if(card3.drawMoney(money)){
				System.out.println("取钱成功！卡内余额为："+card3.getBalance());
			}else{
				System.out.println("取钱失败！");
			}
		}else{
			System.out.println("密码错误！");
		}
		input.close();
	}
}
//银联卡接口
interface UnionPay{
	public abstract double getBalance(); //查询余额
	public abstract boolean drawMoney(double number);//取钱
	public abstract boolean checkPwd(String input);//验证密码
}
//工行卡接口
interface ICBC extends UnionPay{
	public abstract void payOnline(double number);//在线支付
}
//农行卡接口
interface ABC extends UnionPay{
	public abstract boolean payTelBill(String phoneNum,double sum);//话费充值
}
//工行卡实现
class ICBCImpl implements ICBC{
	private double money;
	private String pwd;
	public ICBCImpl(double money,String pwd) {
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public double getBalance() {
		return money;
	}
	@Override
	public boolean drawMoney(double number) {
		if(number<=money){
			money-=number;
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {
		if(input.equals(pwd)){
			return true;
		}
		return false;
	}
	@Override
	public void payOnline(double number) {
		if(number<money){
			money-=number;
		}
	}
}
//农行卡实现
class ABCImpl implements ABC{
	private double balance;
	private String password;
	
	public ABCImpl(double balance,String password) {
		this.balance = balance;
		this.password = password;
	}
	@Override
	public double getBalance() {
		return this.balance;
	}
	@Override
	public boolean drawMoney(double number) {
		if((this.balance-number)>=-2000){
			this.balance-=number;
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {
		if(input.equals(this.password)){
			return true;
		}
		return false;
	}
	@Override
	public boolean payTelBill(String phoneNum,double sum) {
		if(phoneNum.length()==11 && (this.balance-sum)<=-2000){
			this.balance-=sum;
			return true;
		}
		return false;
	}
}


