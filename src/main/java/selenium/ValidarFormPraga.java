package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidarFormPraga {
    public static void main(String[] args) {
        String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath + "/lib/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");

        driver.manage().window().maximize();

        WebElement pragaCodigo = driver.findElement(By.xpath("//*[@id=\"praga-codigo\"]"));
        if (pragaCodigo.isEnabled()) {
            if (pragaCodigo.getText().isEmpty()) {
                System.out.println("Input Codigo da praga esta vázio");
                pragaCodigo.sendKeys("CD001");
            }

            if (pragaCodigo.getAttribute("value").compareTo("CD001") == 0){
                System.out.println("Input Codigo de praga preenchido com CD001");
            }
        }

        WebElement pragaNome = driver.findElement(By.xpath("//*[@id=\"praga-nome\"]"));
        if (pragaNome.isEnabled()) {
            if (pragaNome.getText().isEmpty()) {
                System.out.println("Input Nome da praga esta vázio");
                pragaNome.sendKeys("COVID19");
            }

            if (pragaNome.getAttribute("value").compareTo("COVID19") == 0){
                System.out.println("Input Nome de praga preenchido com COVID19");
            }
        }

        WebElement doencasTransmitidasA = driver.findElement(By.xpath("//*[@id=\"Doença A\"]"));
        if (doencasTransmitidasA.isEnabled()) {
            if (!doencasTransmitidasA.isSelected()) {
                System.out.println("Checkbox Doença A está desabilitada!");
                doencasTransmitidasA.click();
            }
            if (doencasTransmitidasA.isSelected()) {
                System.out.println("Checkbox Doença A está habilitada!");
            }
        }

        WebElement doencasTransmitidasB = driver.findElement(By.xpath("//*[@id=\"Doença B\"]"));
        if (doencasTransmitidasB.isEnabled()) {
            if (!doencasTransmitidasB.isSelected()) {
                System.out.println("Checkbox Doença B está desabilitada!");
                doencasTransmitidasB.click();
            }
            if (doencasTransmitidasB.isSelected()) {
                System.out.println("Checkbox Doença B está habilitada!");
            }
        }

        WebElement doencasTransmitidasC = driver.findElement(By.xpath("//*[@id=\"Doença C\"]"));
        if (doencasTransmitidasC.isEnabled()) {
            if (!doencasTransmitidasC.isSelected()) {
                System.out.println("Checkbox Doença C está desabilitada!");
                doencasTransmitidasC.click();
            }
            if (doencasTransmitidasC.isSelected()) {
                System.out.println("Checkbox Doença C está habilitada!");
            }
        }

        WebElement pragaTempoDeVida = driver.findElement(By.xpath("//*[@id=\"praga-tempo-de_vida\"]"));
        if (pragaTempoDeVida.isEnabled()) {
            if (pragaTempoDeVida.getText().isEmpty()) {
                System.out.println("Input tempo de vida da praga esta vázio");
                pragaTempoDeVida.sendKeys("10");
            }

            if (pragaTempoDeVida.getAttribute("value").compareTo("10") == 0){
                System.out.println("Input tempo de vida da praga esta com 10");
            }
        }

        WebElement combateModoA = driver.findElement(By.xpath("//*[@id=\"Modo A\"]"));
        if (combateModoA.isEnabled()) {
            if (!combateModoA.isSelected()) {
                System.out.println("Checkbox Modo A está desabilitada!");
                combateModoA.click();
            }
            if (combateModoA.isSelected()) {
                System.out.println("Checkbox Modo A está habilitada!");
            }
        }

        WebElement combateModoB = driver.findElement(By.xpath("//*[@id=\"Modo B\"]"));
        if (combateModoB.isEnabled()) {
            if (!combateModoB.isSelected()) {
                System.out.println("Checkbox Modo B está desabilitada!");
                combateModoB.click();
            }
            if (combateModoB.isSelected()) {
                System.out.println("Checkbox Modo B está habilitada!");
            }
        }

        WebElement combateModoC = driver.findElement(By.xpath("//*[@id=\"Modo C\"]"));
        if (combateModoC.isEnabled()) {
            if (!combateModoC.isSelected()) {
                System.out.println("Checkbox Modo C está desabilitada!");
                combateModoC.click();
            }
            if (combateModoC.isSelected()) {
                System.out.println("Checkbox Modo C está habilitada!");
            }
        }
    }
}
