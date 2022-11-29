
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class writeToFile {

    public static void main(String[] args) {
        try {
//           ✅ made new file in dataset called newFile1.txt

            //Path p = Paths.get("DataSet/newFile1.txt");
            //Path donePath1 = Files.createFile(p);
            //String content = "Writing in file";

            //Files.write(donePath1, content.getBytes());
            //System.out.println("data written as byte array");

//            ✅ getting or creating file named file.txt
//            ✅copying files from poem.txt
//            ✅pasting data(poem.txt) into donePath(newFile.txt)

            Path p2 = Paths.get("DataSet/newFile.txt");
            Path donePath2 = Files.createFile(p2);

            Path p3 = Paths.get("DataSet/poem.txt");
            List<String> data = Files.readAllLines(p3);

            Files.write(donePath2,data);
            System.out.println("Data written in file using list of string");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}