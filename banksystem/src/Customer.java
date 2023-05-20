public class Customer {
    public static String name;
    public static String address;
    public int dateOfBirth;
    public static boolean creditStatus;
    private Account account;

    private Account[] accounts;
    private int numberOfAccounts;
    int size = 5;

    public Customer(String name, String address, int dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        accounts = new Account[5];
        creditStatus = false;
    }

    public Customer(){

    }


    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getDateOfBirth() {
        return this.dateOfBirth;
    }

    public boolean getCreditStatus() {
        return this.creditStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditStatus(boolean creditStatus) {
        this.creditStatus = creditStatus;
    }


    public void setDateOfBirth() {
        this.dateOfBirth = dateOfBirth;
    }

    public void addAccount(Account account) {
        accounts[numberOfAccounts] = account;
        numberOfAccounts++;
    }

    //返回账户个数
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }

    //返回指定索引处的账户
    public Account getAccount(int index) {
        return accounts[index];
    }

    public void closeAccount(Account account) {
        int index = size + 1;
        for (int i = 0; i < size; i++) {
            if (accounts[i] == account) {
                index = i;
                break;
            }
        }
        //移动该元素之后的每个元素
        for (int i = index; i < size - 1; i++) {
            accounts[i] = accounts[i + 1];
        }
        size--;
        System.out.println("注销成功！");
    }
}

