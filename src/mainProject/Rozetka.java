package mainProject;

import classwork.lesson10.lesson18.WrongLoginException;
import classwork.lesson10.lesson18.WrongPasswordException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;


public class Rozetka {

    private static List<Product> myBasket = new ArrayList<>();
    private static Map<String, Category> categories = new HashMap<>();
    private static List<Product> phones = new ArrayList<>();
    private static List<Product> laptops = new ArrayList<>();
    private static List<Product> headphones = new ArrayList<>();
    private static Category phone = new Category("Phones", phones);
    private static Category laptop = new Category("Laptops", laptops);
    private static Category headphone = new Category("Headphones", headphones);


    public static void main(String[] args) throws IOException {

        Product product1Phone = new Product("Iphone X", 27000, 9.8);
        Product product2Phone = new Product("Meizu", 4500, 7.3);
        Product product3Phone = new Product("Huawei", 6000, 4.8);
        Product product4Phone = new Product("Asus", 9000, 3.3);
        Product product5Phone = new Product("Motorolla", 2500, 5.5);
        Product product6Phone = new Product("Nokia", 2000, 2.5);
        Product product7Phone = new Product("Samsung", 7800, 10.0);
        Product product8Phone = new Product("Iphone 5S", 27000, 9.3);

        Product product1Laptop = new Product("Asus", 56000, 10.99);
        Product product2Laptop = new Product("Dell", 34000, 5.4);
        Product product3Laptop = new Product("Samsung", 9000, 3.2);
        Product product4Laptop = new Product("MacBook", 34000, 9.5);
        Product product5Laptop = new Product("Acer", 20000, 6.1);
        Product product6Laptop = new Product("HP", 34000, 7.2);
        Product product7Laptop = new Product("MSI", 56000, 5.1);
        Product product8Laptop = new Product("Presigio", 56000, 2.2);

        Product product1Headphone = new Product("Asus", 10000, 7.5);
        Product product2Headphone = new Product("Dr.dre", 5550, 8.5);
        Product product3Headphone = new Product("Beats", 650, 9.5);
        Product product4Headphone = new Product("Xiaomi", 10000, 6.9);
        Product product5Headphone = new Product("Sony", 10000, 2.5);
        Product product6Headphone = new Product("Panasonic", 10000, 3.5);
        Product product7Headphone = new Product("Shure", 10000, 1.5);
        Product product8Headphone = new Product("HyperX", 10000, 6.1);
        Product product9Headphone = new Product("Koss", 10000, 6.8);


        phones.add(product1Phone);
        phones.add(product2Phone);
        phones.add(product3Phone);
        phones.add(product4Phone);
        phones.add(product5Phone);
        phones.add(product6Phone);
        phones.add(product7Phone);
        phones.add(product8Phone);


        laptops.add(product1Laptop);
        laptops.add(product2Laptop);
        laptops.add(product3Laptop);
        laptops.add(product4Laptop);
        laptops.add(product5Laptop);
        laptops.add(product6Laptop);
        laptops.add(product7Laptop);
        laptops.add(product8Laptop);

        headphones.add(product1Headphone);
        headphones.add(product2Headphone);
        headphones.add(product3Headphone);
        headphones.add(product4Headphone);
        headphones.add(product5Headphone);
        headphones.add(product6Headphone);
        headphones.add(product7Headphone);
        headphones.add(product8Headphone);
        headphones.add(product9Headphone);

        categories.put("Phones", phone);
        categories.put("Laptops", laptop);
        categories.put("Headphones", headphone);


        User newUser = new User("D", "1");
        String login = null;
        String password;

        Predicate<String> stringIsNotEmpty = str -> !str.isEmpty();
        Predicate<String> stringIsNotNull = Objects::nonNull;
        Predicate<String> myAuthentication = stringIsNotEmpty.and(stringIsNotNull);

        do {
            System.out.println(login == null ? "Введите Ваш логин и пароль ниже :" : "Неправильный логин или пароль, повторите.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            login = reader.readLine();
            password = reader.readLine();

            verify(login, password);

        } while (!(myAuthentication.test(login) && myAuthentication.test(password) &&
                password.equals(newUser.getPassword()) && login.equals(newUser.getLogin())));

        System.out.println("Welcome");

        Set<String> keys = categories.keySet();

        for (String key : keys) {
            System.out.print(key + "   ");
        }
        System.out.println();

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String chooseYourCategory = reader1.readLine();


        for (String key : keys) {
            if (chooseYourCategory.equals(key)) {
                for (Category category : categories.values()) {
                    if (key.equals(category.getName())) {
                        category.getProducts().sort(Comparator.comparing(Product::getRate).reversed());
                        category.getProducts().forEach(System.out::println);
                        prepareBasket(category.getProducts(), category);
                    }
                }
            }
        }
    }


    private static void prepareBasket(List<Product> category, Category categories) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String writeName;
        String categoryName = null;
        double sum = 0;
        while (!(writeName = reader.readLine()).equalsIgnoreCase("buy")) {
            for (Product product : category) {
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
        printProducts(category);
        System.out.println(separator2);
        System.out.printf("%s %24s", amount, numb.format(sum));
    }

    private static void putProduct(Product product) {
        myBasket.add(product);
    }

    private static void printProducts(String category) {
        NumberFormat numb = NumberFormat.getCurrencyInstance();
        for (Product product : myBasket) {
            System.out.format("%-5s %12s %14s%n", product.getName(), category, numb.format(product.getPrice()));
        }
    }
    private static boolean verify(String login, String password)  {
        try {
            if (login.length()>20){
                throw new WrongLoginException("Login > 20");
            }
            if(password.length()>20){
                throw new WrongPasswordException("Password > 20");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println( e.getMessage());
            System.out.println();
            return false;
        }
        return true;
    }

}