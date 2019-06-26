package homework.mainProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Category {
    private String name;
    Map<String, Product> productMap = new HashMap<>();

    public Category(String name, Map<String, Product> productMap) {
        this.name = name;
        this.productMap = productMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(productMap, category.productMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productMap);
    }

    @Override
    public String toString() {
        System.out.println(name + productMap);
        return "";
    }
}