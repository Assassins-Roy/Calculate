package calculate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Check {
    public static void check() throws Exception {

      /*  FileWriter fw = new FileWriter("D:/cal/Grade.txt");
        BufferedWriter bw = new BufferedWriter(fw);*/

        FileReader fr1 = new FileReader("D:/test/Exercises.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        FileReader fr2 = new FileReader("D:/test/Answers.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        int correct=0;
        int wrong=0;
        String s1[]=new String[20];
        String s2[]=new String[20];
        String line=null;
        String right="Correct (";
        String mistake="Wrong (";
        int i=1;
        // 读取数组中的内容
        while ((line=br1.readLine())!=null) {

            String[] s = line.split("=",-1);
            s1[i]=s[1];

           // System.out.println(s1[i]);
            if ((line = br2.readLine()) != null) {
                String[] ss=line.split(" ");
                s2[i]=ss[1];
                if(s1[i].equals(s2[i])) {
                    correct++;
                    right=right+i+",";

                }else
                    wrong++;
                    mistake=mistake+i+",";
                //System.out.println(s2[i]);
                i++;
            }
        }
        right=right+")";
        mistake=mistake+")";
        System.out.println(right);
        System.out.println(mistake);


     /*  s=line.split("-");

            System.out.print(s[0]); // 一个一个打印字符
        System.out.print(s[1]); // 一个一个打印字符*/
        br1.close();

    }
    }
