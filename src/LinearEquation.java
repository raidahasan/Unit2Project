
public class LinearEquation{

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(String coordinate1, String coordinate2){
        String strX = coordinate1.substring(1, coordinate1.indexOf(","));
        String strY = coordinate1.substring((coordinate1.indexOf(","))+2, (coordinate1.length()-1));
        x1 = Integer.parseInt(strX);
        y1 = Integer.parseInt(strY);

        strX = coordinate2.substring(1, coordinate2.indexOf(","));
        strY = coordinate2.substring((coordinate2.indexOf(","))+2, coordinate2.indexOf(")"));
        x2 = Integer.parseInt(strX);
        y2 = Integer.parseInt(strY);
    }

    public double distance(){
        double distance;
        distance = Math.pow((y2-y1), 2);
        distance = distance + Math.pow((x2-x1), 2);
        distance = Math.sqrt(distance);
        distance = roundedToHundredth(distance);
        return distance;
    }

    public double slope(){
        double slope =  (double) (y2 - y1) / (x2 - x1);
        slope = roundedToHundredth(slope);
        return slope;
    }

    public double yIntercept(){
        double yIntercept = y2;
        yIntercept = yIntercept - slope()*x2;
        yIntercept = roundedToHundredth(yIntercept);
        return yIntercept;
    }

    public String equation() {
        String equation = "";
        if (slope() == -1) {
            equation = "y = " + "-x " + yIntercept();
        } else if (slope() == 1) {
            equation = "y = " + "x ";
        } else if ((slope() % 1) == 0) {
            if (yIntercept() > 0) {
                equation = "y = " + (int) (slope()) + "x";
            } else if (yIntercept() < 0) {
                equation = "y = " + (int) (slope()) + "x ";
            }
        }else{
            if(slope()==0 && yIntercept()==0){
                equation = "y = 0";
            }else if(yIntercept()==0) {
                equation = "y = " + slope() + "x";
            }else if(slope()==0){
                equation = "y = ";
            }else if(yIntercept()>0){
                if ((y2 - y1) > 0 && (x2 - x1) > 0) {
                    equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
                } else if ((y2 - y1) < 0 && (x2 - x1) > 0) {
                    equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
                } else if ((y2 - y1) < 0 && (x2 - x1) < 0) {
                    equation = "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x ";
                } else if ((y2 - y1) > 0 && (x2 - x1) < 0) {
                    equation = "y = -" + (y2 - y1) + "/" + Math.abs((x2 - x1)) + "x ";
                }
            } else if (slope()<0) {
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
        }
        if(yIntercept()< 0){
            equation += yIntercept();
        } else if (yIntercept()>0) {
            equation += "+ " + yIntercept();
        }
        return equation;

    }

    public String coordinateForX(double x){
        double y = slope() * x + yIntercept();
        return "(" + x + ", " + y + ")";
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
