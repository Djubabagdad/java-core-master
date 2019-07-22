package classwork.lesson18;

public class Authentication {
    public static void main(String[] args) {
            System.out.println(verify("Login","Password1", "Password1"));
            System.out.println(verify("Login","Password1", "Password1"));
            System.out.println(verify("Login","Password1qweqweqweaa", "Password1"));
    }
    private static boolean verify(String login, String password, String confirmPassword)  {
        try {
            if (login.length()>20){
                throw new WrongLoginException("Login > 20");
            }
            if(password.length()>20 || !(password.equals(confirmPassword))){
                throw new WrongPasswordException("Password > 20 or password!=confirmPassword");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println( e.getMessage());
            return false;
        }finally {
            System.out.println(login);
            System.out.println(password);
            System.out.println(confirmPassword);
        }
        return true;
    }
}
