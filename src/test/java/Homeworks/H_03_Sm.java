package Homeworks;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class H_03_Sm  extends TestBase {
//==========Homework 1===========================


    @Test
    void Homework01() {
    //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

    //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        waitForSecond(2);

    //    -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


       // -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        waitForSecond(2);
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.id("CancelTab")).click();

        //Çıkan alert'e iptal butonuna basınız.
        waitForSecond(2);
        driver.switchTo().alert().dismiss();

    //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        waitForSecond(2);
        driver.findElement(By.id("Textbox")).click();

    //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        waitForSecond(2);
    driver.switchTo().alert().sendKeys("Mine");
    waitForSecond(2);
    driver.switchTo().alert().accept();

    //-Çıkan mesajı konsola yazdırınız
     WebElement message = driver.findElement(By.id("demo1"));
        System.out.println("message.getText() = " + message.getText());

//-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assertions.assertEquals("Hello <Mine> How are you today",message);

    }

//==========Homework 2===========================

    @Test
    void Homework2() {

//https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

//1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
        WebElement ddm = driver.findElement(By.id("dropdown"));
        selectIndex(ddm, 1);

//2.SelectByValueTest methodunu oluşturun ve  value ile Seçenek 2'yi seçin
        selectValue(ddm, "2");

//3.SelectByVisibleTextTest methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
        selectVisible(ddm, "Option 1");
    }

    @Test
    void name() {
    //4.printAllTest methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda "Option 2" oldugunu test edin
    driver.get("https://the-internet.herokuapp.com/dropdown");
    WebElement options = driver.findElement(By.id("dropdown"));
    printAllTest(options);
    }

//5.yeni bir method olusturun ve default olarak secili olan secenegin "Please select an option" oldugunu test edin

    @Test
    void defaultText() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement options = driver.findElement(By.id("dropdown"));
        defaultOptionText(options);
        Assertions.assertEquals("Please select an option",defaultOptionText(options));
    }

//6.sizeTest adinda yeni bir method olusturun ve dropdown menudeki secenek sayisinin 3 oldugunu test edin,

    @Test
    void sizeTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement options = driver.findElement(By.id("dropdown"));
        sizeTest(options);
        Assertions.assertTrue(3==sizeTest(options));
    }



//==========Homework 3===========================
@Test
void homework3() {
//- ebay sayfasına gidiniz
driver.get("https://www.ebay.com");

// electronics bölümüne tıklayınız
    driver.findElement(By.linkText("Electronics")).click();

// Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım // Her sayfanın sayfa başlığını yazdıralım
   List<WebElement> img = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
    for (int i = 0; i <img.size() ; i++) {
        img = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        WebElement singlImage = img.get(i);
        singlImage.click();
        String pageTitle= driver.getTitle();
        System.out.println("pageTitle = " + pageTitle);
        driver.navigate().back();
    }
}
//==========Homework 4===========================
    @Test
    void homework4() {

//https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//DockerfileStatement.Add Element butonuna basin 100 kez basınız
        WebElement addButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        int counter=0;
        for (int i = 0; i <100 ; i++) {
            addButton.click();
        counter++;
        }

//Delete butonuna 90 kez basınız
List<WebElement> deleteButton = driver.findElements(By.xpath("//button[.='Delete']"));
        int counter1=0;
        for (int i = 0; i <90 ; i++) {
            deleteButton.get(i).click();
            counter1++;
        }
//Ve 90 kez basıldığını doğrulayınız
List<WebElement> deletesize = driver.findElements(By.xpath("//button[.='Delete']"));
        int size=deletesize.size();
        System.out.println("size = " + size);
        Assertions.assertEquals(counter-counter1,deletesize.size());

    }
}
