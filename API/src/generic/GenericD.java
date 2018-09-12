package generic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GenericD {
    @Test
    public void test1() {
        Node<Number> n1 = new Node<>(20);
        Node<Integer> n2 = new Node<>(10);


        getData(n1);
//    getData(n2); error
        getData2(n2);
        getUpperNumberData(n1);
        getUpperNumberData(n2); // the Subclasses of Number are AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, DoubleAccumulator, DoubleAdder, Float, Integer, Long, LongAccumulator, LongAdder, Short
    }

    public static void getData(Node<Number> node) {
        System.out.println(node.getData());
    }

    public static void getData2(Node<?> node) {
        System.out.println(node.getData());
    }

    public static void getUpperNumberData(Node<? extends Number> data){
        System.out.println(data.getData());
    }

    public static <T> T[] func(T[] array, int i , int j){   // generic method
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    @Test
    public void test4(){
        String[] arrays = {"vince", "jack", "Tom", "lily"};
        String[] strs = func(arrays,0,1);
        System.out.println(Arrays.toString(strs));
    }




}
