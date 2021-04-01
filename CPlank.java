import java.util.*;

public class CPlank {

    private double customPlank;
    public static final char[] MULTIPLER = {'p','-','-','n','-','-','u','-','-','m','c','d','-','-','-','k','-','-','M','-','-','G'};

    public CPlank(double inputPlank) {
        customPlank = inputPlank;
    }

    public void testObj(Scanner input) {
        System.out.print("Mass: ");
        String massStr = input.nextLine();
        System.out.print("Size: ");
        String sizeStr = input.nextLine();
        System.out.print("Speed: ");
        String speedStr = input.nextLine();
        
        double mass = Double.parseDouble(massStr.split(" ")[0]);
        double size = Double.parseDouble(sizeStr.split(" ")[0]);
        double speed = Double.parseDouble(speedStr.split(" ")[0]);

        double massWave = customPlank / (mass * 0.001 * selectUnit(massStr.split(" ")[1]) * 
                                         speed * (selectUnit(speedStr.split(" ")[1].split("/")[0]) / 
                                         selectUnit(speedStr.split(" ")[1].split("/")[1])));

        System.out.println("");                                 
        System.out.println("Mass wave length: " + massWave + "m");
        
        if (massWave < size * selectUnit(sizeStr.split(" ")[1])) {
            System.out.println("Classical");
        } else {
            System.out.println("Quantum");
        }
        System.out.println("");
    }

    private double selectUnit(String inputUnit) {

        if (inputUnit.equals("m")) {
            return 1.0;
        }
        
        if (inputUnit.equals("h")) {
            return 3600.0;
        }

        char multiplier = inputUnit.charAt(0);

        for (int i = 0; i < MULTIPLER.length; i++) {
            if (MULTIPLER[i] == multiplier) {
                return Math.pow(10, i - 12.0); 
            }
        }
        // common unit, no need to convert (except time)
        return 1.0;
    }
}
