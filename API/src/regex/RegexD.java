package regex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexD {

    @Test
    public void test1() {
        String string = "3425234";
        char[] s = string.toCharArray();
        boolean flag = true;
        for (int i = 0; i < s.length; i++) {

            if (s[i] < '0' || s[i] > '9') {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("是由数组组成");
        } else {
            System.out.println("不是由数字组成");
        }

        System.out.println("3425234".matches("[0-9]+"));

        Pattern p = Pattern.compile("a*b");
        Matcher matcher = p.matcher("aaaab");
        boolean b = matcher.matches();
        System.out.println(b);
    }

    @Test
    public void test2() {
        System.out.println("010-38389438".matches("\\d{3,4}-\\d{7,8}"));
        System.out.println("13895271234".matches("1[3-9]\\d{9}"));
        System.out.println("abc1234".matches("[a-zA-Z]+[\\w|_]*"));
        System.out.println("20.10.20.123".matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));
        System.out.println("http://www.baidu.com".matches("http://\\w+.\\w+.\\S*"));
        System.out.println("18".matches("\\d{1,3}"));
        System.out.println("19.8".matches("\\d+.\\d+"));

        System.out.println("0".matches("[50-36]")); // true
        System.out.println("1".matches("[50-36]")); // true
        System.out.println("2".matches("[50-36]")); // false
        System.out.println("3".matches("[50-36]")); // false
        System.out.println("4".matches("[50-36]")); // true
        System.out.println("5".matches("[50-36]")); // true
        System.out.println("6".matches("[50-36]")); // false
    }

    @Test
    public void testtt(){
        String poem = "the slithy toves";
        Pattern p1 = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$");
        Pattern p2 = Pattern.compile("t[o]+[\\w]+");
        Matcher m = p2.matcher(poem);

        while(m.find())
            System.out.println("["+m.group()+"]");

        System.out.println(p1.matcher(poem).matches());

        System.out.println(Arrays.toString(poem.split("[\\s]+")));


    }

}
