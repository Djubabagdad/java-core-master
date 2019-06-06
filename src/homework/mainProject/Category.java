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

    public static Builder newBuilder(int num) {
        return new Builder(num);
    }

    private Category(Builder builder) {
        this.name = builder.name;
        this.arrayOfProducts = builder.products;
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
        for(Product product: arrayOfProducts){
            result += product.getName() + "\n";
        }
        return "Category{"+ this.getName() + result + '}';
    }

    public static class Builder {

        private String name;
        private int arrayIndex = 0;
        private Product[] products;

        public Builder(int numb) {
            products = new Product[numb];
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder addProduct(Product product) {
            products[arrayIndex] = product;
            arrayIndex++;
            return this;
        }

        public Builder addProducts(Product... products) {
            for (Product product : products) {
                products[arrayIndex] = product;
                arrayIndex++;
            }
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
