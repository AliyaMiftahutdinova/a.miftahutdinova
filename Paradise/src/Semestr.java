import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Semestr {
    public static void main(String[] args) {
        try {
            Semestr fail = new Semestr();
            FileInputStream ebbi = new FileInputStream("C:/Paradise/files/Original.txt");
            byte [] mar = new byte [ebbi.available()];
            ebbi.read(mar);
            String string1 = new String(mar);
            String [] s = string1.split("\n");
            FileInputStream ebbi2 = new FileInputStream("C:/Paradise/files/Change.txt");
            byte [] mar2 = new byte[ebbi2.available()];
            ebbi2.read(mar2);
            String string2 = new String(mar2);
            String [] s2 = string2.split("\n");
            fail.start(s, s2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void start(String [] s, String [] s2) {
        Semestr limmit = new Semestr();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our program to compare text files.");
        System.out.println("Before you start using the program, read useful information:" );
        System.out.println("1) To use the patch, you should make a difference in the file with a resolution of diff;");
        System.out.println("2) If you want to see the difference between the files " +
                            "without using the patch, store it in a file with a resolution txt;");
        System.out.println("3) Remember: R means Replacing; I - Insert; D - Delete; N - Nothing to do;");
        System.out.println();
        System.out.println("Now press 1, 2 or 3 to select the comparison algorithm.");
        System.out.println("We remind you that the difference in their performance significantly only in time and memory.");
        int mode = sc.nextInt();
        switch(mode) {
            case 1:
                limmit.Levenshtein1(s, s2);
                break;
            case 2:
                limmit.Levenshtein2(s, s2);
                break;
            case 3:
                limmit.Levenshtein3(s, s2);
                break;
            default:
                System.out.println("You entered the wrong number.");
                System.out.println("Please run the program again and select option 1, 2 or 3.");
                System.out.println("With respect, your developers.");
                System.exit(0);
        }
    }
    public static void Levenshtein1(String [] s, String [] s2) {
        int m = s.length, n = s2.length;
        int h = (int)Math.sqrt(m + 1);
        int[][] D = new int[h + 1][n + 1];
        char[][] P = new char[h + 1][n + 1];
        int d = 0;
        StringBuilder words = new StringBuilder("");
        int iPos = m, jPos = n;
        do {
            for (int i = 0; i <= jPos; i++) {
                D[0][i] = i;
                P[0][i] = 'I';
            }
            int _i = 1;
            for(int i = 1; i <= iPos; i++) {
                for(int j = 0; j <= jPos; j++) {
                    if(j == 0) D[_i][j] = i;
                    else {
                        int cost = (!(s[i-1].equals(s2[j-1]))) ? 1 : 0;
                        if(D[_i][j - 1] < D[_i - 1][j] && D[_i][j - 1] < D[_i - 1][j - 1] + cost) {
                            D[_i][j] = D[_i][j - 1] + 1;
                            P[_i][j] = 'I';
                        }
                        else if(D[_i - 1][j] < D[_i - 1][j - 1] + cost) {
                            D[_i][j] = D[_i - 1][j] + 1;
                            P[_i][j] = 'D';
                        }
                        else {
                            D[_i][j] = D[_i - 1][j - 1] + cost;
                            P[_i][j] = (cost == 1) ? 'R' : 'N';
                        }
                    }
                }
                if(i % h == 0) {
                    int[] vRow = new int[n + 1];
                    char[] cRow = new char[n + 1];
                    for(int j = 0; j <= n; j ++) {
                        vRow[j] = D[_i][j];
                        cRow[j] = P[_i][j];
                    }
                    D = new int[h + 1][n + 1];
                    P = new char[h + 1][n + 1];
                    for(int j = 0; j <= n; j ++) {
                        D[0][j] = vRow[j];
                        P[0][j] = cRow[j];
                    }
                    _i = 0;
                }
                _i++;
            }
            if(iPos == m && jPos == n) d = D[_i - 1][n];
            while(_i > 0 && iPos !=0 && jPos != 0) {
                char c = P[_i - 1][jPos];
                char c1 = 32;
                words.append(c);
                words.append(c1);
                if(c == 'R' || c == 'N') {
                    iPos --;
                    jPos --;
                    _i --;
                }
                else if(c == 'D') {
                    iPos --;
                    _i --;
                }
                else {
                    jPos --;
                }
            }
        } while((iPos != 0) && (jPos != 0));
        try {
            FileOutputStream change = new FileOutputStream("C:/Paradise/change/Change.diff");
            String s3 = words.reverse().toString();
            byte [] tetta = s3.getBytes();
            change.write(tetta);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void Levenshtein2(String [] s, String [] s2) {
        int m = s.length, n = s2.length;
        int [] D1 = new int[n + 1];
        int [] D2 = new int[n + 1];
        char [] P1 = new char[n + 1];
        char [] P2 = new char[n + 1];
        int d = 0;
        StringBuilder words = new StringBuilder("");
        int iPos = m, jPos = n;
        do {
            for(int i = 0; i <= jPos; i ++) {
                D2[i] = i;
            }
            for(int i = 1; i <= iPos; i ++) {
                D1 = D2;
                D2 = new int[jPos + 1];
                P1 = P2;
                P2 = new char[jPos + 1];
                for(int j = 0; j <= jPos; j ++) {
                    if(j == 0) {
                        D2[j] = i;
                    } else {
                        int cost = (!(s[i - 1].equals(s2[j - 1]))) ? 1 : 0;
                        if(D2[j - 1] < D1[j] && D2[j - 1] < D1[j - 1] + cost) {
                            D2[j] = D2[j - 1] + 1;
                            P2[j] = 'I';
                        } else if(D1[j] < D1[j - 1] + cost) {
                            D2[j] = D1[j] + 1;
                            P2[j] = 'D';
                        } else {
                            D2[j] = D1[j - 1] + cost;
                            P2[j] = (cost == 1) ? 'R' : 'N';
                        }
                    }
                }
            }
            if(iPos == m && jPos == n) {
                d = D2[n];
            }
            int _iPos = iPos;
            while(iPos >= _iPos - 1 && iPos !=0 && jPos != 0) {
                char c = (iPos == _iPos) ? P2[jPos] : P1[jPos];
                char c1 = 32;
                words.append(c);
                words.append(c1);
                if(c == 'R' || c == 'N') {
                    iPos --;
                    jPos --;
                } else if(c == 'D') {
                    iPos --;
                } else {
                    jPos --;
                }
            }
        } while((iPos != 0) && (jPos != 0));
        try {
            FileOutputStream change = new FileOutputStream("C:/Paradise/change/Change.diff");
            String s3 = words.reverse().toString();
            byte [] tetta = s3.getBytes();
            change.write(tetta);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Levenshtein3(String [] s, String [] s2) {
        int m = s.length, n = s2.length;
        int[][] D = new int[m + 1][n + 1];
        char[][] P = new char[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            D[i][0] = i;
            P[i][0] = 'D';
        }
        for (int i = 0; i <= n; i++) {
            D[0][i] = i;
            P[0][i] = 'I';
        }
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                int cost = (!(s[i-1].equals(s2[j-1]))) ? 1 : 0;
                if(D[i][j - 1] < D[i - 1][j] && D[i][j - 1] < D[i - 1][j - 1] + cost) {
                    D[i][j] = D[i][j - 1] + 1;
                    P[i][j] = 'I';
                } else if(D[i - 1][j] < D[i - 1][j - 1] + cost) {
                    D[i][j] = D[i - 1][j] + 1;
                    P[i][j] = 'D';
                } else {
                    D[i][j] = D[i - 1][j - 1] + cost;
                    P[i][j] = (cost == 1) ? 'R' : 'N';
                }
            }
        StringBuilder words = new StringBuilder("");
        int i = m, j = n;
        do {
            char c = P[i][j];
            char c1 = 32;
            words.append(c);
            words.append(c1);
            if(c == 'R' || c == 'N') {
                i --;
                j --;
            } else if(c == 'D') {
                i --;
            } else {
                j --;
            }
        } while((i != 0) && (j != 0));
        try {
            FileOutputStream change = new FileOutputStream("C:/Paradise/change/Change.diff");
            String s3 = words.reverse().toString();
            byte [] tetta = s3.getBytes();
            change.write(tetta);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
