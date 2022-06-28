public class ReflectText05 {
    //获取类的父类以及所有实现接口
    public static void main(String[] args) {
        Class stringClass = String.class;
        Class superClass = stringClass.getSuperclass();
        System.out.println(superClass.getSimpleName());
        Class[] interfaces = stringClass.getInterfaces();
        for(Class in : interfaces){
            System.out.println(in.getSimpleName());
        }
    }
}
