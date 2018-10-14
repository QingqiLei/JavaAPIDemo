package generic.fibonacci;

import generic.genericinterface.Generator;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    private int fib(int n){
        if(n < 2) return 1;
        return fib(n-2)+fib(n-1);
    }

    public static void main(String[] args){
        Fibonacci gen = new Fibonacci();
        for(int i = 0; i < 45; i ++){
            System.out.println(gen.nect()+" ");
        }
    }

    @Override
    public Integer nect() {
        return fib(count++);
    }


}
