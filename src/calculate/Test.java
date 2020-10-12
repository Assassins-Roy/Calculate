package calculate;

public class Test {

    //测试生成题目
    public void testGener(){
        GenerNum g = new GenerNum();
        System.out.println(g.formula());
    }

    //测试四册运算
    public void testCount(){
        Count c=new Count();
        System.out.println(c.count());
    }


     //测试将字符串转换为分数
    public void testStrToFraction(){
        Fraction fraction = new Fraction(2, 2, 5);
        System.out.println("分子：" + fraction.getNumerator());
        System.out.println("分母：" + fraction.getDenominator());
    }
}
