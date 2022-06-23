public class ThreadText03 {
    public static void main(String[] args) {
        Num num = new Num(0);
        Thread thread1 = new Thread(new oddNum(num));
        Thread thread2 = new Thread(new evenNum(num));
        thread1.setName("奇数线程");
        thread2.setName("偶数线程");
        thread1.start();
        thread2.start();
    }
}
class Num{
    public int i;
    Num(int i){
        this.i = i;
    }
}

class oddNum implements Runnable{
    private Num num;
    oddNum(Num num){
        this.num = num;
    }
    @Override
    public void run() {
        while(true){
            synchronized (num){
                if(num.i%2 == 0){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + num.i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    num.i++;
                    num.notify();
                }
            }
        }
    }
}
class evenNum implements Runnable{
    private Num num;
    evenNum(Num num){
        this.num = num;
    }
    @Override
    public void run() {
        while(true){
            synchronized (num){
                if(num.i%2 != 0){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + num.i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    num.i++;
                    num.notify();
                }
            }
        }
    }
}