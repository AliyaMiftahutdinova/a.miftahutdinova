package ru.kpfu.itis.group11408.words;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алия on 14.04.2015.
 */
public class CheckEmail {
    public void checkEmail(String[] str) {
        int count = 0;
        int j = 0;
        String[] s1 = new String[str.length];
        String sDomen = "[a-z][a-z[0-9]\u005F\u002E\u002D]*[a-z||0-9]";
        String sDomen2 = "(net||org||ru||info||com)";
        Pattern pattern = Pattern.compile(sDomen + "@" + sDomen + "\u002E" + sDomen2);
        for (int i = 0; i < str.length; i++) {
            Matcher matc = pattern.matcher(str[i]);
            boolean sem = matc.matches() ? true : false;
            if (sem) {
                s1[j] = str[i] + " ";
                j++;
            } else {
                count++;
            }
        }
        WriteFile writer = new WriteFile();
        writer.writeFile(s1);
    }
}

