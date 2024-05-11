package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes.Duration;

public class H_02 {
    /*homework
    https://www.google.com/ adresine gidin
    cookies uyarisi cikarsa kabul ederek kapatin
    Sayfa basliginin "Google" ifadesi icerdigini test edin
    Arama cubuguna "Selenium" yazip aratin
    Bulunan sonuc sayisini yazdirin
    sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
    Sayfayi kapatin*/

    WebDriver driver;

    @Test
    void name() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(15));

        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        String  title = driver.getTitle();


        //Sayfa basliginin "Google" ifadesi icerdigini test edin
        Assertions.assertTrue(title.contains("Google"));

        //Arama cubuguna "Selenium" yazip aratin
        driver.findElement(By.cssSelector(".gLFyf")).sendKeys("Selenium", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement ResultText =driver.findElement(By.id("result-stats"));
       String resultNumber = ResultText.getText().split(" ")[1];
        System.out.println("ResultNumber = " + resultNumber);

        //sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        String newResultNumber=resultNumber.replaceAll("[.]","");
        double resultNumberDouble = Double.parseDouble(newResultNumber);
        Assertions.assertTrue(resultNumberDouble>10000000);

        //Sayfayi kapatin
        driver.quit();








    }




}
