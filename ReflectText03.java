import java.lang.reflect.Field;

public class ReflectText03 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        //通过访问反射机制访问一个java对象的属性
        //获取字节码文件
        Class myEntity = TextEntity.class;
        //创建对象
        Object entity = myEntity.newInstance();
        //获取属性
        Field num = myEntity.getField("num");
        //通过反射机制赋值，以及获取值（灵活程度高）
        //通过获取的“属性”的set方法对这个属性所属的“对象”赋“20”这个值
        //即意思上相当于“对象.属性=值”（正常属性的赋值操作）
        num.set(entity,20);
        System.out.println(num.get(entity));
        //尝试获取私有属性
        Field sex = myEntity.getDeclaredField("sex");
        //打破封装
        sex.setAccessible(true);
        sex.set(entity,"男");
        System.out.println(sex.get(entity));
    }
}
