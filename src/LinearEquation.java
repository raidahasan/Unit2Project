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
        strY = coordinates.substring((coordinates.indexOf(","))+2, coordinates.indexOf(")"));
        x2 = Integer.parseInt(strX);
        y2 = Integer.parseInt(strY);
    }

    public double distance(){
        double distance;
        distance = Math.pow((y2-y1), 2);
        distance = distance + Math.pow((x2-x1), 2);
        distance = Math.sqrt(distance);
        distance = Math.round(distance * 100) / 100.0;
        return distance;
    }

    public double slope(){
        double slope =  (double) (y2 - y1) / (x2 - x1);
        slope = Math.round(slope * 100) / 100.0;
        return slope;
    }

    public double yIntercept(){
        double yIntercept = y2;
        yIntercept = yIntercept - slope()*x2;
        yIntercept = Math.round(yIntercept * 100) / 100.0;
        return yIntercept;
    }

    public String equation() {
        if(slope()==-1){
            return "y= " + "-x " + "+ " + yIntercept();
        }else if (slope()==1) {
            return "y= " + "x " + "+ " + yIntercept();
        }else if (slope() %1==0){
            return "y= " + (int)(slope()) + "x " + "+ " + yIntercept();
        }else{
            if(slope()==0 && yIntercept()==0){
                return "y= 0";
            }else if(yIntercept()==0) {
                return "y= " + slope() + "x";
            }else if(slope()==0){
                return "y= " + yIntercept();
            }else if(yIntercept()>0){
                if ((y2 - y1) > 0 && (x2 - x1) > 0) {
                    return "y= " + (y2 - y1) + "/" + (x2 - x1) + "x " + "+ " + yIntercept();
                } else if ((y2 - y1) < 0 && (x2 - x1) > 0) {
                    return "y= " + (y2 - y1) + "/" + (x2 - x1) + "x " + "+ " + yIntercept();
                } else if ((y2 - y1) < 0 && (x2 - x1) < 0) {
                    return "y= " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x " + "+ " + yIntercept();
                } else if ((y2 - y1) > 0 && (x2 - x1) < 0) {
                    return "y= -" + (y2 - y1) + "/" + Math.abs((x2 - x1)) + "x " + "+ " + yIntercept();
                }
            } else if (slope()<0) {
                if ((y2 - y1) > 0 && (x2 - x1) > 0) {
                    return "y= " + (y2 - y1) + "/" + (x2 - x1) + "x " + yIntercept();
                } else if ((y2 - y1) < 0 && (x2 - x1) > 0) {
                    return "y= " + (y2 - y1) + "/" + (x2 - x1) + "x " + yIntercept();
                } else if ((y2 - y1) < 0 && (x2 - x1) < 0) {
                    return "y= " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x " + yIntercept();
                } else if ((y2 - y1) > 0 && (x2 - x1) < 0) {
                    return "y= -" + (y2 - y1) + "/" + Math.abs((x2 - x1)) + "x " + yIntercept();
                }
            }
        }
        return "y= " + (y2 - y1) + "/" + (x2 - x1) + "x " + "+ " + yIntercept();

    }

}
