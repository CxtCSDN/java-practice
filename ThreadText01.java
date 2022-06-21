public class ThreadText01 {
    public static void main(String[] args) {
        //第一种实现多线程方式：继承Thread类
        MyThread myThread = new MyThread();
        myThread.start();
        //第二种：实现Runnable接口中的run方法
        Thread thread = new Thread(new MyThread2());
//        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    System.out.println("分支线程3="+i);
                }

            }
        });
//        thread1.start();
//        for(int i = 0; i < 1000; i++){
//            System.out.println("主线程="+i);
//        }
        String name = myThread.getName();
        System.out.println(name);
        myThread.setName("thread111");
        System.out.println(myThread.getName());
        Thread curT = Thread.currentThread();
        System.out.println(curT.getName());
    }
}
class MyThread extends Thread{
    public void run(){
        for(int i = 0; i < 1000; i++){
            System.out.println("分支线程=" + i + super.getName());
        }
    }
}
class MyThread2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            System.out.println("分支线程2="+i);
        }
    }
}
