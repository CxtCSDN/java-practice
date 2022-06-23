public class ProtectedThread {
    public static void main(String[] args) {
        ProtectProcess t = new ProtectProcess();
        t.setDaemon(true);
        t.start();
        for(int i = 0; i < 10; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class ProtectProcess extends Thread{
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " 守护线程测试");
        }
    }
}
