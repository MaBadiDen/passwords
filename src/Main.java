import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        if(checkUserParameters("Ababababababababab", "1234%", "1234%")) {
            System.out.println("Пользователь красавчик");
        } else {
            System.out.println("Пользователь клоун");
        }
    }

    public static boolean checkUserParameters(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            return false;
        } finally {
            System.out.println("Проверка пользователя завершена");
        }
        return true;
    }

    public static void checkLogin(String login) {
        if(login.length() > 20 || login.matches("\\w+")) throw new WrongLoginException();
    }
    public static void checkPassword(String password, String confirmPassword) {
        if(password.length() >= 20 || !password.equals(confirmPassword) || password.matches("\\w+")) throw new WrongPasswordException();
    }
}