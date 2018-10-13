package generic.tutle;

public class ThreeTuple<A, B, C> extends TwoTuple {
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        ThreeTuple<Integer, Integer, Integer> t = new ThreeTuple<>(1, 2, 3);
        System.out.println(t.first);
        var javastack = "dfdf";
        System.out.println(javastack.getClass());
    }
}
