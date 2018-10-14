package objectoriented.genericinnerclass;

import generic.genericinterface.Generator;

public class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer(){}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }

    public static Generator<Customer> generator(){   //
        return new Generator<Customer>(){                      //  a interface
            public Customer nect(){return new Customer();}
        };
    }
}