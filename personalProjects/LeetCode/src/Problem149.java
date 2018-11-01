import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 10/31/18.
 */
public class Problem149 {
    List<Line> uniqureLinesBetweenEveryPointList;

    public int maxPoints(Point[] points){
        uniqureLinesBetweenEveryPointList = new ArrayList<>();
        for(Point p1: points){
            for(Point p2:points){

            }
        }
        return 0;
    }
    private boolean ListOfLinesContainsPoint(Point p){
        for (Line line: uniqureLinesBetweenEveryPointList) {
            if(line.containsPoint(p)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Line testLine = new Line(new Point(-6,0),new Point(0,3));
        System.out.println(testLine.containsPoint(new Point(12,9)));
    }
    private static class Line{
        Point firstPoint;//Point contained in this line
        Point secondPoint;//Point contained in this line that != firstPoint
        BigDecimal slope;//the slope of this line given by: slope = [(y-y1)/(x-x1)]; null if this Line is vertical
        BigDecimal yIntercept;//the y intercept of this Line; null if line is Vertical

        /**
         * Creates a Line based on two given points
         * these points must not be identical
         * @param a the first point to base this Line off of
         * @param b the second point to base this Line off of that does not have the same x and y values as Point a
         */
        Line(Point a, Point b){
            firstPoint = a;
            secondPoint = b;
            slope = getSlope();
            yIntercept = getYIntercept();
        }

        boolean containsPoint(Point point){
            if( !this.isVertical() && !this.isHorizontal() && slope != null && yIntercept != null) {
                BigDecimal mxPlusB = slope.multiply(new BigDecimal(point.x)).add(yIntercept);
                return areCloseEnoughToBeEqual(mxPlusB, new BigDecimal(point.y));
                //pointToCheck.y == this.m * pointToCheck.x + this.b
            } else if( this.isVertical()){
                return firstPoint.x == point.x;
            } else if( this.isHorizontal()){
                return firstPoint.y == point.y;
            }
            return false;
        }

        /**
         * determines if this Line is Vertical
         * @return if this Line is Vertical
         */
        private boolean isVertical(){
            return firstPoint.x == secondPoint.x;
        }

        /**
         * determines if this Line is Horizontal
         * @return if this Line is Horizontal
         */
        boolean isHorizontal(){
            return firstPoint.y == secondPoint.y;
        }

        /**
         * calculates the YIntercept of this Line using b = y - mx
         * @return the yIntercept of this Line, null if slope is undefined
         */
        private BigDecimal getYIntercept(){
            if(slope == null || this.isVertical()){// if slope is undefined so is y intercept
                return null;
            }
            return new BigDecimal(firstPoint.y).subtract(slope.multiply(new BigDecimal(firstPoint.x)));
        }

        /**
         * Calculates the slope of this Line
         *
         * @return the slope of this Line calculated by m = [(y - y1) / (x - x1)]; null if a.x - b.x == 0
         */
        private BigDecimal getSlope(){
            if(this.isVertical()){
                return null;
            } else {
                BigDecimal yMinusY1 = new BigDecimal(firstPoint.y).subtract(new BigDecimal(secondPoint.y));// y - y1
                BigDecimal xMinusX1 = new BigDecimal(firstPoint.x).subtract(new BigDecimal(secondPoint.x));// x - x1
                return yMinusY1.divide(xMinusX1);//(y - y1) / (x - x1) = m
            }
        }

        /**
         * Compares two BigDecimals and determine if they are close enough to be considered equal in the
         * terms of basic linear algebra using whole number Xs and Ys; i.e. the numbers are within 0.0001 of each other.
         * @return if a is within 0.0001 of b inclusive.
         */
        private boolean areCloseEnoughToBeEqual(BigDecimal a,BigDecimal b){
            BigDecimal difference = a.subtract(b);
            difference = difference.abs();
            if(difference.compareTo(new BigDecimal("0.0001")) <= 0) {
                return true;
            }
            return false;
        }
    }
}
