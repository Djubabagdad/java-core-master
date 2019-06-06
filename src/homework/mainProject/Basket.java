package homework.mainProject;

import java.util.Arrays;

public class Basket {
    private Product[] purchasedGoods = new Product[10];
    private int currentElement;

    public Basket() {

    }

    public Basket(Product[] purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public int getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(int currentElement) {
        this.currentElement = currentElement;
    }

    public Product[] getPurchasedGoods() {
        return purchasedGoods;
    }

    public void setPurchasedGoods(Product[] purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Arrays.equals(purchasedGoods, basket.purchasedGoods);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(purchasedGoods);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "purchasedGoods=" + Arrays.toString(purchasedGoods) +
                '}';
    }
}
