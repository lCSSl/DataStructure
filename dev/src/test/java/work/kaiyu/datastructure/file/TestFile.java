package work.kaiyu.datastructure.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

@Slf4j
public class TestFile {
    @Test
    public void seeFileTree() {
        File file = new File("/Users/hamster/Git/note");
        File[] files = file.listFiles();
        System.out.println("最后修改时间---文件类型---文件长度---文件名称");
        for (File f : files) {
            String s = "file";
            if (f.isDirectory()) {
                s = "<DIR>";
            }
            f.isHidden();
        }
        // FileUtils.listAllFiles(file);
        System.out.println(file.getParent());
        ArrayList<String> arrayList = new ArrayList<>();
    }
}
