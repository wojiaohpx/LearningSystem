import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    UI ui = new UI();
    public static void Show(ArrayList<Customer> list1, ArrayList<Account> list2){
        System.out.println("-----------------欢迎进入银行服务系统-----------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("1.添加customer");
        System.out.println("2.登录");
        System.out.println("3.退出");
        System.out.print("请选择你想进行的操作(输入数字即可):");
        while (true) {
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    Bank.addCustomer(list1,list2);
                    break;
                case 2:
                    Bank.Login(list2);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("无此选项，请重新输入");
            }
        }    }

    public static void transaction(ArrayList<Account> list2, int accNo) {
        System.out.println("-----------------------------------------");
        System.out.println("-----------------欢迎进入银行操作界面-----------------");
        System.out.println("请选择要进行的操作:");
        System.out.println("1.用户基本信息");
        System.out.println("2.存款");
        System.out.println("3.取款");
        System.out.println("4.转账");
        System.out.println("5.修改密码");
        System.out.println("6.退出");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
            while (true){
            switch (a) {
                case 1:
                    System.out.println("--------------用户信息--------------");
                    Bank.customerinfo(list2,accNo);
                    break;
                case 2:
                    System.out.println("--------------存款--------------");
                    Bank.deposit(list2,accNo);
                    break;
                case 3:
                    System.out.println("--------------取款--------------");
                    Bank.withdral(list2,accNo);
                    break;
                case 4:
                    System.out.println("--------------转账--------------");
                    Bank.zhuanzhang(list2,accNo);
                    break;
                /*case 5:
                    System.out.println("--------------注销账户--------------");
                    closeAccount(list,id);
                    break;*/
                case 6:
                    System.out.println("感谢您的使用,再见！！！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("没有此选项，请重新输入！！");
            }
        }

    }



    //存款



}
