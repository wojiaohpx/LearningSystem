public class JuniorAccount extends Account {
    public JuniorAccount(int accNo, Customer customer,int pin){

        super(accNo, customer,pin);
        this.type =3;
    }
    public double addWithdraw(double money) {
        if (money > 100) {
            System.out.println("Cannot withdraw more than 100 per day");
        }
        super.addWithdraw(money);
        return money;
    }


}
