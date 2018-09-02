package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class GenericFunctions {

    /**
     * This method is used to initialise Web Driver and launch Chrome browser
     * on the basis of which operating system is bring used for execution.
     * @return WebDriver This returns web driver.
     */
    public static WebDriver InitializeDriver() throws Exception
    {
        WebDriver driver;
        try
        {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("mac")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
            }else{
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
            }
            driver=new ChromeDriver();
        }
        catch (Exception e)
        {
            throw new Exception("Failed to initialise the Selenium Web driver due to following reason: " + e.getMessage());
        }

        //Driver will wait for maximum 10 seconds for each element to load.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        return driver;
    }

    /**
     * This method is used to check if the element passed
     * in parameter exists in the page or not.
     * @param driver This is first input parameter to get driver details.
     * @param by This is a second parameter to get element.
     * @return WebElement This returns the found element or null.
     */
    public static WebElement getIfExists(WebDriver driver, By by) throws Exception
    {
        try {
            if (driver.findElements(by).size() > 0) {
                return driver.findElement(by);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Exception in getIfExists method - "+e.getMessage());
            return null;
        }
    }

    /**
     * This method is a path helper for resource folder.
     * It sets the path string as per Operating System.
     * @return String This returns the string value of path.
     */
    public static String resourcePathHelper() throws Exception
    {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("mac")){
                return (System.getProperty("user.dir")+"/src/main/resources/");
            }else{
                return (System.getProperty("user.dir")+"\\src\\main\\resources\\");
            }
        }catch (Exception e){
            throw new Exception (e.getMessage());
        }
    }
}
