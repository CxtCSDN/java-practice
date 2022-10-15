import java.util.Calendar;
public class CommandParameter {
    public static void main(String[] args) {
        long n = 461012;
        //%d表示输出整型，%n表示换行
        System.out.printf("%d%n", n);
        //%08d表示输出整型，并且占8个位置，输出不足8位左侧用0补足(右对齐字符串）
        System.out.printf("%08d%n", n);
        //输出一个整型，前面有+号，并且输出位数不足8位左侧以空格补足(右对齐字符串）
        System.out.printf("%+8d%n", n);
        //输出一个整型，并且每三位用逗号进行分割，并且一共占8位，不足则左侧用空格补足(右对齐字符串）
        System.out.printf("%,8d%n", n);
        //输出一个整型，前面有+号，并且整型每三位用逗号分割，并且一共占8位，不足则左侧用空格补足(右对齐字符串）
        System.out.printf("%+,8d%n%n", n);
        double pi = Math.PI;
        //输出一个浮点型，%n表示换行
        System.out.printf("%f%n", pi);
        //输出一个浮点型，并且保留三位小数
        System.out.printf("%.3f%n", pi);
        //输出一个浮点型，保留三位小数，总共占10位，不足则左侧以空格补足(右对齐字符串）
        System.out.printf("%10.3f%n", pi);
        //输出一个浮点型，保留三位小数，总共占10位，不足则右侧以空格补足(左对齐字符串)
        System.out.printf("%-10.3f%n", pi);
        //Calendar类是一个抽象类，在实际使用时实现特定的子类的对象。
        //由于Calendar类是抽象类，且Calendar类的构造方法是protected的，所以无法使用Calendar类的构造方法来创建对象.
        //API中提供了getInstance方法用来创建对象。
        Calendar c = Calendar.getInstance();//获取一个日期类对象
        //&tx（x代表不同的日期与时间转换符） %n表示换行
        System.out.printf("%tB %te, %tY%n", c, c, c);//B表示月份，e表示几号，Y表示年份
        System.out.printf("%tl:%tM %tp%n", c, c, c);//l表示小时，M表示分钟，p表示下午
        System.out.printf("%tD%n", c);//D表示默认日期格式
    }
}