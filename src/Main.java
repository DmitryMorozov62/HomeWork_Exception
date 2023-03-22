public class Main {

    public static void main(String[] args) {
        System.out.println(checkin( "Dmitry_Morozov62","Dima_morozov1234","Dima_morozov1234"));
    }

    public static boolean checkin(String login, String password, String configPassword) {
        try {
            checkRegistration(login,password,configPassword);
            return true;
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");;
            return false;
        } catch (WrongLoginException e) {
            System.out.println("Login и password должны быть меньше 20 симовлов и содержать в себе только латинские буквы, цифры и знак подчеркивания.");
            return false;
        } catch (NullPointerException e) {
            System.out.println("заполните все поля");;
            return false;
        }
    }
    public static boolean checkRegistration(String login, String password, String configPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length()>20 || password.length()>20|| !login.matches("^[a-zA-Z0-9-_]+$") || !password.matches("^[a-zA-Z0-9-_]+$")){
            throw new WrongLoginException();
        } else if(!password.equals(configPassword)) {
            throw new WrongPasswordException();
        }
        return true;
    }
}
