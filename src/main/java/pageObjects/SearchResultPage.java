package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SearchResultPage {
    public List<WebElement> links;          //List of all the displayed products link
    private final WebDriver driver;         //Web Driver

    /**
     * This method is used to initialise all the object of
     * Search Result page.
     */
    public SearchResultPage(WebDriver driver) throws Exception {
        this.driver = driver;
        try {
            links = driver.findElements(By.xpath("//a[contains(@class,'product-list__link')]"));
        }catch (Exception e){
            System.out.println("Unable to bound Search Result page elements due to reason : - "+e.getMessage());
        }
    }

    /**
     * This method is used to randomly select product from
     * search result.
     */
    public void selectProduct(WebDriver driver)
    {
        if (links.size()!=0){
            //Randomly selecting an item from the list
            Random gen = new Random();
            WebElement link = links.get(gen.nextInt(links.size()));
            link.click();
        }else{
            System.out.println("Unable to select product as list not found.");
        }

    }

}
