// Zhubo Deng
// 03/02/21
public class Driver {
    public static void main(String[] args) {
        System.out.println("*** Create Account ***");
        BankAccount zhuboBA = new BankAccount("123456789", 500.0, "Zhubo Deng",
                "zhubodeng@gmail.com", "6507722625");
        zhuboBA.printInfo();
        System.out.println();

        System.out.println("*** Deposit Funds: 50.0 ***");
        double deposit = 50.0;
        zhuboBA.depositFunds(deposit);
        zhuboBA.printInfo();
        System.out.println();

        System.out.println("*** Withdraw Funds: 600.0 ***");
        double withdraw1 = 600.0;
        zhuboBA.withdrawFunds(withdraw1);
        zhuboBA.printInfo();
        System.out.println();

        System.out.println("*** Withdraw Funds: 300.0 ***");
        double withdraw2 = 300.0;
        zhuboBA.withdrawFunds(withdraw2);
        zhuboBA.printInfo();
    }
}


