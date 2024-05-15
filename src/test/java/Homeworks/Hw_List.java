package Homeworks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.util.List;

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

    @Test
    void test03() {
//===========Homework 3==========================
   // https://the-internet.herokuapp.com/dropdown adresine gidin.
      driver.get("https://the-internet.herokuapp.com/dropdown");
 //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

//  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement elementtwo = driver.findElement(By.id("dropdown"));
        select = new Select(elementtwo);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

//  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement elementthree = driver.findElement(By.id("dropdown"));
        select = new Select(elementtwo);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("======================");

//  4.Tüm dropdown değerleri(value) yazdırın
List<WebElement> list = select.getOptions();
int i =1;
for (WebElement w : list ){
    System.out.println(i+"."+w.getText());
i++;
}
        //  5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
     //  False yazdırın.

    }
}


