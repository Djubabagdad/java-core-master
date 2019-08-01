package mainProject;

import classwork.lesson18.WrongLoginException;
import classwork.lesson18.WrongPasswordException;
import mainProject.daoClasses.CategoryDao;
import mainProject.daoClasses.ProductDao;
import mainProject.daoClasses.UserDao;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;


public class Rozetka {

    private static List<Product> myBasket = new ArrayList<>();
    private static File file = new File("report.txt");
    private static double sum;
    private static String categoryName;
    private static ProductDao productDao = new ProductDao();
    private static UserDao userDao = new UserDao();
    private static CategoryDao categoryDao = new CategoryDao();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        String login = null;
        String password;

        Predicate<String> stringIsNotEmpty = str -> !str.isEmpty();
        Predicate<String> stringIsNotNull = Objects::nonNull;
        Predicate<String> myAuthentication = stringIsNotEmpty.and(stringIsNotNull);

        do {
            System.out.println(login == null ? "Write your login and password :" : "Incorrect login or password, try one more time");

            login = reader.readLine();
            password = reader.readLine();

            verify(login, password);

        } while (!(myAuthentication.test(login) && myAuthentication.test(password) &&
                !(userDao.findEntityByLoginAndPassword(login, password)).equals(true)));

        System.out.println("Welcome");
        System.out.println();
        String command;


        do {
            System.out.println("Category  Check  " + "Basket  " + "Exit");
            command = reader.readLine().toUpperCase();
            switch (Operations.valueOf(command)) {
                case CATEGORY:
                    printCategories();
                    break;
                case CHECK:
                    printCheck(categoryName, sum);
                    break;
                case BAKSET:
                    System.out.println(myBasket);
            }
            command = reader.readLine();
        } while (!(command.equalsIgnoreCase("exit")));
    }

    private static void printCategories() throws IOException {
        System.out.println(categoryDao.findAll());
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number != 0) {
                System.out.println(productDao.findEntityByCategoryId(number));
                Category category = categoryDao.findEntityById(number);
                categoryName = category.getName();
                prepareBasket(productDao.findEntityByCategoryId(number));

            }
        }
    }

    private static void prepareBasket(List<Product> products) throws IOException {

        String writeName;
        while (!(writeName = reader.readLine()).equalsIgnoreCase("back")) {
            for (Product product : products) {
                if (product == null) {
                    continue;
                }
                if (writeName.equals(product.getName())) {
                    myBasket.add(product);
                    sum += product.getPrice();
                }
            }
        }
    }


    private static void printCheck(String category, double sum) {
        Locale locale = new Locale("ru", "RU");
        Locale locale2 = new Locale("en", "US");
        Locale.setDefault(locale);

        ResourceBundle rb = ResourceBundle.getBundle("buyersCheck", locale2);

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
        System.out.printf("%s %24s", amount, sum + " $");
    }

    private static void printProducts(String category) {
        for (Product product : myBasket) {
            System.out.format("%-5s %12s %11s%n", product.getName(), category, product.getPrice() + " $");
        }
        printReport(category);
    }

    private static void printReport(String category) {
        for (Product product : myBasket) {
            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(product.getName() + " " + category + " " + product.getPrice());
                fw.append('\n');
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean verify(String login, String password) {
        try {
            if (login.length() > 20) {
                throw new WrongLoginException("Login > 20");
            }
            if (password.length() > 20) {
                throw new WrongPasswordException("Password > 20");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return false;
        }
        return true;
    }
}
