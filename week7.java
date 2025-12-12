package week7;
import java.util.*;

class wrongage extends Exception {
    public wrongage(String msg) {
        super(msg);
    }
}

class invalidexception extends Exception {
    public invalidexception(String msg) {
        super(msg);
    }
}

class father {
    int age;
    static Scanner sc = new Scanner(System.in);

    father() throws wrongage {
        System.out.println("Enter father's age: ");
        this.age = sc.nextInt();
        if (age <= 0) {
            throw new wrongage("Age cannot be less than 1");
        }
    }
}

class son extends father {
    int sage;

    son() throws invalidexception, wrongage {
        super(); // father constructor must run first
        System.out.println("Enter son's age: ");
        this.sage = sc.nextInt();

        if (sage >= age) {
            throw new invalidexception("Son's age cannot be more than or equal to father's age");
        }
    }
}

public class week7 {
    public static void main(String[] args) {
        try {
            son s1 = new son();
            System.out.println("Father and son ages are valid");
        }
        catch (wrongage e) {
            System.out.println("Error001: " + e.getMessage());
        }
        catch (invalidexception e) {
            System.out.println("Error002: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unknown error occurred");
        }
        finally {
            System.out.println("Program has ended");
        }
    }
}