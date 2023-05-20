import java.util.Random;

public class Account {
    protected int accNo;
    protected int pin;
    protected int type;
    protected Customer customer;
    protected double balance;
    protected double overDraftLimit;
    protected boolean isSuspended;
    protected boolean isActive;
    protected boolean noticeNeeded;

    public Account(int accNo,Customer customer,int pin){
        this.accNo =accNo;
        this.customer =customer;
        this.pin = pin;
        this.balance=0.0;
        this.isActive=true;
    }

    public Account() {

    }

    public int generatePin(){
        Random random = new Random();
        boolean flag = false;
        int pin = 0;
        for (int i = 0; i < 8; i++) {
            int a = random.nextInt(10);
            pin = pin*10+a;
        }
        return pin;
    }

    public int getAccNo(){
        return accNo;
    }
    public Customer getCustomer(){
        return customer;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getPin(){
        return pin;
    }
    public void setPin(){
        this.pin = pin;
    }
    public boolean isSuspended(){
        return this.isSuspended;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public double getOverDraftLimit() {
        return overDraftLimit ;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
    public double addDeposit(double money) {
        balance+=money;
        return balance;
    }

    //取款
    public double addWithdraw(double money) {
        if (balance>=money) {
            balance-=money;
        }
        else {
            System.out.println("取款数目过大,取款失败");
        }
        return balance;
    }
}
