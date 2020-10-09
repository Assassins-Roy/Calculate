package calculate;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int num=Integer.parseInt(n);
        for(int i=0;i<num;i++){
            Count a=new Count();
            if(a.count()!="F") {
                //System.out.println("T");
                System.out.println(a.count());
            }else{

                i=i-1;
            }
        }

    }
}
