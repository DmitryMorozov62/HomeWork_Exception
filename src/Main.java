public class Main {

    public static void main(String[] args) {
        System.out.println(checkin( "Dmitry_Morozov62","Dima_morozov1234","Dima_morozov1234"));
    }

    public static boolean checkin(String login, String password, String configPassword) {
        try {
            return checkRegistration(login,password,configPassword);
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
            return false;
        } catch (WrongLoginException e) {
            System.out.println("Login и password должны быть меньше 20 симовлов");
            return false;
        } catch (NullPointerException e) {
            System.out.println("заполните все поля");
            return false;
        }
    }
    public static boolean checkRegistration(String login, String password, String configPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length()>20 || password.length()>20){
            throw new WrongLoginException();
        } else if(!password.equals(configPassword)) {
            throw new WrongPasswordException();
        } else if (!login.matches("^[a-zA-Z0-9-_]+$") || !password.matches("^[a-zA-Z0-9-_]+$")) {
            System.out.println("login и password должны содержать в себе только латинские буквы, цифры и знак подчеркивания.");
            return false;
        }
        return true;
    }
}
