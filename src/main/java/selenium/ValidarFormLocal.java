package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ValidarFormLocal {
    public static void main(String[] args) {
        String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath + "/lib/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");

        driver.manage().window().maximize();

        WebElement localCep = driver.findElement(By.xpath("//*[@id=\"cep-local\"]"));
        if (localCep.isEnabled()) {
            if (localCep.getText().isEmpty()) {
                System.out.println("Input CEP Ponto Central esta vázio");
                localCep.sendKeys("13564-040");
            }

            if (localCep.getAttribute("value").compareTo("13564-040") == 0){
                System.out.println("Input CEP Ponto Central esta preenchido com 13564-040");
            }
        }

        WebElement localRaio = driver.findElement(By.xpath("//*[@id=\"raio\"]"));
        if (localRaio.isEnabled()) {
            if (localRaio.getText().isEmpty()) {
                System.out.println("Input Raio de local esta vázio");
                localRaio.sendKeys("500");
            }

            if (localRaio.getAttribute("value").compareTo("500") == 0){
                System.out.println("Input Raio de local esta preenchido com 500");
            }
        }

        WebElement dropDownPopulacao = driver.findElement(By.xpath("/html/body/form[2]/div[3]/select"));
        Select select = new Select(dropDownPopulacao);
        if (dropDownPopulacao.isEnabled()) {
            System.out.println("Dropdown de população esta habilitado");
            select.selectByValue("populacao7");
        }
        WebElement selected = select.getFirstSelectedOption();
        if (selected.getText().compareTo("500.000") == 0) {
            System.out.println("População selecionada foi de 500.000");
        }

        WebElement localCaracteristica = driver.findElement(By.xpath("//*[@id=\"caracteristicas\"]"));
        if (localCaracteristica.isEnabled()) {
            if (localCaracteristica.getText().isEmpty()) {
                System.out.println("Input Caracteristica de local esta vázio");
                localCaracteristica.sendKeys("Cidade Pequena");
            }

            if (localCaracteristica.getAttribute("value").compareTo("Cidade Pequena") == 0){
                System.out.println("Input Caracteristica de local esta preenchido com Cidade Pequena");
            }
        }

        WebElement localTelefone = driver.findElement(By.xpath("//*[@id=\"telefone\"]"));
        if (localTelefone.isEnabled()) {
            if (localTelefone.getText().isEmpty()) {
                System.out.println("Input Telefone de local esta vázio");
                localTelefone.sendKeys("1623673850");
            }

            if (localTelefone.getAttribute("value").compareTo("1623673850") == 0){
                System.out.println("Input Telefone de local esta preenchido com 1623673850");
            }
        }
    }
}
