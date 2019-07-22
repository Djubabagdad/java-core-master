package classwork.lesson18;

import java.io.*;

public class BufferedReaderWriterDemo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("src\\io\\file.txt"));
             BufferedWriter wr = new BufferedWriter(
                     new FileWriter("src\\io\\copy_file.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                wr.write("a");
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
