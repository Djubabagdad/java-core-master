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

    private static Basket[] myBasket = new Basket[10];
    private static Category[] categ = new Category[3];


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
        categ[0] = phones;
        phones.getArrayOfProducts()[0] = product1Phone;
        phones.getArrayOfProducts()[1] = product2Phone;
        phones.getArrayOfProducts()[2] = product3Phone;
        phones.getArrayOfProducts()[3] = product4Phone;
        phones.getArrayOfProducts()[4] = product5Phone;
        phones.getArrayOfProducts()[5] = product6Phone;
        phones.getArrayOfProducts()[6] = product7Phone;
        phones.getArrayOfProducts()[7] = product8Phone;


        Category laptops = new Category("Laptops", new Product[10]);
        categ[1] = laptops;
        laptops.getArrayOfProducts()[0] = product1Laptop;
        laptops.getArrayOfProducts()[1] = product2Laptop;
        laptops.getArrayOfProducts()[2] = product3Laptop;
        laptops.getArrayOfProducts()[3] = product4Laptop;
        laptops.getArrayOfProducts()[4] = product5Laptop;
        laptops.getArrayOfProducts()[5] = product6Laptop;
        laptops.getArrayOfProducts()[6] = product7Laptop;
        laptops.getArrayOfProducts()[7] = product8Laptop;

        Category headphones = new Category("Headphones", new Product[10]);
        categ[2] = headphones;
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
                .withLogin("Djubabagdad")
                .withPassword("123456")
                .build();

        System.out.println("Введите Ваш логин и пароль ниже :");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String authentication1 = reader.readLine();
        String authentication = reader.readLine();

        Predicate<String> stringIsNotEmpty = str -> !str.isEmpty();
        Predicate<String> stringIsNotNull = str -> str != null;
        Predicate<String> myAuthentication = stringIsNotEmpty.and(stringIsNotNull);

        comeIn:
        if (myAuthentication.test(authentication) && myAuthentication.test(authentication1)) {
            if (authentication.equals(newUser.getPassword()) && authentication1.equals(newUser.getLogin())) {
                System.out.println("Welcome");
                System.out.println(phones.getName() + " " + laptops.getName() + " " + headphones.getName());
                String chooseYourCategory = reader.readLine();
                for (int i = 0; i < categ.length; i++)
                    if (chooseYourCategory.equals(categ[i].getName())) {
                        System.out.println(phones.toString());
                        prepareBasket(phones);
                    } else if (chooseYourCategory.equals(categ[i].getName())) {
                        System.out.println(laptops.toString());
                        prepareBasket(laptops);
                    } else if (chooseYourCategory.equals(categ[i].getName())) {
                        System.out.println(headphones.toString());
                        prepareBasket(headphones);
                    }
            }else{
                System.out.println("Login or Password is incorrect");
            }
        }else{
            System.out.println("Here is Empty");
        }
    }

    public static void prepareBasket(Category... categories) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String writeName;
        String name = null;
        String categoryName = null;
        double productPrice = 0;
        double sum = 0;
        while (!(writeName = reader.readLine()).equalsIgnoreCase("exit"))
            for (Category categorie : categories) {
                for (Product product : categorie.getArrayOfProducts()) {
                    if (product == null) continue;
                    if (writeName.equals(product.getName())) {
                        putProduct(product);
                        sum += product.getPrice();
                        name = product.getName();
                        categoryName = categorie.getName();
                        productPrice = product.getPrice();
                    }
                }
            }

        printCheck(name, categoryName, productPrice, sum);
    }

    static void printCheck(String name, String category, double productPrice, double sum) {
        LocalDate date = LocalDate.now();
        Locale locale = new Locale("ru", "RU");
        Locale locale2 = new Locale("en", "US");

        NumberFormat numb = NumberFormat.getCurrencyInstance();
        ResourceBundle rb = ResourceBundle.getBundle("buyersCheck", locale2);

        String check = rb.getString("str1");
        String check1 = rb.getString("str2");
        String check2 = rb.getString("str3");
        String check3 = rb.getString("str4");
        String check4 = rb.getString("str5");

        System.out.println(check + date);
        System.out.println();
        System.out.println(check1);
        System.out.println(check2);
        System.out.format("%s", name);
        System.out.format("%12s", category);
        System.out.format("%14s%n", numb.format(productPrice));
        System.out.println(check3);
        System.out.printf("%s %24s", check4, numb.format(sum));
    }

    private static Product putProduct(Product product) {

        int i = 0;
        if (myBasket[i] == null) {
            myBasket[i] = new Basket();
            //  myBasket[i].getPurchasedGoods();
        }
        myBasket[i].getPurchasedGoods()[i] = product;
        i++;

        return product;
    }
}
