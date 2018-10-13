package enumeration;

import java.util.Arrays;
import java.util.Random;

enum EnumInterfaceD {
    STOCK(Security.Stock.class), BOND(Security.Bond.class);
    Security[] values;

    EnumInterfaceD(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {SHORT, LONG, MARGIN}

        enum Bond implements Security {MUNICIPAL, JUNK}

    }

    public Security randomSelection() {
        Random random = new Random(50);
        return values[random.nextInt(values.length)];
    }

    public static void main(String[] args){
        Random random = new Random(47);
        EnumInterfaceD[] valueTemp = EnumInterfaceD.class.getEnumConstants();
        System.out.println(Arrays.toString(valueTemp));
        for(int i = 0; i < 10; i ++){
            EnumInterfaceD category = valueTemp[random.nextInt(valueTemp.length)];
            System.out.println(category+" : "+category.randomSelection());

        }
    }
}
