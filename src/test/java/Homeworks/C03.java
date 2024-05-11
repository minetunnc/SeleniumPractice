import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03 {

    /*
1-Web sayfasına gidin. https://www.amazon.com/
2-Search(ara) “city bike”
3-Cikan sonuc yazisini yazdirin
4-Cikan sonuc sayisini yazdirin
5-Ilk urunun locate ini alin
6-Ilk urunun gorunur olup olmadıgını true veya false seklinde yazdirin
7-Ilk urunun erisilebilir olup olmadigini true veya false seklinde yazdirin
8-Ilk urunun secilabilir olup olmadigini true veya false seklinde yazdirin
9-Ilk urune tiklayin
10-Sayfayı kapatın
*/
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() {

        //1-Web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2-Search(ara) “city bike”
        WebElement searhchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searhchBox.sendKeys("city bike" + Keys.ENTER);


        //3-Cikan sonuc yazisini yazdirin
        // List<WebElement> sonucYazisi = driver.findElements(By.className("sg-col-inner"));
        // System.out.println(sonucYazisi.get(0).getText());

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());//1-16 of 197 results for "city bike"

        //4-Cikan sonuc sayisini yazdirin
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc sayisi : " + sonucSayisi[2]);

        //5-Ilk urunun locate ini alin
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@class='s-image'][1]"));

        /*
        List<WebElement> urunler = driver.findElements(By.className("s-image"));
        WebElement ilkUrun = urunler.get(0);
         */

        //6-Ilk urunun gorunur olup olmadıgını true veya false seklinde yazdirin
        System.out.println("Ilk urun gorunur mu? : " +ilkUrun.isDisplayed());


        //7-Ilk urunun erisilebilir olup olmadigini true veya false seklinde yazdirin
        System.out.println("Ilk urun erisilebilir mi? : " +ilkUrun.isEnabled());

        //8-Ilk urunun secilabilir olup olmadigini true veya false seklinde yazdirin
        System.out.println("Ilk urun secilebilir mi? : " +ilkUrun.isSelected());

        //9-Ilk urune tiklayin
        ilkUrun.click();

        //10-Sayfayı kapatın
        driver.close();

    }
}
