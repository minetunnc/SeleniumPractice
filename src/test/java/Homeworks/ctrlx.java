package Homeworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class ctrlx extends TestBase {
    // ÖDEV:


    @Test
    void test01() {
        //google sayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium", Keys.ENTER);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        Actions actions = new Actions(driver);
        actions.doubleClick(searchBox).keyDown(Keys.CONTROL).sendKeys("x").perform();

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        searchBox = driver.findElement(By.id("APjFqb"));
        actions.doubleClick(searchBox).keyDown(Keys.CONTROL).sendKeys("v", Keys.ENTER).perform();
    }

        @Test
        void test02() {


            //https://jqueryui.com/droppable/ adresine gidelim
            driver.get("https://jqueryui.com/droppable/");
            //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
            driver.switchTo().frame(0);
            WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(drag)//drag webelementine tıklar ve basılı tutar
                    .moveToElement(drop)//drag webelementini tutup drop webelement uzerine götürür.
                    .release()//basılı tutulan webelementi serbest bırakır
                    .perform();
            // Drag webelementinin drop webelementinin üzerine bırakıldığını test edin




        }
}
