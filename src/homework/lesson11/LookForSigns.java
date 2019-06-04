package homework.lesson11;

public class LookForSigns {
    public static void main(String[] args) {
        getMiddleSings("look");
    }

    private static void getMiddleSings(String str) {
        int length = str.length() / 2;
        System.out.print(str.charAt(length));
        System.out.print(str.charAt(length - 1));
    }
}
