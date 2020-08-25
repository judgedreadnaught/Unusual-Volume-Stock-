import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Stock {
	
	private Integer volData;
	private Document website;
	private Integer volume;
	private Integer dateData;
	private Double[] volumes;
	
	public Stock(String tick) {
		volData = 0;
		volume = 0;
		dateData = 0;
		volumes = null;
		try {
		website = Jsoup.connect("https://finance.yahoo.com/quote/" + tick +
				"/history?p=" + tick).get();
		} catch (Exception e) {
			System.err.close();
		}
	}
	
	public void initialVol() {
		try {
			volData = 65; // this is the data-reactid number that gives the volume of the stock, increases by 15 for each previous date's volume 
			dateData = 52;
			Elements vol = website.getElementsByAttributeValue("data-reactid", volData.toString());
			Elements date = website.getElementsByAttributeValue("data-reactid", dateData.toString());
			System.out.println(date.text() + "the current volume is: " + vol.text() + ".");
			volume = Integer.parseInt(vol.text().replaceAll(",", "")); // volume of the stock 
		} catch (Exception e) {
			System.err.close();
		}
	}
	
	// method that prints out the volumes in the last 5 days 

	public void lastVol() {
		int counter = 0;
		volumes = new Double[5];
		System.out.println("Volume in the past 5 days");
		while (counter < 5) { 
			volData += 15;
			Elements vol = website.getElementsByAttributeValue("data-reactid", volData.toString());
			System.out.println(vol.text());
			volumes[counter] = Double.parseDouble(vol.text().replaceAll(",", ""));
			counter++;
		}
	}
	
	public boolean calculator() {
		// finding the mean // 349.4
		//volumes = new Double[] {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
		double mean = 0;
		double sd = 0; // standard deviation
		for (double num : volumes) {
			mean += num;
		}
		mean = mean / volumes.length;
		for (double num : volumes) {
			sd += Math.pow(num - mean,  2);
		}
		sd = Math.sqrt(sd / volumes.length);
		System.out.printf("Mean is: %.3f\n",mean);
		System.out.printf("SD is: %.6f ",sd);
		
		double x = (10 * sd) + mean;
		if (x <= volume) {
			return true;
		} else {
			return false;
		}
	}
}
