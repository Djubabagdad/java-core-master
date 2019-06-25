package homework.mainProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;


public class Rozetka {

    private static Basket[] myBasket = new Basket[1];
    private static Category[] categories = new Category[3];
    private static int i = 0;
    private static Category laptops = new Category("Laptops", new Product[10]);
    private static Category phones = new Category("Phones", new Product[10]);
    private static Category headphones = new Category("Headphones", new Product[10]);


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

        Category phones = new Category("Phones", new Product[10]);
        categories[0] = phones;
        phones.getArrayOfProducts()[0] = product1Phone;
        phones.getArrayOfProducts()[1] = product2Phone;
        phones.getArrayOfProducts()[2] = product3Phone;
        phones.getArrayOfProducts()[3] = product4Phone;
        phones.getArrayOfProducts()[4] = product5Phone;
        phones.getArrayOfProducts()[5] = product6Phone;
        phones.getArrayOfProducts()[6] = product7Phone;
        phones.getArrayOfProducts()[7] = product8Phone;


        Category laptops = new Category("Laptops", new Product[10]);
        categories[1] = laptops;
        laptops.getArrayOfProducts()[0] = product1Laptop;
        laptops.getArrayOfProducts()[1] = product2Laptop;
        laptops.getArrayOfProducts()[2] = product3Laptop;
        laptops.getArrayOfProducts()[3] = product4Laptop;
        laptops.getArrayOfProducts()[4] = product5Laptop;
        laptops.getArrayOfProducts()[5] = product6Laptop;
        laptops.getArrayOfProducts()[6] = product7Laptop;
        laptops.getArrayOfProducts()[7] = product8Laptop;

        Category headphones = new Category("Headphones", new Product[10]);
        categories[2] = headphones;
        headphones.getArrayOfProducts()[0] = product1Headphone;
        headphones.getArrayOfProducts()[1] = product2Headphone;
        headphones.getArrayOfProducts()[2] = product3Headphone;
        headphones.getArrayOfProducts()[3] = product4Headphone;
        headphones.getArrayOfProducts()[4] = product5Headphone;
        headphones.getArrayOfProducts()[5] = product6Headphone;
        headphones.getArrayOfProducts()[6] = product7Headphone;
        headphones.getArrayOfProducts()[7] = product8Headphone;
        headphones.getArrayOfProducts()[8] = product9Headphone;

        User newUser = new User.Builder()
                .withLogin("D")
                .withPassword("1")
                .build();

        System.out.println("Введите Ваш логин и пароль ниже :");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String login = reader.readLine();
        String password = reader.readLine();

        Predicate<String> stringIsNotEmpty = str -> !str.isEmpty();
        Predicate<String> stringIsNotNull = str -> str != null;
        Predicate<String> myAuthentication = stringIsNotEmpty.and(stringIsNotNull);

        if (myAuthentication.test(login) && myAuthentication.test(password) &&
                password.equals(newUser.getPassword()) && login.equals(newUser.getLogin())) {
            System.out.println("Welcome");
            openCategories();
        } else {
            System.out.println("Login or Password is incorrect, or lines are empty");
        }
    }


    private static void openCategories() throws IOException {
        System.out.println(phones.getName() + " " + laptops.getName() + " " + headphones.getName());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String chooseYourCategory = reader.readLine();
        for (Category category : categories) {
            if (chooseYourCategory.equals(category.getName())) {
                System.out.println(category);
                prepareBasket(category);
            }
        }
    }

    public static void prepareBasket(Category... categories) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String writeName;
        String categoryName = null;
        double sum = 0;
        while (!(writeName = reader.readLine()).equalsIgnoreCase("buy"))
        for (Category newCategory : categories) {
            for (Product product : newCategory.getArrayOfProducts()) {
                if (product == null) {
                    continue;
                }
                if (writeName.equals(product.getName())) {
                    putProduct(product);
                    sum += product.getPrice();
                    categoryName = newCategory.getName();

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

    private static Product putProduct(Product product) {

        if (myBasket[0] == null) {
            myBasket[0] = new Basket();
        }
        myBasket[0].getPurchasedGoods()[i++] = product;

        return product;
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