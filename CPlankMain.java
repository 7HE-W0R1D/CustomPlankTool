import java.util.Scanner;

public class CPlankMain {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        boolean run = true;

        System.out.println("Welcome to the custom plank solver");
        System.out.println("");
        System.out.println("Please enter one or more space between number and unit (2.3 m/s, 3 kg)");
        System.out.println("If you need sentific notation, use the 'e' form (3.1 * 10 ^ -12 = 3.1e-12)");
        System.out.println("");

        while (run) {

            System.out.print("Input the custom Plank (without unit): ");
            CPlank test = new CPlank(Double.parseDouble(console.nextLine()));
            System.out.println("");

            for (int i = 0; i < 4; i++) {
                System.out.println("Object " + (i + 1));
                test.testObj(console);
            }
            run = yesTo("Do you want to use again?", console);

        }
    }

    public static boolean yesTo(String prompt, Scanner console) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }
}
