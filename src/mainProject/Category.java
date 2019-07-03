package mainProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {
    private String name;
    List<Product> products = new ArrayList<>();

    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }

    @Override
    public String toString() {
        System.out.println(name + products);
        return "";
    }
}