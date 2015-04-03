package ru.kpfu.itis.group11408.Miftahutdinova.arhiv;

import java.io.*;
import java.util.zip.*;

public class Arhivator {

    public static void main(String[] args) {

        try {
            byte b[] = new byte[512];
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("C:/setsort/Archive.zip"));
            InputStream in = new FileInputStream("C:/setsort/Original.txt");
            ZipEntry e1 = new ZipEntry("file1.txt");
            zipOut.putNextEntry(e1);
            int len = 0;
            while ((len = in.read(b)) != -1) {
                zipOut.write(b, 0, len);
            }
            zipOut.closeEntry();
            InputStream in2 = new FileInputStream("C:/setsort/Change.txt");
            ZipEntry e2 = new ZipEntry("file2.txt");
            zipOut.putNextEntry(e2);
            len = 0;
            while ((len = in2.read(b)) != -1) {
                zipOut.write(b, 0, len);
            }
            zipOut.closeEntry();
            zipOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream("C:/setsort/Archive.zip");
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                System.out.println(ze.getName());
                zis.closeEntry();
            }
            zis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}