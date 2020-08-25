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
		
		initialVol(ticker);
		//Document website;
		/*try {
			website = Jsoup.connect("https://finance.yahoo.com/quote/" + ticker +
					"/history?p=" + ticker).get();
			Integer volData = 80; // this is the data-reactid number that gives the volume of the stock, increases by 15 for each previous date's volume 
			Integer dateData = 53;
			Elements vol = website.getElementsByAttributeValue("data-reactid", volData.toString());
			Elements date = website.getElementsByAttributeValue("data-reactid", dateData.toString());
			System.out.println(date.text() + ", the current volume is: " + vol.text() + ".");
		} catch (Exception e) {
			System.err.close();
		}*/
	}
	
	
	public static void initialVol(String tick) {
		try {
			Document website = Jsoup.connect("https://finance.yahoo.com/quote/" + tick +
					"/history?p=" + tick).get();
			Integer volData = 80; // this is the data-reactid number that gives the volume of the stock, increases by 15 for each previous date's volume 
			Integer dateData = 53;
			Elements vol = website.getElementsByAttributeValue("data-reactid", volData.toString());
			Elements date = website.getElementsByAttributeValue("data-reactid", dateData.toString());
			System.out.println(date.text() + ", the current volume is: " + vol.text() + ".");
		} catch (Exception e) {
			System.err.close();
		}
	}
	// method that gives the initial volume and date 
	
	// method that prints out the volumes in the last 10 days 
	
	// method that calculates the mean and the standard deviation
	
	// method that checks if the current volume is 10 standard deviations from the mean!
}
