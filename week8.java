class Thread1 extends Thread {
    public void run() {
        while (true) {
            System.out.println("BMS college of Engineering");
            try {
                Thread.sleep(10000); // sleep for 10 seconds
            } catch (InterruptedException ex) {
                System.out.println("thread1 is interrupted!");
            }
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        while (true) {
            System.out.println("CSE");
            try {
                Thread.sleep(2000); // sleep for 2 seconds
            } catch (InterruptedException ex) {
                System.out.println("thread2 is interrupted!");
            }
        }
    }
}

class week8 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }
}