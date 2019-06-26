package homework.mainProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;


public class Rozetka {

    private static Basket[] myBasket = new Basket[1];
    private static int i = 0;
    private static Map<String, Product> headphone = new HashMap<>();
    private static Map<String, Product> laptop = new HashMap<>();
    private static Map<String, Product> phone = new TreeMap<>(String::compareTo);
    private static Category phones = new Category("Phones", phone);
    private static Category laptops = new Category("Laptops", laptop);
    private static Category headphones = new Category("Headphones", headphone);


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


        phone.put("Iphone X", product1Phone);
        phone.put("Meizu", product2Phone);
        phone.put("Huawei", product3Phone);
        phone.put("Asus", product4Phone);
        phone.put("Motorolla", product5Phone);
        phone.put("Nokia", product6Phone);
        phone.put("Samsung", product7Phone);
        phone.put("Iphone 5S", product8Phone);


        laptop.put("Asus", product1Laptop);
        laptop.put("Dell", product2Laptop);
        laptop.put("Samsung", product3Laptop);
        laptop.put("Macbook", product4Laptop);
        laptop.put("Acer", product5Laptop);
        laptop.put("MSI", product6Laptop);
        laptop.put("HP", product7Laptop);
        laptop.put("Presigio", product8Laptop);

        headphone.put("Asus", product1Headphone);
        headphone.put("Dr.dre", product2Headphone);
        headphone.put("Beats", product3Headphone);
        headphone.put("Xiaomi", product4Headphone);
        headphone.put("Sony", product5Headphone);
        headphone.put("Panasonic", product6Headphone);
        headphone.put("Shure", product7Headphone);
        headphone.put("HyperX", product8Headphone);
        headphone.put("Koss", product9Headphone);


        User newUser = new User("D", "1");

        System.out.println("Введите Ваш логин и пароль ниже :");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String login = reader.readLine();
        String password = reader.readLine();

        Predicate<String> stringIsNotEmpty = str -> !str.isEmpty();
        Predicate<String> stringIsNotNull = Objects::nonNull;
        Predicate<String> myAuthentication = stringIsNotEmpty.and(stringIsNotNull);

        if (myAuthentication.test(login) && myAuthentication.test(password) &&
                password.equals(newUser.getPassword()) && login.equals(newUser.getLogin())) {
            System.out.println("Welcome");
            System.out.println(phones.getName() + " " + laptops.getName() + " " + headphones.getName());
            String chooseYourCategory = reader.readLine();
            switch (chooseYourCategory) {
                case "Phones": {
                    Set<String> sortedCategory = new TreeSet<>(Comparator.comparing(String::toString));
                    Set<String> keys = phone.keySet();
                    sortedCategory.addAll(keys);
                    sortedCategory.forEach(k -> System.out.println(phone.get(k)));
                    prepareBasket(phone, phones);
                    break;
                }
                case "Laptops": {
                    Set<String> sortedCategory = new TreeSet<>(Comparator.comparing(String::toString));
                    Set<String> keys = laptop.keySet();
                    sortedCategory.addAll(keys);
                    sortedCategory.forEach(k -> System.out.println(laptop.get(k)));
                    prepareBasket(laptop, laptops);
                    break;
                }
                case "Headphones": {
                    Set<String> sortedCategory = new TreeSet<>(Comparator.comparing(String::toString));
                    Set<String> keys = headphone.keySet();
                    sortedCategory.addAll(keys);
                    sortedCategory.forEach(k -> System.out.println(headphone.get(k)));
                    prepareBasket(headphone, headphones);
                    break;
                }
            }
        } else {
            System.out.println("Login or Password is incorrect, or lines are empty");
        }
    }

    private static void prepareBasket(Map<String, Product> category, Category categories) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String writeName;
        String categoryName = null;
        double sum = 0;
        while (!(writeName = reader.readLine()).equalsIgnoreCase("buy")) {
            Collection<Product> collection = category.values();
            for (Product product : collection) {
                if (product == null) {
                    continue;
                }
                if (writeName.equals(product.getName())) {
                    putProduct(product);
                    sum += product.getPrice();
                    categoryName = categories.getName();
                }
            }
        }

        printCheck(categoryName, sum);
    }


    private static void printCheck(String category, double sum) {
        Locale locale = new Locale("ru", "RU");
        Locale locale2 = new Locale("en", "US");
        Locale.setDefault(locale2);

        ResourceBundle rb = ResourceBundle.getBundle("buyersCheck", locale);

        NumberFormat numb = NumberFormat.getCurrencyInstance();
        LocalDate date = LocalDate.now();

        String dateOnCheck = rb.getString("Date");
        String categoriesNames = rb.getString("Names");
        String separator1 = rb.getString("Separator1");
        String separator2 = rb.getString("Separator2");
        String amount = rb.getString("Amount");

        System.out.println(dateOnCheck + date);
        System.out.println();
        System.out.println(categoriesNames);
        System.out.println(separator1);
        checkProducts(category);
        System.out.println(separator2);
        System.out.printf("%s %24s", amount, numb.format(sum));
    }

    private static void putProduct(Product product) {

        if (myBasket[0] == null) {
            myBasket[0] = new Basket();
        }
        myBasket[0].getPurchasedGoods()[i++] = product;
    }

    private static void checkProducts(String category) {
        for (Basket basket : myBasket) {
            if (basket == null) {
                continue;
            }
            for (Product product : basket.getPurchasedGoods()) {
                if (product == null) {
                    continue;
                }
                NumberFormat numb = NumberFormat.getCurrencyInstance();
                System.out.format("%-5s %12s %14s%n", product.getName(), category, numb.format(product.getPrice()));
            }
        }
    }
}