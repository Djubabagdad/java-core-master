package homework.mainProject;

import java.util.Arrays;
import java.util.Objects;

public class Category {
    private String name;
    private Product[] arrayOfProducts;

    public Category(String name, Product[] arrayOfProducts) {
        this.name = name;
        this.arrayOfProducts = arrayOfProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getArrayOfProducts() {
        return arrayOfProducts;
    }

    public void setArrayOfProducts(Product[] arrayOfProducts) {
        this.arrayOfProducts = arrayOfProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return name.equals(category.name) &&
                Arrays.equals(arrayOfProducts, category.arrayOfProducts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(arrayOfProducts);
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (Product product : arrayOfProducts) {
            if (product == null) continue;
            result += product.getName() + "      " + product.getPrice() + "      " + product.getRate() + "\n";
        }
        return "Category   " + this.getName() + "\n" + result;
    }
}
