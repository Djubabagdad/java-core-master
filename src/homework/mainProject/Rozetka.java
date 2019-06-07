package homework.mainProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rozetka {

    private static Basket[] myBasket = new Basket[10];


    public static void main(String[] args) throws IOException {
        Product product1Phone = new Product("Iphone X", 27000, 9.8);
        Product product2Phone = new Product("Meizu", 4500, 7.3);
        Product product3Phone = new Product("Huawei", 6000, 4.8);
        Product product4Phone = new Product("Asus", 9000, 3.3);
        Product product5Phone = new Product("Motorolla", 2500, 5.5);
        Product product6Phone = new Product("Nokia", 2000, 2.5);
        Product product7Phone = new Product("Samsung", 7800, 10.0);
        Product product8Phone = new Product("Iphone 5S", 27000, 9.8);

        Product product1Laptop = new Product("Asus", 56000, 10.99);
        Product product2Laptop = new Product("Dell", 34000, 5.4);
        Product product3Laptop = new Product("Samsung", 9000, 3.2);
        Product product4Laptop = new Product("MacBook", 34000, 9.5);
        Product product5Laptop = new Product("Acer", 20000, 6.1);
        Product product6Laptop = new Product("HP", 34000, 7.2);
        Product product7Laptop = new Product("MSI", 56000, 5.1);
        Product product8Laptop = new Product("Presigio", 56000, 2.2);

        Product product1Headphone = new Product("Asus", 10000, 6.5);
        Product product2Headphone = new Product("Dr.dre", 5550, 2.5);
        Product product3Headphone = new Product("Beats", 650, 6.5);
        Product product4Headphone = new Product("Xiaomi", 10000, 6.5);
        Product product5Headphone = new Product("Sony", 10000, 6.5);
        Product product6Headphone = new Product("Panasonic", 10000, 6.5);
        Product product7Headphone = new Product("Shure", 10000, 6.5);
        Product product8Headphone = new Product("HyperX", 10000, 6.5);
        Product product9Headphone = new Product("Koss", 10000, 6.5);


        Category phone = Category.newBuilder(8)
                .withName("Phones")
                .addProduct(product1Phone)
                .addProduct(product2Phone)
                .addProduct(product3Phone)
                .addProduct(product4Phone)
                .addProduct(product5Phone)
                .addProduct(product6Phone)
                .addProduct(product7Phone)
                .addProduct(product8Phone)
                .build();

        Category laptops = Category.newBuilder(8)
                .withName("Laptops")
                .addProduct(product1Laptop)
                .addProduct(product2Laptop)
                .addProduct(product3Laptop)
                .addProduct(product4Laptop)
                .addProduct(product5Laptop)
                .addProduct(product6Laptop)
                .addProduct(product7Laptop)
                .addProduct(product8Laptop)
                .build();

        Category headphones = Category.newBuilder(9)
                .withName("Headphones")
                .addProduct(product1Headphone)
                .addProduct(product2Headphone)
                .addProduct(product3Headphone)
                .addProduct(product4Headphone)
                .addProduct(product5Headphone)
                .addProduct(product6Headphone)
                .addProduct(product7Headphone)
                .addProduct(product8Headphone)
                .addProduct(product9Headphone)
                .build();

        User newUser = new User.Builder()
                .withLogin("Djubabagdad")
                .withPassword("123456")
                .build();

        System.out.println("Введите Ваш логин и пароль ниже :");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String authentication1 = reader.readLine();
        String authentication = reader.readLine();

        if (authentication.equals(newUser.getPassword()) && authentication1.equals(newUser.getLogin())) {
            System.out.println("Welcome");
        } else {
            System.out.println("Get out!");
        }
        System.out.println(phone.getName() + " " + laptops.getName() + " " + headphones.getName());
        String chooseYourCategory = reader.readLine();

        if (chooseYourCategory.equals(phone.getName())) {
            System.out.println(phone.toString());
            chooseProduct(phone);
        } else if (chooseYourCategory.equals(laptops.getName())) {
            System.out.println(laptops.toString());
            chooseProduct(laptops);
        } else if (chooseYourCategory.equals(headphones.getName())) {
            System.out.println(headphones.toString());
            chooseProduct(headphones);
        }
    }

    public static void chooseProduct(Category... categories) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String writeName;
        double sum = 0;
        while (!(writeName = reader.readLine()).equalsIgnoreCase("exit"))
            for (Category categorie : categories) {
                for (Product product : categorie.getArrayOfProducts()) {
                    if (writeName.equals(product.getName())) {
                        putProduct(product);
                        sum += product.getPrice();
                    }
                }
            }
        System.out.println(sum);
    }

    private static Product putProduct(Product product) {
        int i = 0;
        if (myBasket[i] == null) {
            myBasket[i] = new Basket();
            myBasket[i].getPurchasedGoods();
        }
        myBasket[i].getPurchasedGoods()[i] = product;
        i++;
        return product;
    }
}
