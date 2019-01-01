package stringdemo;

import org.apache.commons.lang.ArrayUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author zhangbo22479
 * @date 2018/12/26
 * @description 获取码点长度
 */
public class CodePointCount {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String greeting = "Hello我你\uD835\uDD46";
        int codePointCnt = greeting.codePointCount(0, greeting.length());
        System.out.println(String.format("码点数量为%s", codePointCnt));
        System.out.println(String.format("代码单元数量为%s", greeting.length()));
        System.out.println(String.format("bytes:%s", greeting.getBytes("UTF-16").length));
        System.out.println(ArrayUtils.toString(greeting.getBytes("UTF-16")));
        char temp = '我';
        // Look inside c:\ users
        System.out.println(Character.toString(temp));
    }

}
