package day12.oop_多态_内部类_面向对象总结_调试Debug;
//多态经典案例
import java.util.Scanner;

//银行卡系统
public class ATMTest {
	public static void main(String[] args) {
		ABCATM atm = new ABCATM();
		UnionPay card = new ABCImpl(1000, "123456");
		atm.insertCard(card);
		atm.payTelBill(); //充值话费
		//atm.drawMoney();
		
	}
}

class ABCATM {
	UnionPay card;
	//这里如果用构造函数给card赋值可以，但不合适，因为来ATM办业务的不一定有卡
	public void insertCard(UnionPay card){
		this.card = card;
	}
	
	public void payTelBill(){ //支付电话费功能
		if(card instanceof ABC){ //判断是否农行卡
			ABC abcCard = (ABC)card;  //如果是农行卡，刚转换为农行卡
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入电话号码:");
			String phoneNum = scan.next();
			System.out.println("请输入充值金额 :");
			double sum = scan.nextDouble();
			if(abcCard.payTelBill(phoneNum, sum)){
				System.out.println("充值成功！");
			}else{
				System.out.println("充值失败！");
			}
		}else{
			System.out.println("只有农行卡才能充值话费！");
		}
		
	}
	
	public void drawMoney(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入密码:");
		String pwd = scan.nextLine();
		if(card.checkPwd(pwd)){
			System.out.println("请输入取款金额:");
			double number = scan.nextDouble();
			if(card.drawMoney(number)){
				System.out.println("取款成功！"+"余额为:"+card.getBalance());
			}else{
				System.out.println("余额不足！");
			}
		}else{
			System.out.println("密码错误！");
		}
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
		if(phoneNum.length()==11 && (this.balance-sum)>=-2000){
			this.balance-=sum;
			return true;
		}
		return false;
	}
}


