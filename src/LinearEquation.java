import java.util.Scanner;
public class LinearEquation{
    Scanner scan = new Scanner(System.in);
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public LinearEquation(){
        System.out.print("Enter coordinate 1: ");
        String coordinates = scan.nextLine();
        String strX = coordinates.substring(1, coordinates.indexOf(","));
        String strY = coordinates.substring((coordinates.indexOf(","))+2, (coordinates.length()-1));
        x1 = Integer.parseInt(strX);
        y1 = Integer.parseInt(strY);

        System.out.print("Enter coordinate 2: ");
        coordinates = scan.nextLine();
        strX = coordinates.substring(1, coordinates.indexOf(","));
        strY = coordinates.substring((coordinates.indexOf(","))+2, (coordinates.length()-1));
        int x2 = Integer.parseInt(strX);
        int y2 = Integer.parseInt(strY);
    }

    public double distance(){
        double distance;
        distance = Math.pow((y2-y1), 2);
        distance = distance + Math.pow((x2-x1), 2);
        distance = Math.sqrt(distance);
        distance = Math.round(distance * 100) / 100.0;
        return distance;
    }
}
