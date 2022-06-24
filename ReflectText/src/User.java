public class User {
    static {
        System.out.println("User类的加载");
    }
    User(){
        System.out.println("User无参构造的调用");
    }
}
