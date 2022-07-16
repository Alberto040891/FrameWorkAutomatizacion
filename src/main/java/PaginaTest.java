import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PaginaTest {

    private WebDriver webdriver;
    private String tituloPagina;

    @BeforeTest
    public void navegador(){
        System.setProperty("webdriver.chrome.driver","./src/chromedriver/chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.get("https://www.google.com.mx");
    }
    @Test
    public void testNavegarGoogle(){
        //WebElement buscar = webdriver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));
        WebElement buscar = webdriver.findElement(By.name("q"));
        buscar.clear();
        buscar.sendKeys("gatos bgjfgclkbnxclvnbcxvnbcvnzmbkncdv");
        buscar.submit();
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       // tituloPagina = webdriver.getTitle();
        Assert.assertEquals("gatos bgjfgclkbnxclvnbcxvnbcvnzmbkncdv - Buscar con Google",webdriver.getTitle());

    }
    @AfterTest
    public void cerrarChrome(){
        //webdriver.close();
        webdriver.quit();
    }

}
