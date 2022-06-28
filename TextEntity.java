public class TextEntity {
    public int num;
    protected boolean flag;
    private String sex;
    public static final double PI = 3.1415926525;
    public TextEntity(){}
    TextEntity(String id,String password){
        this.id = id;
        this.password = password;
    }
    private String id;
    private String password;
    public void logout(){
        System.out.println("登出账户");
    }
    public boolean login(String id,String password){
        if(id.equals(this.id)){
            if(password.equals(this.password))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
