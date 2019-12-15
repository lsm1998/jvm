/*
 * 作者：刘时明
 * 时间：2019/12/15-14:33
 * 作用：
 */

public class Hello
{
    private int i;
    private static int tom;

    public static void main(String[] args)
    {
        int sum = 0;
        for (int i = 0; i < 10; i++)
        {
            sum += i;
        }
        System.out.println(sum);
        String name = "hello";
        Hello user=new Hello();
        user.i=sum;
        System.out.println(user.i);
    }
}
