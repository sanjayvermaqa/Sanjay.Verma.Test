package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericFunctions;

public class WishListPage {
    private final WebDriver driver;

    public WebElement wishListLink;         //wishList link
    public WebElement wishListCheck;        //Item in wish list

    /**
     * This method is used to initialise all the object of
     * Wish List page.
     */
    public WishListPage(WebDriver driver) throws Exception {
        this.driver=driver;
        wishListLink = GenericFunctions.getIfExists(driver, By.xpath("//a[contains(@title, 'Wish List')]"));
        wishListCheck = GenericFunctions.getIfExists(driver,By.xpath("//a[contains(@class,'GAEvent display-block')]/strong"));
    }
}
