package Homeworks;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Day17_Homework {
    @Test
    void test01() throws IOException {

    /*
         Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
         ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")
     */
        //1)Oncelikle excel dosyasinin bulundugu path ayarlanir
        String path = "src/test/java/recources/mysmoketestdata.xlsx";
        //2) Belirtilen path te bulunan excel dosyasindan java classinda data akisi olusturur
        FileInputStream fis = new FileInputStream(path);
        //3) java ortaminda bir excel dosyasi acılır
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet1 =workbook.getSheet("customer_info");
         Row row = sheet1.getRow(0);

        //celli olustur
       Cell cell= row.createCell(2);
        //cell in value sunu "Name" olarak ayarla
        cell.setCellValue("Name");


        List<String> names= List.of("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam");
        for (int i = 1; i < names.size(); i++) {
            sheet1.getRow(i).createCell(2)
            .setCellValue(names.get(i-1));
        }
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fis.close();
        fos.close();


    }
}
