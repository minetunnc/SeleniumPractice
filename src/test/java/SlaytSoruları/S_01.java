package SlaytSoruları;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class S_01 {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    void test01() {
        // 1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        // 2. arama kutusunu locate edelim
        WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
        // 3. “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);
        // 4. Bulunan sonuc sayisini yazdiralim
        WebElement result = driver.findElement(By.xpath("//h1"));
       String resultNumber = result.getText().split(" ")[3];
        System.out.println("resultNumber = " + resultNumber);
        // 5. Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//h2)[2]")).click();
        // 6. Sayfadaki tum basliklari yazdiralim
    }

// 1. http://zero.webappsecurity.com sayfasina gidin

// 2. Signin buttonuna tiklayin
// 3. Login alanine “username” yazdirin
// 4. Password alanine “password” yazdirin
// 5. Sign in buttonuna tiklayin
// 6. Pay Bills sayfasina gidin
// 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
// 8. tarih kismina “2020-09-10” yazdirin
// 9. Pay buttonuna tiklayin
// 10. “The payment was successfully submitted.” mesajinin ciktigini control edin

// 1-C01_TekrarTesti isimli bir class olusturun
// 2- https://www.google.com/ adresine gidin
// 3- cookies uyarisini kabul ederek kapatin
// 4. Sayfa basliginin “Google” ifadesi icerdigini test edin
// 5. Arama cubuguna “laptop” yazip aratin
// 6. Bulunan sonuc sayisini yazdirin
// 7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
// 8. Sayfayi kapatin

//1. “https://www.saucedemo.com” Adresine gidin
//2. Username kutusuna “standard_user” yazdirin
//3. Password kutusuna “secret_sauce” yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin

// 1. Yeni bir package olusturalim : day01
// 2. Yeni bir class olusturalim : C03_GetMethods
// 3. Amazon sayfasina gidelim. https://www.amazon.com/
// 4. Sayfa basligini(title) yazdirin
// 5. Sayfa basliginin “Amazon” icerdigini test edin
// 6. Sayfa adresini(url) yazdirin
// 7. Sayfa url’inin “amazon” icerdigini test edin.
// 8. Sayfa handle degerini yazdirin
// 9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
// 10. Sayfayi kapatin.

// 1. Yeni bir Class olusturalim.C05_NavigationMethods
// 2. Youtube ana sayfasina gidelim . https:// www.youtube.com/
// 3. Amazon soyfasina gidelim. https://www.amazon.com/
// 4. Tekrar YouTube’sayfasina donelim
// 5. Yeniden Amazon sayfasina gidelim
// 6. Sayfayi Refresh(yenile) yapalim
// 7. Sayfayi kapatalim / Tum sayfalari kapatalim

//1. Yeni bir Class olusturalim.C06_ManageWindow
//2. Amazon soyfasina gidelim. https://www.amazon.com/
//3. Sayfanin konumunu ve boyutlarini yazdirin
//4. Sayfayi simge durumuna getirin
//5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
//6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
//7. Sayfayi fullscreen yapin
//8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
//9. Sayfayi kapatin

//1. Yeni bir Class olusturalim.C07_ManageWindowSet
//2. Amazon soyfasina gidelim. https://www.amazon.com/
//3. Sayfanin konumunu ve boyutlarini yazdirin
//4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
//5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
//6. Sayfayi kapatin

// 1. Yeni bir class olusturalim (Homework)
// 2. ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
//    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
// 3. Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
// 4. https://www.walmart.com/ sayfasina gidin.
// 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
// 6. Tekrar “facebook” sayfasina donun
// 7. Sayfayi yenileyin
// 8. sayfayi tam sayfa (maximize) yapin
// 9. Browser’i kapatin

// 1. Yeni bir class olusturun (TekrarTesti)
// 2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
//    doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
// 3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
// 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
// 5. Youtube sayfasina geri donun
// 6. Sayfayi yenileyin
// 7. Amazon sayfasina donun
// 8. Sayfayi tamsayfa yapin
// 9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
//10. Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru  URL'yi yazdırın
//11. Sayfayi kapatin
}
