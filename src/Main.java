public class Main {

    public static void main(String[] args) {
        System.out.println(checkin( "Dima_morozov62","Dima_morozov12344","Dima_morozov1234"));
    }

    public static boolean checkin(String login, String password, String configPassword) {
        try {
            return checkRegistration(login,password,configPassword);
        } catch (WrongPasswordException | WrongLoginException e) {
            e.printStackTrace();
            return false;
        } catch (NullPointerException e) {
            System.out.println("заполните все поля");
            return false;
        }
    }
    public static boolean checkRegistration(String login, String password, String configPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length()>20 || password.length()>20){
            throw new WrongLoginException("Login и password должны быть меньше 20 симовлов");
        } else if(!password.equals(configPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        } else if (!login.matches("^[a-zA-Z0-9-_]+$") || !password.matches("^[a-zA-Z0-9-_]+$")) {
            System.out.println("login и password должны содержать в себе только латинские буквы, цифры и знак подчеркивания.");
            return false;
        }
        return true;
    }
}
