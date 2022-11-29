
import java.nio.file.*;
import java.util.*;

public class appendToFile {

        //     ✅ appending to file
        public static void main(String[] args) {
            try {
                Path p = Paths.get("DataSet/AppendTestFile.txt");

                for (int i=0;i<=5;i++) {
                    String content = "content string" + "-->" + i;
                    Files.write(p, content.getBytes(), StandardOpenOption.APPEND);
                    Files.write(p, System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
                }
                System.out.println("Data written as byte array");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//✅
//THIS IS APPENDED TO   DataSet/appendTestFile.txt:

//content string-->0
//content string-->1
//content string-->2
//content string-->3
//content string-->4
//content string-->5



}
