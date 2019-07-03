package mainProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
        List<Product> getPurchasedGoods = new ArrayList<>();

    public Basket(List<Product> getPurchasedGoods) {
        this.getPurchasedGoods = getPurchasedGoods;
    }

    public List<Product> getGetPurchasedGoods() {
        return getPurchasedGoods;
    }

    public void setGetPurchasedGoods(List<Product> getPurchasedGoods) {
        this.getPurchasedGoods = getPurchasedGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(getPurchasedGoods, basket.getPurchasedGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPurchasedGoods);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "getPurchasedGoods=" + getPurchasedGoods +
                '}';
    }
}
