package objectoriented.genericinnerclass;

import generic.genericinterface.Generator;

public class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller nect() {
            return new Teller();
        }
    };
}
