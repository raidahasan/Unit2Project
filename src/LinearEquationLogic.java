
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

        String strX = coordinate1.substring(1, coordinate1.indexOf(","));
        String strY = coordinate1.substring((coordinate1.indexOf(","))+2, (coordinate1.length()-1));
        int x1 = Integer.parseInt(strX);
        int y1 = Integer.parseInt(strY);

        strX = coordinate2.substring(1, coordinate2.indexOf(","));
        strY = coordinate2.substring((coordinate2.indexOf(","))+2, coordinate2.indexOf(")"));
        int x2 = Integer.parseInt(strX);
        int y2 = Integer.parseInt(strY);

        coordinates = new LinearEquation(x1, y1, x2, y2);
    }

    public void enterX(){
        if(coordinates.slope() ==0){
            System.out.println(coordinates.coordinateForX(0));
        }else{
            System.out.print("Enter a value for x: ");
            double x = scan.nextDouble();
            scan.nextLine();
            System.out.println("The point on the line is : " + coordinates.coordinateForX(x) + "\n");
        }
    }
}
