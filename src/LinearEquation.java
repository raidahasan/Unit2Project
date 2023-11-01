
public class LinearEquation{

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private String equation = "";

    public LinearEquation(int x, int y, int xtwo, int ytwo){
       x1 = x;
       y1 = y;
       x2 = xtwo;
       y2 = ytwo;

    }

    public double distance(){
        double distance;
        distance = Math.pow((y2-y1), 2);
        distance = distance + Math.pow((x2-x1), 2);
        distance = Math.sqrt(distance);
        distance = roundedToHundredth(distance);
        return distance;
    }

    public double slope() {
        double slope = 0;
        if(y1==y2){
            slope=0;
        }else if(x2 ==x1){
            slope=0;
        }else{
            slope = (double) (y2 - y1) / (x2 - x1);
            slope = roundedToHundredth(slope);
        }
        return slope;
    }

    public double yIntercept(){
        double yIntercept = y2;
        if(x2==x1){
            yIntercept = 0;
        }else {
            yIntercept = yIntercept - slope() * x2;
            yIntercept = roundedToHundredth(yIntercept);
        }
        return yIntercept;
    }

    public String equation() {
        if (x1 == x2) {
            equation = "x= " + x1;
        } else if (slope() == -1) {
            equation = "y = -x " ;
        } else if (slope() == 1) {
            equation = "y = " + "x ";
        } else if (slope() == 0) {
            equation = "y = ";
        } else if ((slope() % 1) == 0) {
                equation = "y = " + (int) (slope()) + "x";
        } else if (slope() == 0 && yIntercept() == 0) {
            equation = "y = 0";

        /*} else if (yIntercept() > 0) {
            if ((y2 - y1) > 0 && (x2 - x1) > 0) {
                equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
            } else if ((y2 - y1) < 0 && (x2 - x1) > 0) {
                equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
            } else if ((y2 - y1) < 0 && (x2 - x1) < 0) {
                equation = "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x ";
            } else if ((y2 - y1) > 0 && (x2 - x1) < 0) {
                equation = "y = -" + (y2 - y1) + "/" + Math.abs((x2 - x1)) + "x ";
            }
        } else if (slope() < 1) {
            if ((y2 - y1) > 0 && (x2 - x1) > 0) {
                equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
            } else if ((y2 - y1) < 0 && (x2 - x1) > 0) {
                equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
            } else if ((y2 - y1) < 0 && (x2 - x1) < 0) {
                equation = "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x ";
            } else if ((y2 - y1) > 0 && (x2 - x1) < 0) {
                equation = "y = -" + (y2 - y1) + "/" + Math.abs((x2 - x1)) + "x ";
            }
            */

        }else{
            if ((y2 - y1) > 0 && (x2 - x1) > 0) {
                equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
            } else if ((y2 - y1) < 0 && (x2 - x1) > 0) {
                equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
            } else if ((y2 - y1) < 0 && (x2 - x1) < 0) {
                equation = "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x ";
            } else if ((y2 - y1) > 0 && (x2 - x1) < 0) {
                equation = "y = -" + (y2 - y1) + "/" + Math.abs((x2 - x1)) + "x ";
            }
        }

        if(y1==y2){
            equation = "y = " + y1;
        }else if(x1 == x2){

        }else if(yIntercept()< 0){
            equation += yIntercept();
        } else if (yIntercept()>0) {
            equation += "+ " + yIntercept();
        }
        return equation;

    }

    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
        if(y1==y2){
            return "These points are on a horizontal line: y = " + Integer.toString(y1);
        }else if(x1==x2){
            return "These points are on a vertical line: x = " + Integer.toString(x1);
        }else {
            return "(" + x + ", " + y + ")";
        }
    }

    public String lineInfo(){
        return "The two points are: (" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ") \n" +
               "The equation of the line between these points is: " + equation() + "\n" +
               "The slope of this line is: " + slope() + "\n" +
               "The y-intercept of this line is: " + yIntercept() + "\n" +
               "The distance between these points is " + distance() + "\n";

    }

    public double roundedToHundredth(double toRound){
        toRound = (double) (Math.round(toRound * 100)) / 100;
        return toRound;
    }
}
