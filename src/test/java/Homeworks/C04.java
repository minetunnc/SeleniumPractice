import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {

    //Amazon sayfasina gidiniz
    //Iphone aratınız
    //Cikan sonuc yazisini konsola yazdiriniz
    //Cikan sonuc sayisini konsola yazdiriniz
    //Cikan urunlerden ilk 5 tanesine tiklayip sayfa basliklarini yazdiriniz

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() throws InterruptedException {
        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //Iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" + Keys.ENTER);

        //Cikan sonuc yazisini konsola yazdiriniz
        System.out.println(driver.findElement(By.xpath("//*[@class='sg-col-inner'][1]")).getText());

        //Cikan sonuc sayisini konsola yazdiriniz
        System.out.println(driver.findElement(By.xpath("//*[@class='sg-col-inner'][1]")).getText().split(" ")[2]);

        //Cikan urunlerden ilk 5 tanesine tiklayip sayfa basliklarini yazdiriniz
        for (int i = 0; i < 5 ; i++) {
           List<WebElement> urunler = driver.findElements(By.xpath("//*[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
           urunler.get(i).click();
           Thread.sleep(2000);
           System.out.println((i+1) + ". urun basligi : " + driver.getTitle());
           driver.navigate().back();
           Thread.sleep(2000);
        }
        driver.quit();

    }
}
