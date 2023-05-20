import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private Customer[] customers ;   //用于存放客户
    private int numberofCustomers;
    public static void addCustomer(ArrayList<Customer> list1, ArrayList<Account> list2){
        System.out.println("-----------------开户界面-----------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名:");
        String name = sc.nextLine();
        System.out.println("请输入你的地址:");
        String address = sc.nextLine();
        System.out.println("请输生日");
        int dateOfBirth = sc.nextInt();
        Customer customer= new Customer(name,address, dateOfBirth);
        list1.add(customer);
        System.out.println("请输入accN0");
        int accNo = sc.nextInt();
        System.out.println("请选择一个类型的账户");
        while (true) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    System.out.println("请输入限额");
                    int overDraftLimit = sc.nextInt();
                    int pin1 = (100000+ r.nextInt( bound: 900000));
                    Account account1 = new CurrentAccount(accNo,customer,overDraftLimit,pin1);

                    list2.add(account1);
                    System.out.println("开户成功，您的银行卡accNo:"+accNo+"Pin为:"+pin);
                    break;
                case 2:
                    Account account2 = new SaverAccount(accNo,customer,pin);
                    list2.add(account2);
                    System.out.println("开户成功，您的银行卡accNo"+accNo+"Pin为:"+pin);
                    break;
                case 3:
                    Account account3 = new JuniorAccount(accNo,customer,pin);
                    list2.add(account3);
                    System.out.println("开户成功，您的银行卡accNo"+accNo+"Pin为:"+pin);
                    break;
                default:
                    System.out.println("无此选项，请重新输入");
            }
            System.out.println(list2.get(0).getPin());
            UI.Show(list1,list2);
        }


    }
    public static void Login(ArrayList<Account> list2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------登录界面-----------------");
        System.out.println("请输入您的accNo:");
        int accNo = sc.nextInt();
        System.out.println("请输入Pin:");
        int pin = sc.nextInt();
        for(int i = 0; i < list2.size(); i++) {
            if(list2.get(i).getAccNo() == accNo) {
                if(list2.get(i).getPin()==pin){
                    UI.transaction(list2,accNo);
                    break;
                }
                else {
                    System.out.println("输入错误，请重新输入");
                }
            }
        }
    }
    public static void customerinfo(ArrayList<Account> list2, int accNo) {
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getAccNo() == accNo) {
                System.out.println("卡号:" + list2.get(i).getAccNo());
                System.out.println("余额:" + list2.get(i).getBalance());
                System.out.println("限额:" + list2.get(i).getOverDraftLimit());
            }
        }
        System.out.println("您是否要继续操作");
        System.out.println("1.是");
        System.out.println("2.否");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (true) {
            switch (a) {
                case 1:
                    UI.transaction(list2, accNo);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("无此选项，请重新输入");
            }
        }
    }
    public static void deposit(ArrayList<Account> list2, int accNo) {
        System.out.println("请输入您要存的金额:");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        for(int i = 0; i < list2.size(); i++) {
            if(list2.get(i).getAccNo() == accNo){
                double balance  = list2.get(i).getBalance()+a;
                list2.get(i).setBalance(balance);
                System.out.println("您的余额为:"+list2.get(i).getBalance());
                break;
            }
        }
        System.out.println("您是否要继续操作");
        System.out.println("1.是");
        System.out.println("2.否");
        int c = sc.nextInt();
        while (true) {
            switch (c) {
                case 1:
                    UI.transaction(list2, accNo);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("无此选项，请重新输入");
            }
        }
    }
    public static void withdral(ArrayList<Account> list2, int accNo){
        System.out.println("请输入您要取的金额:");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        for(int i = 0; i < list2.size(); i++) {
            if(list2.get(i).getAccNo() == accNo){
                int t = list2.get(i).getType();
                        switch(t){
                            case 1:{
                                list2.get(i).addWithdraw(a);
                                break;
                            }
                            case 2:{
                                list2.get(i).addWithdraw(a);
                                break;
                            }
                            case 3:{
                                list2.get(i).addWithdraw(a);
                                break;
                            }
                            default:
                                throw new IllegalStateException("Unexpected value: " + t);
                        }
                System.out.println("您的余额为:"+list2.get(i).getBalance());
                break;
            }
        }
        System.out.println("您是否要继续操作");
        System.out.println("1.是");
        System.out.println("2.否");
        int c = sc.nextInt();
        while (true) {
            switch (c) {
                case 1:
                    UI.transaction(list2, accNo);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("无此选项，请重新输入");
            }
        }
    }
    //转账
    public static void zhuanzhang(ArrayList<Account> list2, int accNO) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要转账的金额:");
        int money = sc.nextInt();
        System.out.println("请输入你要转账的用户id:");
        int newaccNo = sc.nextInt();

        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getAccNo() == accNO) {
                double b = list2.get(i).getBalance() - money;
                list2.get(i).setBalance(b);
                System.out.println("您的余额为:"+ list2.get(i).getBalance());
            }
            if (list2.get(i).getAccNo() == newaccNo) {
                double c = list2.get(i).getBalance() + money;
                list2.get(i).setBalance(c);
                System.out.println("转账成功！");
            }
        }
        System.out.println("您是否要继续操作");
        System.out.println("1.是");
        System.out.println("2.否");
        int c = sc.nextInt();
        while (true) {
            switch (c) {
                case 1:
                    UI.transaction(list2, accNO);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("无此选项，请重新输入");
            }
        }
    }




    public Customer getCustomer(int index) {
        return customers[index];
    }

    public int getNumberOfCustomers() {
        return numberofCustomers;
    }

}



