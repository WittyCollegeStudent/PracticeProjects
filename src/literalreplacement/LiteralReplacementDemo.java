package literalreplacement;

/**
 * @Author: weianyang
 * @Date: 2018/5/21 17:29
 * @Description: 文字替换
 */
public class LiteralReplacementDemo {

    public static void main(String[] args) {
        String s = "ABC";
        String s1 = s.replace("B", "\\");
        System.out.println(s1);
        String s2 = s.replaceAll("B", "\"");
        System.out.println(s2);
        String s3 = s.replaceAll("B", "\\\\\"");
        System.out.println(s3);
    }

}
