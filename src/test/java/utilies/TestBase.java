package utilies;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public  abstract class  TestBase  {
     protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void waitForSecond(int second)  {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    public void selectVisible(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByValue(option);
    }


    public void printAllTest(WebElement options){
        Select select = new Select(options);
       List<WebElement> list = select.getOptions();
       for (WebElement w : list){
           System.out.println(w.getText());
       }
    }
public String defaultOptionText(WebElement options){
        Select select = new Select(options);

        return select.getFirstSelectedOption().getText();
}
public int   sizeTest(WebElement options ){

    Select select = new Select(options);
    List<WebElement> list = select.getOptions();
    return list.size();


}

}

