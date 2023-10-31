
import java.util.Scanner;
public class LinearEquationLogic {
    LinearEquation coordinates;
    Scanner scan = new Scanner(System.in);

    public LinearEquationLogic(){
        Scanner scan = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Welcome to Linear Equation Calculator!");
        enterCoordinates();
        System.out.println(coordinates.lineInfo());
        enterX();
        System.out.println("Would you like to enter another pair of coordinates?? Enter y/n");
        String yesorno = scan.nextLine();
        while (yesorno.equals("y")){
            enterCoordinates();
            System.out.println(coordinates.lineInfo());
            enterX();
            System.out.println("Would you like to enter another pair of coordinates? Enter y/n");
            yesorno = scan.nextLine();
        }
    }

    public void enterCoordinates(){
        System.out.print("Enter your first coordinate: ");
        String coordinate1 = scan.nextLine();
        System.out.print("Enter your second coordinate: ");
        String coordinate2= scan.nextLine();
        coordinates = new LinearEquation(coordinate1, coordinate2);
    }

    public void enterX(){
        if(coordinates.slope() ==0){
            System.out.println(coordinates.coordinateForX(0));
        }else{
            System.out.print("Enter a value for x:");
            double x = scan.nextDouble();
            scan.nextLine();
            System.out.println("The point on the line is : " + coordinates.coordinateForX(x) + "\n");
        }
    }
}
