package ru.kpfu.itis.group11408.words;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Алия on 14.04.2015.
 */
public class WriteFile {
    public void writeFile(String [] s1) {
        try (FileWriter ebbi2 = new FileWriter("C:/Files/out.txt")) {
            String s4 = "";
            for (int i = 0; i < s1.length; ) {
                if (s1[i] == null) {
                    i++;
                } else {
                    s4 += s1[i];
                    i++;
                }
            }
            StringBuilder s3 = new StringBuilder(s4);
            String s5 = s3.toString();
            ebbi2.write(s5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
