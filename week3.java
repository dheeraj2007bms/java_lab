import java.util.Scanner;

abstract class Account {
    String cus_name;
    int cus_id;

    Account(String name, int id) {
        cus_name = name;
        cus_id = id;
    }

    abstract void interest();
    abstract void chequeBook();
}

class SavAcc extends Account {
    float sav_bal = 0.0f;

    SavAcc(String name, int id, float bal) {
        super(name, id);
        sav_bal = bal;
    }

    void interest() {
        float intr = sav_bal * 0.04f;
        System.out.println("Interest for Savings Account: " + intr);
    }

    void chequeBook() {
        System.out.println("Cheque book NOT available for Savings Account");
    }
}

class CurAcc extends Account {
    float cur_bal = 0.0f;

    CurAcc(String name, int id, float bal) {
        super(name, id);
        cur_bal = bal;
    }

    void chequeBook() {
        System.out.println("Cheque book available for Current Account");
    }

    void interest() {
        System.out.println("Interest NOT available for Current Account");
    }
}

public class week3 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account type (sav_acc / cur_acc):");
        String acc_type = sc.nextLine();

        Account acc = null;

        if (acc_type.equals("sav_acc")) {
            System.out.println("Enter name:");
            String name = sc.nextLine();

            System.out.println("Enter ID:");
            int id = sc.nextInt();

            System.out.println("Enter balance:");
            float bal = sc.nextFloat();

            acc = new SavAcc(name, id, bal);
        } 
        else if (acc_type.equals("cur_acc")) {
            System.out.println("Enter name:");
            String name = sc.nextLine();

            System.out.println("Enter ID:");
            int id = sc.nextInt();

            System.out.println("Enter balance:");
            float bal = sc.nextFloat();

            acc = new CurAcc(name, id, bal);
        } 
        else {
            System.out.println("Invalid account type");
            return;
        }

        System.out.println("Enter choice: 1-Deposit, 2-Display Balance, 3-Interest, 4-Withdraw");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter amount to deposit:");
                float dep = sc.nextFloat();

                if (acc instanceof SavAcc) {
                    ((SavAcc) acc).sav_bal += dep;
                } else {
                    ((CurAcc) acc).cur_bal += dep;
                }
                System.out.println("Amount deposited successfully");
                break;

            case 2:
                if (acc instanceof SavAcc) {
                    System.out.println("Balance: " + ((SavAcc) acc).sav_bal);
                } else {
                    System.out.println("Balance: " + ((CurAcc) acc).cur_bal);
                }
                break;

            case 3:
                acc.interest();
                break;

            case 4:
                System.out.println("Enter amount to withdraw:");
                float w = sc.nextFloat();

                if (acc instanceof SavAcc) {
                    if (w <= ((SavAcc) acc).sav_bal) {
                        ((SavAcc) acc).sav_bal -= w;
                        System.out.println("Withdraw successful");
                    } else {
                        System.out.println("Insufficient balance");
                    }
                } else {
                    if (w <= ((CurAcc) acc).cur_bal) {
                        ((CurAcc) acc).cur_bal -= w;
                        System.out.println("Withdraw successful");
                    } else {
                        System.out.println("Insufficient balance");
                    }
                }
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}