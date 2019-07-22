package mainProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    private int id;
    private int category_id;
    private String name;
    private double price;
    private double rate;
    private List<Product> products = new ArrayList<>();

    public Product(List<Product> products) {
        this.products = products;
    }

    public Product(int id, int category_id, String name, double rate, double price) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public Product(int category_id, String name, double rate, double price) {
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public Product(String name, double rate, double price) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int category_id) {
        this.category_id = category_id;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                category_id == product.category_id &&
                Double.compare(product.price, price) == 0 &&
                Double.compare(product.rate, rate) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category_id, name, price, rate);
    }

    public void setCategoryInt(int categoryInt) {
        this.category_id = categoryInt;
    }

    @Override
    public String toString() {
        System.out.format("%-10s %8.2f %5.1f %4d %n", name, price, rate, category_id);

        return "";
    }
}
