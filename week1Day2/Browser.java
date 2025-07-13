package week1Day2;

public class Browser {

	// To verify lanuchBrowser
	public void launchBrowser()
	{
		System.out.println("Browser launched Successfully");
		System.out.println();
	}
	// To verify loadUrl
	public void loadUrl()
	{
		System.out.println("Application url loaded Successfully");
	}
	
	public static void main(String[] args) {
		Browser browser = new Browser();
		browser.launchBrowser();
		browser.loadUrl();
	}
}
