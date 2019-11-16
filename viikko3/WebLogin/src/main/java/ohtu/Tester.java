package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester {

    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = new FirefoxDriver();
        final String URL = "http://localhost:4567";
        driver.get(URL);

        driver.get("http://localhost:4567");

        sleep(2);

        // testi: epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaarinmeni");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(2);
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        sleep(2);

        // testi: uuden käyttäjätunnuksen luominen ja kirjautuminen ulos sovelluksesta
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);

        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("kirjahylly");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("kirjahylly");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();
        sleep(1);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);
        
        
        // alkuperäinen testi
        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
