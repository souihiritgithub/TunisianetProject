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

public class AjouterUnProduitPanier {
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
  public void testAjouterUnProduitPanier() throws Exception {
    driver.get("https://www.tunisianet.com.tn/");
    driver.findElement(By.xpath("//div[@id='_desktop_top_menu']/div/div/ul/li[2]/div/span")).click();
    driver.findElement(By.linkText("Téléphone Portable")).click();
    driver.findElement(By.xpath("//div[@id='js-product-list']/div/div/article/div/div[4]/div[4]")).click();
    try {
      assertEquals("En stock", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Prix'])[3]/following::span[1]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//img[@alt='Téléphone Portable IPRO A3...']")).click();
    driver.findElement(By.xpath("//form[@id='add-to-cart-or-refresh']/div[2]/div/div[2]/button")).click();
    driver.findElement(By.id("myModalLabel")).click();
    try {
      assertEquals("Produit ajouté au panier avec succès", driver.findElement(By.id("myModalLabel")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='blockcart-modal']/div/div/div/div[2]/div/div/button")).click();
    driver.get("https://www.tunisianet.com.tn/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Connexion'])[1]/following::*[name()='svg'][1]")).click();
    driver.findElement(By.xpath("//section[@id='main']/div/div/div/div[2]/ul/li[2]/div/div[6]/div/div/a/i")).click();
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
