import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamText01 {

    public static void main(String[] args) {
        FileInputStream ifs = null;
        try {
            ifs = new FileInputStream("FileText\\src\\Text.txt");
            //available()返回未读的字节数量（不适合大文件，因为byte数组不能太大）
            byte[] bytes = new byte[ifs.available()];
//            int countByte = 0;
//            while((countByte = ifs.read(bytes)) != -1){
//                System.out.print(new String(bytes,0,countByte));
//            }
            ifs.read(bytes);
            System.out.println(new String(bytes));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(ifs != null){
                try {
                    ifs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
