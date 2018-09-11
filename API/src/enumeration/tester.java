package enumeration;

import org.junit.jupiter.api.Test;

import java.util.*;

public class tester {

    // sometimes we use static final to represent the constant
    public static final int RED = 0x1;
    public static final int GREEN = 0x2;
    public static final int BLUE = 0x3;
    public int color;

    @Test
    public void test1() {
        color = RED;
        color = 4;
    }

    // enum
    public Color colorEnum;
    @Test
    public void test2(){
        colorEnum = Color.RED;


        System.out.println(colorEnum);
        System.out.println("name(): "+colorEnum.name());
        System.out.println("ordinal() "+colorEnum.ordinal());
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));
    }

    @Test
    public void setAndMap(){
        System.out.println("   ++++ EnumSet.allOf() ++++");
        EnumSet<Color> set = EnumSet.allOf(Color.class);

        System.out.println("   ++++ EnumSet ++++");
        for(Color c: set)
            System.out.println(c);
        System.out.println("   ++++ EnumMap ++++");
        EnumMap<Color,String> map = new EnumMap<Color, String>(Color.class);
        map.put(Color.RED,"red");
        map.put(Color.GREEN,"green");
        map.put(Color.BLUE,"blue");
        Set<Map.Entry<Color,String>> entrySet =  map.entrySet();

        for(Map.Entry e : entrySet){
            System.out.println(e.getKey()+" "+e.getValue());
        }


    }
}
