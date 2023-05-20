public class CurrentAccount extends Account {

    public CurrentAccount(int accNo,Customer customer,double overDraftLimit,int pin) {
        super(accNo,customer,pin);
        this.overDraftLimit = overDraftLimit;
        this.type =1;
    }

    public double addWithdraw(double money) {
        if(getBalance() >= money) {
            this.balance = getBalance() - money;
        }else if(getBalance() + getOverDraftLimit() >= money) {
            setOverDraftLimit(getOverDraftLimit()-(money-getBalance()));
            this.balance = 0;
        }else {
            System.out.println("Sorry, your balance is insufficient."+"\n"+"Your overdraftlimit is "+ getOverDraftLimit());
        }
        return balance;
    }
}
