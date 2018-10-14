package generic.genericinterface;

import generic.fibonacci.Fibonacci;
import generic.genericinterface.Coffee;
import generic.genericinterface.CoffeeGenerator;
import generic.genericinterface.Generator;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
        for(int i = 0; i < n ; i++)
            coll.add(gen.nect());
        return coll;
    }

    public static void main(String[] args){
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(),4);
        coffee.forEach(s-> System.out.println(s+" "));
        Collection<Integer> fnumbers = fill(new ArrayList<>(), new Fibonacci(),12);
        fnumbers.forEach(s-> System.out.print(s+" "));
    }
}
