package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Add_items_to_cart {
    WebDriver driver;

    @Given("user open the website")
    public void user_open_the_website() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eshop.vodafone.com.eg/shop/home");
        driver.manage().timeouts().implicitlyWait(11000, TimeUnit.SECONDS);

    }

    @When("user select items")
    public void user_select_items() throws InterruptedException {

        WebElement belkinBrand  = driver.findElement(By.id("shopByBrandCard"));
        belkinBrand.click();

         WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"home-0\"]/div/ul/li[1]/a/div/div[2]/a/img"));
         firstItem.click();

         WebElement addItem1ToCart = driver.findElement(By.xpath("/html/body/app-root/div/app-product-details/div/div[1]/div/div[3]/div/div/div[2]/button"));
         addItem1ToCart.click();
        Thread.sleep(5000);

        WebElement continueShoppingBtn = driver.findElement(By.xpath("/html/body/app-root/div/app-shoping-cart/div/div[1]/div[2]/div[2]/button"));
        continueShoppingBtn.click();
        Thread.sleep(5000);

       WebElement brand = driver.findElement(By.xpath("//*[@id=\"shopByBrandCard\"]/div/img"));
        brand.click();
        Thread.sleep(5000);


        WebElement secondItem = driver.findElement(By.xpath("//*[@id=\"home-0\"]/div/ul/li[2]/a/div/div[3]/a/span"));
        secondItem.click();

        WebElement addItem2ToCart = driver.findElement(By.xpath("/html/body/app-root/div/app-product-details/div/div[1]/div/div[3]/div/div/div[2]/button"));
        addItem2ToCart.click();

        WebElement searchBar = driver.findElement(By.id("search-q"));
        searchBar.sendKeys("iphone");
        Thread.sleep(5000);

        WebElement thirdItem = driver.findElement(By.xpath("//*[@id=\"home\"]/nav/div[1]/div[1]/ul/div[1]/div/a/li/div[2]/p"));
        thirdItem.click();
        Thread.sleep(4000);

        WebElement addItem3ToCart = driver.findElement(By.xpath("/html/body/app-root/div/app-product-details/div/div[1]/div/div[3]/div/div/div[2]/button"));
        addItem3ToCart.click();
    }

    @Then("items add to cart")
    public void items_add_to_cart() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/app-root/div/app-shoping-cart/div/div[1]/div[2]/div[1]/ul/li")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/app-root/div/app-shoping-cart/div/div[1]/div[2]/div[2]/ul/li")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/app-root/div/app-shoping-cart/div/div[1]/div[2]/div[3]/ul/li")).isDisplayed());




    }
}
