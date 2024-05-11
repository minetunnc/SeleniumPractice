package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes.Duration;

public class H_01Facebook {
    @Test
    void test01() {
        //  Yeni bir class olusturalim (Homework)
        //   ChromeDriver kullanarak, facebook sayfasina gidin
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(15));

        driver.get("//https:facebook.com");

        //   sayfa basliginin (title) "Facebook"icerdigini dogrulayin,
        String baslik = driver.getTitle();
        Assertions.assertTrue(baslik.contains("Facebook"));

        //   Sayfa URL'inin "facebook"kelimesi icerdigini dogrulayin,
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("facebook"));

        //   https://testcenter.techproeducation.com/ sayfasina gidin.
        driver.get("https://testcenter.techproeducation.com/");

        //   Sayfa basliginin "Automation Engineer"icerdigini dogrulayin.
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("Automation Engineer"));

        //   Sayfa URL'inin "techproeducation"kelimesi icerdigini dogrulayin,

        //   "Back to TechProEducation.com" butonunun görüntülendigini doğrulayin
        //   "Back to TechProEducation.com" butonunun üzerindeki yazinin TechProEducation icerdigini doğrulayin
        //   Tekrar "facebook"sayfasina donun
        //   Geri döndüğünüzü doğrulayin.
        //   Sayfayi kapatin
    }
}
