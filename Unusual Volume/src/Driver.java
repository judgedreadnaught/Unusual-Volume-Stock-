import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;
public class Driver {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please type in the name of the stock ticker: ");
		String ticker = keyboard.nextLine().toUpperCase();
		System.out.println("TICKER IS: " + ticker + "\n");
		Stock stock = new Stock(ticker);

		
		stock.initialVol();
		stock.lastVol();
		boolean x = stock.calculator();
		if (x) {
			System.out.println("\ntrue");
		} else {
			System.out.println("\nfalse");
		}
	
		
	}
	
	// method that gives the initial volume and date  ---- FINISHED 
	
	// method that prints out the volumes in the last 5 days ---- FINISHED 
	
	// method that calculates the mean and the standard deviation
	
	// method that checks if the current volume is 10 standard deviations from the mean!
}
