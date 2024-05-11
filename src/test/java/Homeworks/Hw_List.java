package Homeworks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class Hw_List extends TestBase {
    @Test
    void hw01() {
//   ==========Homework 1===========================
//-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
driver.get("http://demo.automationtesting.in/Alerts.html");

//-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız

// üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
//OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
//'te iptal butonuna basınız
//-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
//t box'a 'isminizi' yazdırınız ve Tamam'a basınız
//ı konsola yazdırınız
//ın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
//
    }

    @Test
    void hw02() {
//===========Homework 2==========================
//- http://szimek.github.io/signature_pad/ sayfasına gidiniz
driver.get("http://szimek.github.io/signature_pad/");

//- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
WebElement paintBox = driver.findElement(By.id("canvas-wrapper"));
Actions actions = new Actions(driver);
        // İmza alanının ortasına taşı
        actions.moveToElement(paintBox).perform();

        // İmza alanında çizime başla
        actions.clickAndHold().perform();

        // İmza alanında hareket ederek çizimi yap
        actions.moveByOffset(50, 0) //  x ekseninde 50 birim sağa hareket et
                .moveByOffset(0, 50)  //  y ekseninde 50 birim aşağı hareket et
                .moveByOffset(-50, 0) // x ekseninde 50 birim sola hareket et
                .moveByOffset(0, -50) // y ekseninde 50 birim yukarı hareket et
                .perform();

        // İmza alanındaki çizimi bırak
        actions.release().perform();
        waitForSecond(2);
//- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[.='Clear']")).click();
//- Sayfayi kapatiniz
        driver.quit();
    }
}


