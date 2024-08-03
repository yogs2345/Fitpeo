package Fitpeo.Automation;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class FitpeoAssignment {
	static WebDriver driver = new ChromeDriver();

// launch the browser	
	public void homepage() {
		// Maximize the chrome browser
		driver.manage().window().maximize();
		driver.get("https://www.fitpeo.com/");

	}

	public void calculatorNavigation()

	{
		driver.navigate().to("https://fitpeo.com/revenue-calculator");
	}

	public void sliderSection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement slider = driver.findElement(
				By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-duk49p']"));
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", slider);
	}

	public void sliderAdjustment() {
		// Adjust the slider to set its value to 820
		Actions act = new Actions(driver);
		WebElement slider = driver.findElement(By.xpath(
				"//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']"));
		act.dragAndDropBy(slider, 100, 0).perform();

		// verify text field value should be updated to 820
		WebElement textbox = driver.findElement(By.xpath("//input[@id=':R57alklff9da:']"));

	}

	public void updateTheTextField() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-track css-10opxo5']"));
		
		// store the slider position value before entering the value to the text field.
		String sliderPositionBeforeEnteringTheTextValue = slider.getAttribute("style");
		
		// Click on the text field associated with the slider.
		// Enter the value 560 in the text field
		WebElement textbox = driver.findElement(By.xpath("//input[@id=':R57alklff9da:']"));
		textbox.click();
		textbox.sendKeys(Keys.CONTROL + "a");
		textbox.sendKeys(Keys.BACK_SPACE);
		textbox.sendKeys("560");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // store the slider position value after entering the value to the text field.
		String sliderPositionAfterEnteringTheTextValue = slider.getAttribute("style");
		
		// verify before and after slider popsition should not be same after entering the text value to the text field
		Assert.assertNotSame(sliderPositionBeforeEnteringTheTextValue, sliderPositionAfterEnteringTheTextValue);

	}

	public void validateSliderValue() {
		// verify the slider range 560
		WebElement sliderRange = driver.findElement(By.xpath(
				"//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']/input"));
		String expectedsliderRangeValue = "560";
		String actualsliderRangeValue = sliderRange.getAttribute("value");

	}

	public void selectCPTCodes()

	{

		Actions act = new Actions(driver);

		WebElement checkbox_CPT_99091 = driver
				.findElement(By.xpath("//p[text()='CPT-99091']/parent::div//input[@type='checkbox']"));
		act.scrollToElement(checkbox_CPT_99091).build().perform();
		checkbox_CPT_99091.click();

		WebElement checkbox_CPT_99453 = driver
				.findElement(By.xpath("//p[text()='CPT-99453']/parent::div//input[@type='checkbox']"));
		act.scrollToElement(checkbox_CPT_99453).build().perform();
		checkbox_CPT_99453.click();

		WebElement checkbox_CPT_99454 = driver
				.findElement(By.xpath("//p[text()='CPT-99454']/parent::div//input[@type='checkbox']"));
		act.scrollToElement(checkbox_CPT_99454).build().perform();
		checkbox_CPT_99454.click();

		WebElement checkbox_CPT_99474 = driver
				.findElement(By.xpath("//p[text()='CPT-99474']/parent::div//input[@type='checkbox']"));
		act.scrollToElement(checkbox_CPT_99474).build().perform();
		checkbox_CPT_99474.click();

	}

	public void validateTotalRecurringReimbursement() {
		WebElement totalRecurringReimbursement = driver
				.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[3]"));
		Assert.assertEquals("$75600", totalRecurringReimbursement.getText());
		System.out.println(totalRecurringReimbursement.getText());
	}

	public void verifyHeaderDisplayReimbursementValue() {

		WebElement textbox = driver.findElement(By.xpath("//input[@type='number']"));
        textbox.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		textbox.sendKeys(Keys.CONTROL + "a");
		textbox.sendKeys(Keys.BACK_SPACE);
		textbox.sendKeys("820");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement totalRecurringReimbursement = driver
				.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[3]"));
		Assert.assertEquals("$110700", totalRecurringReimbursement.getText());
		System.out.println(totalRecurringReimbursement.getText());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FitpeoAssignment obj = new FitpeoAssignment();
		obj.homepage();
		obj.calculatorNavigation();
		obj.sliderSection();

		obj.sliderAdjustment();
		obj.updateTheTextField();
		obj.validateSliderValue();

		obj.validateSliderValue();
		obj.selectCPTCodes();
		obj.validateTotalRecurringReimbursement();
		obj.verifyHeaderDisplayReimbursementValue();

		driver.quit();

	}

}
