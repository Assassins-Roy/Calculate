package calculate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Count {
    public  String count() {
        String resul=null;
        String flag=null;
        int intge=0;//分数的整数部分
        int denom=0;//分母
        int numer=0;//分子
        int div=0;//最大公约数
        Fraction c=null;
        ArrayList<Fraction> number = new ArrayList<>();
        int [][] arr=new int[4][];
        GenerNum g=new GenerNum();
       String str= g.formula();

        String[] tokens = str.split(" ");

      /*  for (String s: tokens)
            System.out.println(s);*/

       for(int i=0,j=0;i<tokens.length;j++){
            if(!tokens[i].contains("/")){
                try {
                numer= Integer.parseInt(tokens[i]);
               intge=0;denom=1;
                //System.out.println(a);
                    } catch (NumberFormatException e) {
                    e.printStackTrace();
                        }
                }else{
                String[] tokenss =tokens[i].split("\\'|\\/");
                //将带分数分离
                intge=Integer.parseInt(tokenss[0]);
                numer=Integer.parseInt(tokenss[1]);
                denom=Integer.parseInt(tokenss[2]);
                arr[j]=new int[]{intge,numer,denom};

            }
            Fraction shu=new Fraction(intge,numer,denom);
            number.add(shu);

           i+=2;
       }


       for(int i=0,j=1;i< (tokens.length-1)/2;i++) {
           Fraction stu = number.get(i);
           Fraction stuu = number.get(i+1);

            if(tokens[j].equals("×"))
                c = multip(stu, stuu);
            else if(tokens[j].equals("÷")) {
                c = divis(stu, stuu);
            }
            else if(tokens[j].equals("+"))
                c=add(stu,stuu);
            else if(tokens[j].equals("-")) {
                c = subtract(stu, stuu);
                if (c.numerator<0) {
                    flag="F";
                    break;
                }
            }
            number.set(i+1,c);

           j+=2;
       }

            if (c.numerator != 0) {               //若分子不为0，则对分子分母约分
                div = gcd(c.denominator, c.numerator);
                c.numerator /= div;
                c.denominator /= div;
            }

            if(c.numerator>c.denominator) {
                c.intger = c.numerator / c.denominator;
                c.numerator = c.numerator % c.denominator;
            }
                if(c.intger==0)
                    resul =c.numerator + "/" + c.denominator;
                else
                resul = c.intger+"'"+c.numerator + "/" + c.denominator;
                if(c.numerator==0)
                    flag=str+"="+c.intger;
               //System.out.println(str+"="+c.intger);
                else
                    flag=str+"="+resul;
                   // System.out.println(str+"="+resul);



        return flag;
    }

   public static Fraction add(Fraction a,Fraction b){

       Fraction c=new Fraction(1,1,1);
                c.denominator=a.denominator*b.denominator;
                c.numerator=a.numerator*b.denominator+b.numerator*a.denominator+(a.intger+b.intger)*c.denominator;
                c.intger=0;
        return c;
    }
    public static Fraction subtract(Fraction a,Fraction b){
        Fraction c=new Fraction(1,1,1);
        c.denominator=a.denominator*b.denominator;
        c.numerator=a.numerator*b.denominator-b.numerator*a.denominator+(a.intger-b.intger)*c.denominator;
        c.intger=0;
        return c;
    }
    public static Fraction multip(Fraction a,Fraction b){
        Fraction c=new Fraction(0,0,0);
        c.numerator=(a.denominator*a.intger+a.numerator)*(b.denominator*b.intger+b.numerator);
        c.denominator=a.denominator*b.denominator;
        return c;
    }

    public static Fraction divis(Fraction a,Fraction b){
        Fraction c=new Fraction(0,0,0);
        c.numerator=(a.denominator*a.intger+a.numerator)*b.denominator;
        c.denominator=a.denominator*(b.denominator*b.intger+b.numerator);
        return c;
    }
    public static int gcd(int a,int b) { //辗转相除法求最大公约数
        {
            int c=a % b;
            while(c!=0)
            {
                a = b;
                b = c;
                c = a % b;
            }
            return b;
        }
    }


}
