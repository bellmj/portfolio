package coffee;
import java.util.*;
/** This class will calculate the cost of an order from "Java Joe", it will also tell the number of boxes needed.
 * @author Matt Bell
 * @since Feb 2, 2014
 * @status
 */
public class JavaJoe {
	 private static final int LARGE_BOX_CAPICITY = 20;
	 private static final int MEDIUM_BOX_CAPICITY = 10;
	 private static final int SMALL_BOX_CAPICITY = 5;
	 private static final float PRICE_OF_BAG = 5.50f;
	 private static final float PRICE_OF_LARGE_BOX = 2.00f;
	 private static final float PRICE_OF_MEDIUM_BOX = 1.00f;
	 private static final float PRICE_OF_SMALL_BOX = .50f;
	/**This is the main method for this class.
	 * @param args an Array of Strings
	 */
	public static void main(String[] args) {
		int numberofBagsOrdered;
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Java Joe! \nThis Application will calculate the price of ordering from us. \nPlease note that this application will not submit an order. \nPlease enter the number"
				+ " of bags of cofee that you would like to order, and press enter.");

		numberofBagsOrdered = Integer.parseInt(scan.nextLine());
		scan.close();
		System.out.printf("%22s: %d	$%.2f%n%22s: %.0f%%	$%.2f%n%22s:%n", "Number of Bags Ordered", numberofBagsOrdered, getPriceofBags(numberofBagsOrdered), "Discount",100*getDiscount(numberofBagsOrdered),getAmountOfDiscount(numberofBagsOrdered),"Boxes Used");
		System.out.printf("%25d Large 	$%.2f%n",getNumberOfLargeBoxesNeeded(numberofBagsOrdered),getNumberOfLargeBoxesNeeded(numberofBagsOrdered)*PRICE_OF_LARGE_BOX);
		System.out.printf("%25d Medium 	$%.2f%n",getNumberOfMediumBoxesNeeded(numberofBagsOrdered),getNumberOfMediumBoxesNeeded(numberofBagsOrdered)*PRICE_OF_MEDIUM_BOX);
		System.out.printf("%25d Small 	$%.2f%n",getNumberOfSmallBoxesNeeded(numberofBagsOrdered),getNumberOfSmallBoxesNeeded(numberofBagsOrdered)*PRICE_OF_SMALL_BOX);

	}

	/**Will return the Java Joe Discount based on the number of bags of 2lb coffee ordered
	 * @param numberOfBags The number of bags ordered
	 * @return the discount
	 */
	private static double getDiscount(int numberOfBags){
		if(numberOfBags >= 300){
			return .30;
		}
		else if(numberOfBags >= 250){
			return .25;
		}
		else if(numberOfBags >= 200){
			return .20;
		}
		else if(numberOfBags >= 100){
			return .15;
		}
		else if(numberOfBags >= 50){
			return .1;
		}
		else if(numberOfBags >= 25){
			return .05;
		}
		return 0.0;
	}
	/**
	 * this method will return the $ amount of the discount offered for ordering a certain number of bags
	 * @param numberOfBags the number of bags to order
	 * @return the $ amount of the discount
	 */
	private static double getAmountOfDiscount(int numberOfBags){
		return getDiscount(numberOfBags) * getPriceofBags(numberOfBags);
	}
	/**
	 * calculates the price in $ of the bags alone without a discount
	 * @param numberOfBags the number of bags to order
	 * @return the price in $ of the bags alone without a discount
	 */
	private static double getPriceofBags(int numberOfBags){
		return numberOfBags * PRICE_OF_BAG ;
	}
	/**
	 * returns the number of large boxes needed to ship the order
	 * @param NumberOfBags the number of bags to order
	 * @return the number of large boxes needed to ship the order
	 */
	private static int getNumberOfLargeBoxesNeeded(int numberOfBags){
		return numberOfBags/ LARGE_BOX_CAPICITY;
	}
	/**
	 * returns the number of medium boxes needed to ship the order
	 * @param NumberOfBags the number of bags to order
	 * @return the number of medium boxes needed to ship the order
	 */
	private static int getNumberOfMediumBoxesNeeded(int numberOfBags){
		return (numberOfBags-(getNumberOfLargeBoxesNeeded(numberOfBags)*LARGE_BOX_CAPICITY))/ MEDIUM_BOX_CAPICITY ;
	}
	/**
	 * returns the number of medium boxes needed to ship the order
	 * @param numberOfBags the number of bags to order
	 * @return the number of medium boxes needed to ship the order
	 */
	private static int getNumberOfSmallBoxesNeeded(int numberOfBags){
		int numSml = numberOfBags-((getNumberOfLargeBoxesNeeded(numberOfBags)*LARGE_BOX_CAPICITY)+(getNumberOfMediumBoxesNeeded(numberOfBags)*MEDIUM_BOX_CAPICITY));
		return numSml;
	}


}
