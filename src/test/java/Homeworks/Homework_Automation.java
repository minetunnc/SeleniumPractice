package Homeworks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.security.Key;
import java.util.Set;

public class Homework_Automation extends TestBase {


    @Test
    void test01() {
        //Sayfa başlığının "Batch 231 Selenium" olarak görüntülenip görüntülenmediğini test edin.
        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");
        Assertions.assertTrue(driver.getTitle().contains("Batch 231 Selenium"));
        //"Kullanıcı Adı" ve "Şifre" alanlarına faker ile değer girin ve formu gönderin. Başarılı mesajının ("Merhaba [Kullanıcı Adı]! İşlem başarılı.") olarak girilen bilgilerin görüntülenip görüntülenmediğini kontrol edin.
        Faker faker = new Faker();
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(faker.name().fullName(), Keys.TAB,
                faker.number().digit());
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        WebElement messageBox = driver.findElement(By.id("messageBox"));
        Assertions.assertTrue(messageBox.isDisplayed());

    }
        @Test
        void test02() {

            //"Kullanıcı Adı" ve "Şifre" alanlarını boş bırakın ve formu göndermeye çalışın. İslemin basarili bir sekilde gerceklesmedigini dogrulayin.
            driver.get("https://gleeful-lamington-a9d9de.netlify.app/");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            WebElement message = driver.findElement(By.id("messageBox"));
            System.out.println(message.getText());
        }


    @Test
    void test03() {
        //Cinsiyet radio buttonlarından birini (örneğin "Erkek") seçin ve Seçimin başarılı bir şekilde yapıldığını doğrulayın.
        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");
        WebElement male= driver.findElement(By.id("male"));
       male.click();
        Faker faker = new Faker();
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(faker.name().fullName(), Keys.TAB,
                faker.number().digit());
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assertions.assertTrue(male.isSelected());

        
    }

    @Test
    void test05() {
   // "Ülke" drop-down menüsünden bir ülkeyi (örneğin "Türkiye") seçin. Seçimin başarılı bir şekilde yapıldığını doğrulayın.
        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");
        WebElement country =  driver.findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByVisibleText("Türkiye");
      String options=  select.getFirstSelectedOption().getText();
      Assertions.assertEquals("Türkiye",options);
    }

    @Test
    void test06() {
    //"Dersler" bölümünden birden fazla ders seçin (örneğin "Java" ve "SQL"). Seçimlerin başarılı bir şekilde yapıldığını doğrulayın.
       WebElement courses = driver.findElement(By.id("course"));

    }
}
