package Task;

import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailRegistration {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("./src/test/resources/Gmail.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(4);
		String firstName = r.getCell(1).getStringCellValue();
		String lastName = r.getCell(2).getStringCellValue();
		String mail = r.getCell(3).getStringCellValue();
		String password = r.getCell(4).getStringCellValue();

		wb.close();
		fis.close();

		// Launch the window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		Actions actions = new Actions(driver);
		// Maximize the window
		driver.manage().window().maximize();

		// ImplicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to gmail
		driver.get("https://accounts.google.com/signin");

		// click on create account
		driver.findElement(By.xpath("//span[text()='Create account']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[text()='For my personal use']"));
		actions.moveToElement(ele).click().build().perform();

		// Identify Firstname text field
		driver.findElement(By.id("firstName")).sendKeys(firstName);

		// Identify Lastname text field
		driver.findElement(By.id("lastName")).sendKeys(lastName);

		// Identify next button
		WebElement button = driver.findElement(By.xpath("//span[text()='Next']"));
		button.click();
		// Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@aria-label='Day']")).sendKeys("19");
		driver.findElement(By.xpath("//input[@aria-label='Year']")).sendKeys("1999");

		// Click Month dropdown
		WebElement monthDropdown = driver.findElement(By.xpath("(//span[@class='VfPpkd-t08AT-Bz112c'])[1]"));
		actions.moveToElement(monthDropdown).click().build().perform();
		Thread.sleep(1000);

		// Click May
		WebElement may = driver.findElement(By.xpath("//span[text()='May']"));
		actions.moveToElement(may).click().build().perform();

		// gender dropdown
		WebElement gender = driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[2]"));
		gender.click();

		// click female
		WebElement f = driver.findElement(By.xpath("(//span[text()='Female'])[1]"));
		actions.moveToElement(f).click().build().perform();

		// click next
		driver.findElement(By.xpath("(//span[text()='Next'])[1]")).click();

		// click custom mail
		driver.findElement(By.id("selectionc22")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(mail);

		// click next button
		driver.findElement(By.xpath("//span[text()='Next']")).click();

		// Identify password text field
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@aria-label='Confirm']")).sendKeys(password);

		// click next button
		driver.findElement(By.xpath("//span[text()='Next']")).click();

		//click on skip button
		driver.findElement(By.xpath("//span[text()='Skip']")).click();
		
		//Click on next button
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
                // click on agree button
		driver.findElement(By.xpath("//span[text()='I agree']")).click();
	
		Thread.sleep(3000);
		

	}

}
