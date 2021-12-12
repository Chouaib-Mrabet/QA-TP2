import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// - Page Connexion : 
		// ---------------------------------------------------------------------- //
		
		driver.get("https://www.tunisianet.com.tn/connexion?back=my-account");
		
		String EMAIL = "******************";
		String PASSWORD = "***************";
		String PRODUCT_NAME ="PC portable MacBook M1 13.3";
		
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement button = driver.findElement(By.id("submit-login"));

		Thread.sleep(2500);
		
		email.sendKeys(EMAIL);
		password.sendKeys(PASSWORD);
		
		// this will redirect to "mon-compte" Page :
		button.click(); 
		
		Thread.sleep(2500);		

		// ---------------------------------------------------------------------- //		
		// - Page mon-compte : 
		
        WebElement inputSearch = driver.findElement(By.className("search_query"));
        inputSearch.sendKeys(PRODUCT_NAME);

		Thread.sleep(2500);
		
        WebElement buttonSearch = driver.findElement(By.cssSelector("#sp-btn-search > button"));

        // this will redirect to a page where you'll find list of products matching the product that you searched for :
        buttonSearch.click(); 
        
		Thread.sleep(2500);        

		// ---------------------------------------------------------------------- //
        
        List<WebElement> products = driver.findElements(By.className("product-title"));
        products.get(0).click(); // Redirect to a page where you'll find details about the product :

		// ---------------------------------------------------------------------- //
        
		Thread.sleep(2500);        
        
        WebElement buttonAddToCart = driver.findElement(By.className("add-to-cart"));
        buttonAddToCart.click(); // Adds Product to cart, and opens modal : 
        	
		// ---------------------------------------------------------------------- //
        
		Thread.sleep(2500);        
        
        WebElement buttonCommander = driver.findElement(By.cssSelector("a.btn-block"));
        buttonCommander.click(); // Redirect to your Cart :

		// ---------------------------------------------------------------------- //

        WebElement buttonCommander2 = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        buttonCommander2.click();
        
        Thread.sleep(2500);        

		// ---------------------------------------------------------------------- //
		// - Formulaire : 
		
		//WebElement societe = driver.findElement(By.name("company"));
		//societe.sendKeys("société");
		//WebElement tva = driver.findElement(By.name("vat_number"));
		//tva.sendKeys("1111");
		
		WebElement adresse = driver.findElement(By.name("address1"));
		adresse.sendKeys("adresse");
		Thread.sleep(2500);        

		//WebElement complementAdresse = driver.findElement(By.name("address2"));
		//complementAdresse.sendKeys("adresse");

		WebElement codePostal = driver.findElement(By.name("postcode"));
		codePostal.sendKeys("2222");
		Thread.sleep(2500);        

		WebElement ville = driver.findElement(By.name("city"));
		ville.sendKeys("tunis");
		Thread.sleep(2500);        

		WebElement telephone = driver.findElement(By.name("phone"));
		telephone.sendKeys("22017440");
		Thread.sleep(2500);        

		WebElement buttonContinuer = driver.findElement(By.name("confirm-addresses"));
		buttonContinuer.click();
		Thread.sleep(2500);        

		WebElement buttonContinuer2 = driver.findElement(By.name("confirmDeliveryOption"));
		buttonContinuer2.click();
		
		Thread.sleep(25000);        
	
		driver.quit();
	}
}







