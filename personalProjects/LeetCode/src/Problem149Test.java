import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matt on 10/31/18.
 */
public class Problem149Test {
    Point[] maxThreePointArray;
    Point[] maxFourPointArray;
    Point[] maxLargePointArrayThatTimesOut;
    Point[] maxBrokenPointArray;
    Point[] maxArrayThatRequiresALotOfPrecision;
    Point[] maxSecondLargePointArrayThatTimesOut;
    Problem149 problem149obj;

    @Before
    public void setUp() throws Exception {
        problem149obj = new Problem149();
        maxThreePointArray = new Point[]{new Point(1,1), new Point(2,2), new Point(3,3)};
        maxFourPointArray = new Point[]{new Point(1,1), new Point(3,2), new Point(5,3), new Point(4,1), new Point(2,3),
            new Point(1,4)};
        maxLargePointArrayThatTimesOut = new Point[]{new Point(40,-23) , new Point(9,138) , new Point(429,115) ,
                new Point(50,-17) , new Point(-3,80) , new Point(-10,33) , new Point(5,-21) , new Point(-3,80) ,
                new Point(-6,-65) , new Point(-18,26) , new Point(-6,-65) , new Point(5,72) , new Point(0,77) ,
                new Point(-9,86) , new Point(10,-2) , new Point(-8,85) , new Point(21,130) , new Point(18,-6) ,
                new Point(-18,26) , new Point(-1,-15) , new Point(10,-2) , new Point(8,69) , new Point(-4,63) ,
                new Point(0,3) , new Point(-4,40) , new Point(-7,84) , new Point(-8,7) , new Point(30,154) ,
                new Point(16,-5) , new Point(6,90) , new Point(18,-6) , new Point(5,77) , new Point(-4,77) ,
                new Point(7,-13) , new Point(-1,-45) , new Point(16,-5) , new Point(-9,86) , new Point(-16,11) ,
                new Point(-7,84) , new Point(1,76) , new Point(3,77) , new Point(10,67) , new Point(1,-37) ,
                new Point(-10,-81) , new Point(4,-11) , new Point(-20,13) , new Point(-10,77) , new Point(6,-17) ,
                new Point(-27,2) , new Point(-10,-81) , new Point(10,-1) , new Point(-9,1) , new Point(-8,43) ,
                new Point(2,2) , new Point(2,-21) , new Point(3,82) , new Point(8,-1) , new Point(10,-1) ,
                new Point(-9,1) , new Point(-12,42) , new Point(16,-5) , new Point(-5,-61) , new Point(20,-7) ,
                new Point(9,-35) , new Point(10,6) , new Point(12,106) , new Point(5,-21) , new Point(-5,82) ,
                new Point(6,71) , new Point(-15,34) , new Point(-10,87) , new Point(-14,-12) , new Point(12,106) ,
                new Point(-5,82) , new Point(-46,-45) , new Point(-4,63) , new Point(16,-5) , new Point(4,1) ,
                new Point(-3,-53) , new Point(0,-17) , new Point(9,98) , new Point(-18,26) , new Point(-9,86) ,
                new Point(2,77) , new Point(-2,-49) , new Point(1,76) , new Point(-3,-38) , new Point(-8,7) ,
                new Point(-17,-37) , new Point(5,72) , new Point(10,-37) , new Point(-4,-57) , new Point(-3,-53) ,
                new Point(3,74) , new Point(-3,-11) , new Point(-8,7) , new Point(1,88) , new Point(-12,42) ,
                new Point(1,-37) , new Point(2,77) , new Point(-6,77) , new Point(5,72) , new Point(-4,-57) ,
                new Point(-18,-33) , new Point(-12,42) , new Point(-9,86) , new Point(2,77) , new Point(-8,77) ,
                new Point(-3,77) , new Point(9,-42) , new Point(16,41) , new Point(-29,-37) , new Point(0,-41) ,
                new Point(-21,18) , new Point(-27,-34) , new Point(0,77) , new Point(3,74) , new Point(-7,-69) ,
                new Point(-21,18) , new Point(27,146) , new Point(-20,13) , new Point(21,130) , new Point(-6,-65) ,
                new Point(14,-4) , new Point(0,3) , new Point(9,-5) , new Point(6,-29) , new Point(-2,73) ,
                new Point(-1,-15) , new Point(1,76) , new Point(-4,77) , new Point(6,-29)};
        maxSecondLargePointArrayThatTimesOut = new Point[]{new Point(560, 248), new Point(0, 16), new Point(30, 250),
                new Point(950, 187), new Point(630, 277), new Point(950, 187), new Point(-212, -268),
                new Point(-287, -222), new Point(53, 37), new Point(-280, -100), new Point(-1, -14), new Point(-5, 4),
                new Point(-35, -387), new Point(-95, 11), new Point(-70, -13), new Point(-700, -274),
                new Point(-95, 11), new Point(-2, -33), new Point(3, 62), new Point(-4, -47), new Point(106, 98),
                new Point(-7, -65), new Point(-8, -71), new Point(-8, -147), new Point(5, 5), new Point(-5, -90),
                new Point(-420, -158), new Point(-420, -158), new Point(-350, -129), new Point(-475, -53),
                new Point(-4, -47), new Point(-380, -37), new Point(0, -24), new Point(35, 299), new Point(-8, -71),
                new Point(-2, -6), new Point(8, 25), new Point(6, 13), new Point(-106, -146), new Point(53, 37),
                new Point(-7, -128), new Point(-5, -1), new Point(-318, -390), new Point(-15, -191),
                new Point(-665, -85), new Point(318, 342), new Point(7, 138), new Point(-570, -69), new Point(-9, -4),
                new Point(0, -9), new Point(1, -7), new Point(-51, 23), new Point(4, 1), new Point(-7, 5),
                new Point(-280, -100), new Point(700, 306), new Point(0, -23), new Point(-7, -4), new Point(-246, -184),
                new Point(350, 161), new Point(-424, -512), new Point(35, 299), new Point(0, -24), new Point(-140, -42),
                new Point(-760, -101), new Point(-9, -9), new Point(140, 74), new Point(-285, -21),
                new Point(-350, -129), new Point(-6, 9), new Point(-630, -245), new Point(700, 306), new Point(1, -17),
                new Point(0, 16), new Point(-70, -13), new Point(1, 24), new Point(-328, -260), new Point(-34, 26),
                new Point(7, -5), new Point(-371, -451), new Point(-570, -69), new Point(0, 27), new Point(-7, -65),
                new Point(-9, -166), new Point(-475, -53), new Point(-68, 20), new Point(210, 103), new Point(700, 306),
                new Point(7, -6), new Point(-3, -52), new Point(-106, -146), new Point(560, 248), new Point(10, 6),
                new Point(6, 119), new Point(0, 2), new Point(-41, 6), new Point(7, 19), new Point(30, 250)};

        maxBrokenPointArray = new Point[]{new Point(-435,-347), new Point(-435,-347), new Point(609,613),
                new Point(-348,-267), new Point(-174,-107), new Point(87,133), new Point(-87,-27), new Point(-609,-507),
                new Point(435,453), new Point(-870,-747), new Point(-783,-667), new Point(0,53), new Point(-174,-107),
                new Point(783,773), new Point(-261,-187), new Point(-609,-507), new Point(-261,-187), new Point(-87,-27),
                new Point(87,133), new Point(783,773), new Point(-783,-667), new Point(-609,-507), new Point(-435,-347),
                new Point(783,773), new Point(-870,-747), new Point(87,133), new Point(87,133), new Point(870,853), new
                Point(696,693), new Point(0,53), new Point(174,213), new Point(-783,-667), new Point(-609,-507),
                new Point(261,293), new Point(435,453), new Point(261,293), new Point(435,453)};
        maxArrayThatRequiresALotOfPrecision = new Point[]{new Point(0, 0), new Point(94911151, 94911150),
                new Point(94911152, 94911151)};


    }

    @Test
    public void maxPoints() throws Exception {
        assertEquals(3,problem149obj.maxPoints(maxThreePointArray));
        assertEquals(4,problem149obj.maxPoints(maxFourPointArray));
    }
    @Test
    public void maxLargePointArrayThatTimesOut(){
        assertEquals(25,problem149obj.maxPoints(maxLargePointArrayThatTimesOut));
    }
    @Test
    public void maxSecondLargePointArrayThatTimesOut(){
        assertEquals(22,problem149obj.maxPoints(maxSecondLargePointArrayThatTimesOut));
    }
    @Test
    public void maxPointsBrokenArray(){
        assertEquals(37, problem149obj.maxPoints(maxBrokenPointArray));
    }
    @Test
    public void maxPointsWithHighPrecision() {
        Problem149.Line TestLine1 = new Problem149.Line(maxArrayThatRequiresALotOfPrecision[0],maxArrayThatRequiresALotOfPrecision[1]);
        assertEquals(2,problem149obj.maxPoints(maxArrayThatRequiresALotOfPrecision));

    }



}