package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class ValidacaoLink {
    public static void main(String[] args) throws InterruptedException {
        String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath + "/lib/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");

        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Goo")).click();
        String googleUrl = driver.getCurrentUrl();
        if (Objects.equals(googleUrl, "https://www.google.com.br/")) {
            System.out.println("Redirecionamento ao Google está correto!");
        }

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().back();
    }
}
