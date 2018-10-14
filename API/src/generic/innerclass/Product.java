package generic.innerclass;

import generic.genericinterface.Generator;

import java.util.Random;

public class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator =
            new Generator<Product>() {
                @Override
                public Product nect() {
                    return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000) + 0.99);
                }

                private Random rand = new Random(47);
            };
}
