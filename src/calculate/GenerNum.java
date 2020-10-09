package calculate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class GenerNum {


    int max=10;

    public String FraNumber(){
        int a=(int)(1+Math.random()*(max-1));//系数
        int b=(int)(1+Math.random()*(max-1));//分子
        int c = (int)(b+1+Math.random()*(max-b));//分母

        String d= +a+"'"+b + "/" + c;
        return d;
    }
    //随机生成整数
    public String IntNumber(){
        Random random = new Random();
        int a = 1+random.nextInt(max - 2);
        String d = Integer.toString(a);
        return d;
    }
    //随机生成运算符号
    public String symbol() {
        Random rand = new Random();
        int a =rand.nextInt(4);
        String str = null;
        if (a == 0)
            str = " + ";
        else if (a == 1)
            str = " - ";
        else if (a == 2)
            str = " × ";
        else if(a==3)
            str = " ÷ ";
        return str;
    }
    public String formula(){
        String str = "";
        String str1="";
        int t;
        Random rand = new Random();
        t = rand.nextInt(2) + 2;
        String[] number = new String[t];//存放数字
        String[] symbol = new String[t-1];//存放运算符号
        String[] total = new String[4*t-3];//存放式子
        String[] total1 = new String[4*t-3];
        for(int i = 0;i < t;i++) {
            int a=(int)(Math.random()*2);

            if(a==0){
                number[i] = IntNumber();
            }else
                number[i]=FraNumber();
        }

        for(int i = 0;i < t-1;i++) {
            symbol[i] = symbol();
        }

      for(int i = 0,j=0;j<t;j++) {
            total[i] = number[j];
           i+=2;
        }

        for(int i = 1,j=0;j<t-1;j++) {
            total[i] = symbol[j];
            i+=2;
        }
        for(int i = 0;i < 2*t-1;i++) {
            str = str + total[i];

        }

		 return str;
    }

   /*public static void main(String[] args) {
        GenerNum g=new GenerNum();
        System.out.println(g.formula());

    }*/
}
