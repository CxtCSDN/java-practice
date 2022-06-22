public class ThreadText02 {
    public static void main(String[] args) {
        Account account = new Account(10000,"Account1");
        MyThread1 myThread1 = new MyThread1(account);
        MyThread3 myThread3 = new MyThread3(account);
        myThread3.start();
        myThread1.start();

    }
}
class Account{
    private double balance;
    private String ID;

    Account(double balance, String ID) {
        this.balance = balance;
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public String getID() {
        return ID;
    }
//    public void take_balance(double money){
//        synchronized (this){
//            double before = this.balance;
//            double after = before-money;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            this.balance = after;
//        }
//    }
    //synchronized的第二种使用方式
    public synchronized void take_balance(double money){
            double before = this.balance;
            double after = before-money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.balance = after;
    }
}
class MyThread1 extends Thread{
    private Account account;
    MyThread1(Account account){
        this.account = account;
    }
    public void run(){
        double money = 5000;
        account.take_balance(5000);
        System.out.println("线程："+this.getName()+" 取款后剩余："+account.getBalance());
    }
}
class MyThread3 extends Thread{
    private Account account;
    MyThread3(Account account){
        this.account = account;
    }
    public void run(){
        double money = 5000;
        account.take_balance(5000);
        System.out.println("线程："+this.getName()+" 取款后剩余："+account.getBalance());
    }
}