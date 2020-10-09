package calculate;

public class Fraction {
    int intger=0;
    int numerator =0;//分子
    int denominator=0;//分母
    Fraction(int a,int b,int c){
        intger=a;
        numerator=b;
        denominator=c;

    }
    public int getIntger(){
        return intger;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public int fault(){
        return -1;
    }
}
