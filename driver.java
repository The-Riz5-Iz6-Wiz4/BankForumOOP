public class driver {
    public static void main(String[] args) {
        System.out.println("Welcome to someBank");

        Bank someBank = new  Bank("someBank");
        boolean state = true;

        Methods.bootUp(someBank, state);
    }
}
