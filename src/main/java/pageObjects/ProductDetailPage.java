package pageObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {

    By productTitle=By.xpath("//div[contains(@class,'page-title')]/h1");                //the title of the selected item
    By wishListButton=By.xpath("//div/button[@class='btn-add-wishlist inactive']");     //Add to Wishlist button
    By wishListButton_Added=By.xpath("//div/button[@class='btn-add-wishlist added']");  //Added to Wishlist button

    private final WebDriver driver;                                                     //Web Driver

    /**
     * This method is used to initialise all the objects of
     * Product Details page.
     * @param driver This is a input parameter to get driver details.
     */
    public ProductDetailPage(WebDriver driver) {
        this.driver=driver;
    }

    /**
     * This method is used to get the name of the selected product.
     * @return String This returns the title of the product as a String value.
     */
    public String getProductTitle()
    {
        //getting the text of the selected paint item
        String title=driver.findElement(productTitle).getText();
        //printing the text of the selected paint item
        System.out.println(title);
        return title;
    }

    /**
     * This method is used to check for wish list button and click on it
     */
    public void addToWishlist() throws Exception {
        //clicking on add to wishList button
        WebElement wishListButton_inactive = GenericFunctions.getIfExists(driver,wishListButton);
        if (wishListButton_Added!=null){
            wishListButton_inactive.click();
        }else {
            throw new Exception("Adding to wish list was not successfull");
        }

    }

    /**
     * This method is used to check for wish list button after clicking
     * on it and verifying its post action
     * @return String This returns the title of the product as a String value.
     */
    public void verifyWishListButton_clickedAction() throws Exception {
        //clicking on add to wishList button
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(wishListButton_Added));
        WebElement wishListButton_Verify = GenericFunctions.getIfExists(driver,wishListButton_Added);
        if (wishListButton_Added!=null){
            wishListButton_Verify.click();
        }else {
            throw new Exception("Adding to wish list was not successful");
        }

    }

}
