

import com.sun.tools.javac.util.ArrayUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by matt on 10/31/18.
 */
public class Problem149 {
    List<Line>     linesBetweenEveryPointList;
    List<Line>     uniqueLinesBetweenEveryPointList;

    public int maxPoints(Point[] points){
        int maxPointsCount = 0;
        linesBetweenEveryPointList = new ArrayList<>();
        uniqueLinesBetweenEveryPointList = new ArrayList<>();

        //An array to tally how many points are contained in each line
        int[] pointsCountArray;

        if(points.length == 1)
            return 1;

        long startTime = System.nanoTime();

        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++){//looping like this eliminates inverted pairs and self pairs

                Line lineToAdd = new Line(points[i],points[j]);
          //      boolean lineToAddIsUnique = true;//assume line is unique

//                for(Line uniqueLine : uniqueLinesBetweenEveryPointList){//don't care about uniqueness for now
//                    if(uniqueLine.equals(lineToAdd)){//line is not unique
//                        lineToAddIsUnique = false;
//                        break;
//                    }
//                }
//                if(lineToAddIsUnique)
                    linesBetweenEveryPointList.add(lineToAdd);//only add line if it's unique
            }

        }
        long stopTime = System.nanoTime();
        System.out.println("Making lines took " + ((stopTime-startTime) / 1000000) + " ms");


//        startTime = System.nanoTime();
//        //TODO remove lines that aren't unique
//        for(Line line : linesBetweenEveryPointList){
//            boolean lineIsUnique = true;
//            for(int i = 0; i < uniqueLinesBetweenEveryPointList.size(); i++){
//                if(line.equals(uniqueLinesBetweenEveryPointList.get(i))){
//                    lineIsUnique = false;
//                    break;
//                }
//            }
//            if(lineIsUnique){
//                uniqueLinesBetweenEveryPointList.add(line);
//            }
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Making unique lines took " + ((stopTime-startTime) / 1000000) + " ms");

        //create pointsCountArray after we know it's size
        pointsCountArray = new int[    linesBetweenEveryPointList.size()];

        startTime = System.nanoTime();

        for(Point point : points){
            for(int i = 0; i <     linesBetweenEveryPointList.size(); i++) {
                Line uniqueLine =     linesBetweenEveryPointList.get(i);
                if(uniqueLine.containsPoint(point)){
                    pointsCountArray[i]++;//increment point count for this line if the point is contained in the line
                }
            }
        }

        stopTime = System.nanoTime();
        System.out.println("Counting points on lines took " + ((stopTime-startTime) / 1000000) + " ms");

        startTime = System.nanoTime();

        for(int uniqueLinePointsCount : pointsCountArray){
            if(uniqueLinePointsCount > maxPointsCount) {
                maxPointsCount = uniqueLinePointsCount;
            }
        }
        stopTime = System.nanoTime();
        System.out.println("Finding max point count took " + ((stopTime-startTime) / 1000000) + " ms");
        return maxPointsCount;
    }
    public static void main(String[] args) {
        Line testLine = new Line(new Point(-6,0),new Point(0,3));
//        Line horizonatalLine1 = new Line(new Point(0,-1),new Point(4,-2));
//        Line horizonatalLine2 = new Line(new Point(0,1), new Point(0,-1));
//        System.out.println("line1 " + (horizonatalLine1.equals(horizonatalLine2) ? "equals " : "does not equal ") + "line2");

    }
    public static class Line{
        private Point firstPoint;//Point contained in this line
        private Point secondPoint;//Point contained in this line that != firstPoint
        private BigDecimal slope;//the slope of this line given by: slope = [(y-y1)/(x-x1)]; null if this Line is vertical
        private BigDecimal yIntercept;//the y intercept of this Line; null if line is Vertical

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
                BigDecimal mxPlusB = (slope.multiply(new BigDecimal(point.x))).add(yIntercept);
                return areCloseEnoughToBeEqual(mxPlusB, new BigDecimal(point.y));
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
            BigDecimal yIntercept =  new BigDecimal(firstPoint.y).subtract((slope.multiply(new BigDecimal(firstPoint.x))));
            //System.out.println("yIntercept:" + yIntercept);
            return yIntercept;
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
                BigDecimal yMinusY1 = new BigDecimal(firstPoint.y - secondPoint.y);// y - y1
                BigDecimal xMinusX1 = new BigDecimal(firstPoint.x - secondPoint.x);// x - x1

                //use 20 digits of precision
                BigDecimal slope =  yMinusY1.divide(xMinusX1, 20 ,BigDecimal.ROUND_HALF_UP);//(y - y1) / (x - x1) = m
                //System.out.println("Slope:" + slope);
                return slope;
            }
        }

        /**
         * Compares two BigDecimals and determine if they are close enough to be considered equal in the
         * terms of basic linear algebra using whole number Xs and Ys; i.e. the numbers are within 0.01 of each other.
         * @return if a is within 0.0001 of b inclusive.
         */
        private boolean areCloseEnoughToBeEqual(BigDecimal a,BigDecimal b){
            BigDecimal difference = a.subtract(b);
            difference = difference.abs();
            if(difference.compareTo(new BigDecimal(.00000000000000001)) <= 0) {
                return true;
            }
            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;
            //if one line is vertical or horizontal and the other is not
            if( this.isVertical() != line.isVertical() || this.isHorizontal() != line.isHorizontal()){
                return false;
            }
            //if both lines are vertical
            else if( this.isVertical() && line.isVertical()) {
                if( this.firstPoint.x == line.firstPoint.x)
                    return true;
                return false;//if both lines are vertical but not equal
            }

            //else if lines are horizontal
            else if ( this.isHorizontal() && line.isHorizontal()) {
                if(this.firstPoint.y == line.firstPoint.y)//two equal horizontal lines share Ys
                    return true;
                return false;//if both lines are horizontal but not equal
            }
            //else lines are equal if slopes are equal && y intercepts are equal
            else if (areCloseEnoughToBeEqual(this.slope,line.slope) && areCloseEnoughToBeEqual(this.yIntercept,line.yIntercept)) {
                //System.out.println(this.slope + "is close enough to " + line.slope + " to be equal");
                return true;
            }
            //if lines are not vertical, horizontal, or they don't share yIntcept and a slope
            return false;
        }
    }


}
