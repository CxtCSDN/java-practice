import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamText01 {
    public static void main(String[] args) {
        FileOutputStream ofs = null;
        try {
            //文件名不存在会新建，该种方式是将原文件清空，然后重新写入
//           ofs = new FileOutputStream("outPutFile.txt");
            //可通过构造函数表明写入方式，true为追加，则不会清空原文件
            ofs = new FileOutputStream("outPutFile.txt",true);
           byte[] bytes = {97,98,99,100};
           ofs.write(bytes);
           //写完要刷新缓冲区
           ofs.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ofs!=null){
                try {
                    ofs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
