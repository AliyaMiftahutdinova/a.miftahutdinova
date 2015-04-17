package ru.kpfu.itis.group11408.words;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Алия on 14.04.2015.
 */
public class Starter {
    public static void main (String [] args) {
        CheckEmail check = new CheckEmail();
        try (FileInputStream ebbi = new FileInputStream("C:/Files/in.txt")) {
            byte[] sr = new byte[ebbi.available()];
            ebbi.read(sr);
            String srt = new String(sr);
            String[] str = srt.split(" ");
            check.checkEmail(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
