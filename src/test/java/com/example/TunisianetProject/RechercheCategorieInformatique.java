package com.example.TunisianetProject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class RechercheCategorieInformatique {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		baseUrl = "https://www.tunisianet.com.tn/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
  }

  @Test
  public void testRechercheCategorieInformatique() throws Exception {
    driver.get("https://www.tunisianet.com.tn/connexion?back=identity");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.findElement(By.linkText("Ordinateur Portable")).click();
    driver.get("https://www.tunisianet.com.tn/702-ordinateur-portable");
    driver.findElement(By.xpath("//section[@id='wrapper']/div/div/nav/ol")).click();
    try {
      assertEquals("Ordinateur Portable", driver.findElement(By.xpath("//section[@id='wrapper']/div/div/nav/ol/li[3]/a/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.get("https://www.tunisianet.com.tn/700-accessoires-et-peripheriques");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.findElement(By.linkText("Ordinateur de Bureau")).click();
    driver.get("https://www.tunisianet.com.tn/701-ordinateur-de-bureau");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.findElement(By.linkText("Logiciels")).click();
    driver.get("https://www.tunisianet.com.tn/385-logiciels-informatique-tunisie");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.findElement(By.linkText("Serveur informatique")).click();
    driver.get("https://www.tunisianet.com.tn/375-serveur-informatique-tunisie");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.findElement(By.linkText("Onduleur")).click();
    driver.get("https://www.tunisianet.com.tn/380-onduleur");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.findElement(By.linkText("Meubles Pc")).click();
    driver.get("https://www.tunisianet.com.tn/733-meubles-pc");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li/div/span")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Composant  Informatique')]")).click();
    driver.get("https://www.tunisianet.com.tn/406-composant-informatique");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
