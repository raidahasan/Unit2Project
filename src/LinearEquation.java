
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

    public String coordinateForX(double x){
        double y = slope() * x + yIntercept();
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo(){
        return "The two points are: (" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")" + "\n" +
               "The equation of the line between these points is: " + equation() + "\n" +
               "The slope of this line is: " + slope() + "\n" +
               "The y-intercept of this line is: " + yIntercept() + "\n" +
               "The distance between these points is " + distance();

    }

    public double roundedToHundredth(double toRound){
        toRound = (Math.round(toRound * 100)) / 100;
        return toRound;
    }
}
