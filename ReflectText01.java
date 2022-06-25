import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReflectText01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("classinfo.properties");
//        FileReader fileReader = new FileReader("ReflectText/classinfo.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String className = properties.getProperty("className");
        Class c1 = Class.forName(className);
        Object o1 = c1.newInstance();
        System.out.println(o1);
    }
}
