package filter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TODO {
    // TODO

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("out.txt")) {
            out.write(0xcafebabe);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
