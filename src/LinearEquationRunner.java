
import java.util.Scanner;
public class LinearEquationRunner {
    Scanner scan = new Scanner(System.in);

    public void start(){
        enterCoordinates();
        System.out.println();

    }

    public void enterCoordinates(){
        System.out.println("Enter your first coordinate: ");
        String coordinate1 = scan.nextLine();
        System.out.println("Enter your second coordinate: ");
        String coordinate2= scan.nextLine();
        new LinearEquation(coordinate1, coordinate2);
    }

}
