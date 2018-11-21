package com.company;

import com.sun.tools.javac.util.ArrayUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by matt on 10/31/18.
 */
public class Problem149 {
    List<Line> uniqueLinesBetweenEveryPointList;

    public int maxPoints(Point[] points){
        int maxPointsCount = 0;
        uniqueLinesBetweenEveryPointList = new ArrayList<>();

        //An array to tally how many points are contained in each line
        int[] pointsCountArray;

        if(points.length == 1)
            return 1;

        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++){//looping like this eliminates inverted pairs and self pairs

                Line lineToAdd = new Line(points[i],points[j]);
                boolean lineToAddIsUnique = true;//assume line is unique

                for(Line uniqueLine : uniqueLinesBetweenEveryPointList){
                    if(uniqueLine.equals(lineToAdd)){//line is not unique
                        lineToAddIsUnique = false;
                    }
                }
                if(lineToAddIsUnique)
                    uniqueLinesBetweenEveryPointList.add(lineToAdd);//only add line if it's unique
            }
        }

        //create pointsCountArray after we know it's size
        pointsCountArray = new int[uniqueLinesBetweenEveryPointList.size()];

        for(Point point : points){
            for(int i = 0; i < uniqueLinesBetweenEveryPointList.size(); i++) {
                Line uniqueLine = uniqueLinesBetweenEveryPointList.get(i);
                if(uniqueLine.containsPoint(point)){
                    pointsCountArray[i]++;//increment point count for this line if the point is contained in the line
                }
            }
        }
        for(int uniqueLinePointsCount : pointsCountArray){
            if(uniqueLinePointsCount > maxPointsCount) {
                maxPointsCount = uniqueLinePointsCount;
            }
        }
        return maxPointsCount;
    }
    public static void main(String[] args) {
        Line testLine = new Line(new Point(-6,0),new Point(0,3));
//        Line horizonatalLine1 = new Line(new Point(0,-1),new Point(4,-2));
//        Line horizonatalLine2 = new Line(new Point(0,1), new Point(0,-1));
//        System.out.println("line1 " + (horizonatalLine1.equals(horizonatalLine2) ? "equals " : "does not equal ") + "line2");

    }
    private static class Line{
        private Point firstPoint;//Point contained in this line
        private Point secondPoint;//Point contained in this line that != firstPoint
        private Double slope;//the slope of this line given by: slope = [(y-y1)/(x-x1)]; null if this Line is vertical
        private Double yIntercept;//the y intercept of this Line; null if line is Vertical

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
                Double mxPlusB = (slope * point.x) + yIntercept;
                return areCloseEnoughToBeEqual(mxPlusB, (double)point.y);
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
        private Double getYIntercept(){
            if(slope == null || this.isVertical()){// if slope is undefined so is y intercept
                return null;
            }
            return firstPoint.y-(slope * firstPoint.x);
        }

        /**
         * Calculates the slope of this Line
         *
         * @return the slope of this Line calculated by m = [(y - y1) / (x - x1)]; null if a.x - b.x == 0
         */
        private Double getSlope(){
            if(this.isVertical()){
                return null;
            } else {
                double yMinusY1 = firstPoint.y - secondPoint.y;// y - y1
                double xMinusX1 = firstPoint.x - secondPoint.x;// x - x1
                return yMinusY1 / xMinusX1;//(y - y1) / (x - x1) = m
            }
        }

        /**
         * Compares two BigDecimals and determine if they are close enough to be considered equal in the
         * terms of basic linear algebra using whole number Xs and Ys; i.e. the numbers are within 0.01 of each other.
         * @return if a is within 0.0001 of b inclusive.
         */
        private boolean areCloseEnoughToBeEqual(Double a,Double b){
            double difference = a - b;
            difference = Math.abs(difference);
            if(difference <= .0001) {
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
                return true;
            }
            //if lines are not vertical, horizontal, or they don't share yIntcept and a slope
            return false;
        }
    }
}
