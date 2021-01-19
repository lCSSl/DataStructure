package work.kaiyu.datastructure.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils extends org.apache.commons.io.FileUtils {

    private static int DEFAULT_FILE_MEZZANINE = 3;
    private static String DEFAULT_PLACEHOLDER = "--";

    /**
     * 获取文件树
     *
     * @param dir
     */
    public static void listAllFiles(File dir) {
        listAllFiles(dir, 0);
    }

    public static void listAllFiles(File dir, int fileMezzanine) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < fileMezzanine; i++) {
                sb.append(DEFAULT_PLACEHOLDER);
            }
            System.out.println(sb.toString() + dir.getName());
            return;
        }
        if (fileMezzanine == DEFAULT_FILE_MEZZANINE) {
            return;
        }
        fileMezzanine++;
        for (File file : dir.listFiles()) {
            listAllFiles(file, fileMezzanine);
        }
    }

    public static void copyFile(String src, String dist) throws IOException {

        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] buffer = new byte[20 * 1024];
        int cnt;
        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即⽂件尾

        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }
        in.close();
        out.close();
    }
//    public static void listAllFiles(File dir, int fileMezzanine, int a) {
//        if (dir == null || !dir.exists()) {
//            return;
//        }
//        if (dir.isFile()) {
//            StringBuilder sb = new StringBuilder();
//            System.out.println(sb.toString() + dir.getName());
//            return;
//        }
//        for (File file : dir.listFiles()) {
//            listAllFiles(file);
//        }
//    }

}
