package ToolTip._ToolTip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintTooltipText {
	
	WebDriver driver;
	
	@BeforeClass
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
	}
	@Test
	public void checktooltipPrinted() {
		driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().contains("Tooltip "));
		System.out.println("Title is validated");
		
		//Mousehover on tooltip

		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println("number of frames : " +size);
		
		WebElement iframe=driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);
		WebElement tooltip=driver.findElement(By.xpath("//a[text()='Tooltips']"));
		String tooltiptitle=tooltip.getAttribute("title");
		System.out.println("tooltiptitle : " + tooltiptitle);
		Assert.assertTrue(tooltiptitle.contains("That's what this widget is"));
		System.out.println("tooltip tile is validated");
		
		
		
		//MouseHover on ThemeRoller
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		WebElement themeroller=driver.findElement(By.linkText("ThemeRoller"));
		String themeRollertitle=themeroller.getAttribute("title");
		System.out.println("themeRollertitle : " + themeRollertitle);
		Assert.assertTrue(themeRollertitle.contains("ThemeRoller: jQuery UI's theme builder application"));
		System.out.println("themeRollertitle tile is validated");
		
		//MouseHiver on Yourage
		Actions a= new Actions(driver);
		WebElement yourAge=driver.findElement(By.id("age"));
		a.moveToElement(yourAge).build().perform();
		String yourAgeText=driver.findElement(By.className("ui-tooltip-content")).getText();
		System.out.println(yourAgeText);
		Assert.assertTrue(yourAgeText.contains("We ask for your age only for statistical purposes."));
		System.out.println("yourAge tile is validated");
		
		
		
		
	}

}
