package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import utils.EnvironmentProperties;
import utils.GenericFunctions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    private WebDriver driver;
    private String productTitle;
    private SearchResultPage searchResultPage;
    private ProductDetailPage productDetailPage;
    private WishListPage wishListPage;

    private EnvironmentProperties envProp=new EnvironmentProperties();
    @Given("^Website is loaded successfully$")
    public void website_is_loaded_successfully(){
        try {
            this.driver = GenericFunctions.InitializeDriver();
            driver.get(envProp.getProperty("url"));
        }catch (Exception e){
            System.out.println("Unable to load website due to reason: - "+ e.getMessage());
        }
    }

    @When("^Click on item$")
    public void click_on_item() throws Exception {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.selectProduct(driver);
    }

    @Then("^Item Detail Page should be displayed$")
    public void item_Detail_Page_should_be_displayed() throws Exception {
        productDetailPage = new ProductDetailPage(driver);
        this.productTitle = productDetailPage.getProductTitle();
    }

    @Then("^Add to Cart$")
    public void add_to_Cart() throws Exception {
        productDetailPage.addToWishlist();
        productDetailPage.verifyWishListButton_clickedAction();
    }

    @Then("^Review Cart$")
    public void review_Cart() throws Exception {
        wishListPage = new WishListPage(driver);
        if (wishListPage.wishListLink!=null){
            wishListPage.wishListLink.click();
            wishListPage = new WishListPage(driver);
            assertEquals(wishListPage.wishListCheck.getText(),this.productTitle);
        }else{
            throw new Exception("Wish List link not found");
        }

        System.out.println("Test completed, quiting driver");
        driver.quit();
    }

}
