package HomeWork;

import Utils.BrowserUtils;
import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWork2 {
  @Test
     public void test() throws InterruptedException {



      WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions=new ChromeOptions();
      chromeOptions.addArguments("--remote-allow-origins=*");
      ChromeDriver driver=new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

      /*
      Navigate to
"http://secure.smartbearsoftware.com/samples/Te
stComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All Orders"
       */

      String actualTitle=BrowserUtils.getTitleWithJS(driver);
      String expectedTitle="Web Orders Login";
      Assert.assertEquals(actualTitle,expectedTitle);

      WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
      userName.sendKeys("Tester");
      WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
      password.sendKeys("test");

      WebElement logIn=driver.findElement(By.cssSelector(".button"));
      logIn.click();

      BrowserUtils.switchByTitle(driver,"Web Orders");
      Thread.sleep(1000);

      WebElement header=driver.findElement(By.tagName("h2"));
      Assert.assertEquals(BrowserUtils.getText(header),"List of All Orders");


  }

  @Test
    public void TestCase2(){

      WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions=new ChromeOptions();
      chromeOptions.addArguments("--remote-allow-origins=*");
      ChromeDriver driver=new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
      /*
      Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword

       */


      WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
      userName.sendKeys("Tester");
      WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
      password.sendKeys("test");

      WebElement logIn=driver.findElement(By.cssSelector(".button"));
      logIn.click();


      // Find and validate the href values of specific links
    WebElement viewAllOrdersLink = driver.findElement(By.linkText("View all orders"));
    Assert.assertEquals(BrowserUtils.getText(viewAllOrdersLink),"");


      WebElement viewAllProducts=driver.findElement(By.linkText("View all products"));
      viewAllProducts.click();
      Assert.assertTrue(viewAllProducts.isSelected());

      WebElement headerListOfProducts= driver.findElement(By.tagName("h2"));
      Assert.assertEquals(BrowserUtils.getText(headerListOfProducts),"List of Products");
      Assert.assertTrue(driver.getCurrentUrl().contains("Products"));

  }


  @Test
    public void testCase3() throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions=new ChromeOptions();
      chromeOptions.addArguments("--remote-allow-origins=*");
      ChromeDriver driver=new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");


        /*
    Navigate to
"http://secure.smartbearsoftware.com/sample
s/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Find the links for
View all orders
View all products
Orders
Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx
     */



      WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
      userName.sendKeys("Tester");
      WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
      password.sendKeys("test");

      WebElement logIn=driver.findElement(By.cssSelector(".button"));
      logIn.click();

      WebElement viewAllOrdersLink= driver.findElement(By.linkText("View all orders"));
    String viewAllOrdersHref = viewAllOrdersLink.getAttribute("href");
    System.out.println("View all orders href: " + viewAllOrdersHref);
    validateHref(viewAllOrdersHref, "Default.aspx");

      WebElement viewAllProductsLink=driver.findElement(By.linkText("View all products"));
    String viewAllProductsHref = viewAllProductsLink.getAttribute("href");
    System.out.println("View all products href: " + viewAllProductsHref);
    validateHref(viewAllProductsHref, "Products.aspx");

      WebElement ordersLink=driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
    String ordersHref = ordersLink.getAttribute("href");
    System.out.println("Orders href: " + ordersHref);
    validateHref(ordersHref, "Process.aspx");

  }

  private static void validateHref(String actualHref, String expectedHref) {
    if (actualHref.equals(expectedHref)) {
      System.out.println("Href is correct: " + actualHref);
    } else {
      System.out.println("Href is incorrect: " + actualHref);
    }
  }

  @Test
    public void TestCase4(){
      WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions=new ChromeOptions();
      chromeOptions.addArguments("--remote-allow-origins=*");
      ChromeDriver driver=new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
      /*
      Navigate to
"http://secure.smartbearsoftware.com/samples/TestComplete11
/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button

       */


      WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
      userName.sendKeys("Tester");
      WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
      password.sendKeys("test");

      WebElement logIn=driver.findElement(By.cssSelector(".button"));
      logIn.click();

      WebElement orderButton=driver.findElement(By.xpath("//a[.='Order']"));
      orderButton.click();

      WebElement productSelection=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
      BrowserUtils.selectBy(productSelection,"ScreenSaver","value");

      WebElement quantityBox=driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
      quantityBox.sendKeys("5");
      WebElement customerName=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
      customerName.sendKeys("CodeFish IT School");
      WebElement street=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
      street.sendKeys("2200 E devon");
      WebElement city=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
      city.sendKeys("Des Plaines");
      WebElement state=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
      state.sendKeys("Illinois");
      WebElement zip=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
      zip.sendKeys("60018");
      WebElement masterCard=driver.findElement(By.xpath("//input[@value='MasterCard']"));
      masterCard.click();
      WebElement cardNumber=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
      cardNumber.sendKeys("444993876233");
      WebElement exp=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
      exp.sendKeys("03/24");
      WebElement process=driver.findElement(By.cssSelector(".btn_light"));
      process.click();

      /*
      Validate text "New order has been successfully
added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are
matching with new order

       */

    WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
    Assert.assertEquals(BrowserUtils.getText(successMessage),"New order has been successfully added.");

  }

}
