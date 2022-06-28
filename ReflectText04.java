import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//反射机制调用方法
public class ReflectText04 {
    public static void main(String[] args) throws Exception {
        //可变化的内容都是可以写入配置文件，使得代码复用性高
        Class myEntity = Class.forName("TextEntity");
        Method[] methods = myEntity.getDeclaredMethods();
        System.out.println(methods.length);
        for(Method method : methods){
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getSimpleName());
            System.out.println(method.getName());
        }
        //实例化对象
//        TextEntity o1 = (TextEntity) myEntity.newInstance();
        Constructor constructor = myEntity.getDeclaredConstructor(String.class,String.class);
        TextEntity o1 = (TextEntity) constructor.newInstance("李四","678");
        Field id = myEntity.getDeclaredField("id");
        id.setAccessible(true);
        Field psd = myEntity.getDeclaredField("password");
        psd.setAccessible(true);
        id.set(o1,"张三");
        psd.set(o1,"123");
        //获取方法，需要方法名和形参列表类型
        Method login = myEntity.getDeclaredMethod("login",String.class,String.class);
        //invoke调用方法，传入方法所属对象，并传入方法所需实参
        Object in = login.invoke(o1,"张三","1234");
        System.out.println(in);
        Method logout = myEntity.getDeclaredMethod("logout");
        logout.invoke(o1);
    }
}
