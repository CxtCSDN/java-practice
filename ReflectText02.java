import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectText02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类文件（字节码文件.class）
        Class entity = Class.forName("java.lang.String");

        //尝试反编译类信息
        StringBuilder stringBuilder = new StringBuilder();
        //获取public修饰的Filed
        Field[] files = entity.getFields();
//        System.out.println(files.length);
        //获取所有的Filed
        Field[] files1 = entity.getDeclaredFields();
//        System.out.println(files1.length);
        stringBuilder.append(Modifier.toString(entity.getModifiers())+" class "+entity.getSimpleName() + "{\n");
        //遍历Filed
        for(Field filed : files1){
//            //获取属性修饰符修饰符代码并利用Modifier类的toString方法转换修饰符代码输出
//            System.out.println(Modifier.toString(filed.getModifiers()));
//            //获取属性类型
//            System.out.println(filed.getType().getName());
//            //获取属性名
//            System.out.println(filed.getName());
            //将获取的类信息进行字符串拼接
            stringBuilder.append("\t");
            //获取修饰符列表
            stringBuilder.append(Modifier.toString(filed.getModifiers()));
            stringBuilder.append(" ");
            //获取属性类型
            stringBuilder.append(filed.getType().getSimpleName());
            stringBuilder.append(" ");
            //获取属性名字
            stringBuilder.append(filed.getName());
            stringBuilder.append(";\n");
        }
        stringBuilder.append("}");
        //最后输出即完成了通过字节码文件获取到源码
        System.out.println(stringBuilder);
    }
}
