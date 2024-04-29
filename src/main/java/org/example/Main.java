package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();

        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        // Bu metot tarayıcıda belirtilen url e girmek için kullanılır.
        //Aynı zamanda tarayıcı fonksiyonunu temizler. Parametre olarak String alır, gitmek istenilen URL parametre olarak verilmelidir.

        WebElement[] webElements = new WebElement[3];

        webElements[0]= webDriver.findElement(By.id("user-name"));
        //findElement metodu bir web sayfasında belirli bir HTML öğesini bulmak için kullanılır.
        //Bu Metot farklı seçicileri içerisine parametre olarak olarak alabilir. Web element tipinde bir obje döndürür.

        webElements[0].sendKeys("standard_user");
        //sendKeys metodu parametre olarak String tipinde veri alır herhangi bir değer döndürmez.
        //İşlevi ise locate edilen Web Elementi verilen parametre ile doldurur.

        webElements[1] = webDriver.findElement(By.id("password"));
        webElements[1].sendKeys("secret_sauce");

        webElements[2] = webDriver.findElement(By.id("login-button"));
        webElements[2].click();
        //click metodu ilgili web elemente mouse click işlemi gerçekleştirir. Herhangi parametre almaz
        //Herhangi bir değer döndürmez.

        List<WebElement> elements = webDriver.findElements(By.cssSelector(".inventory_item_name"));
        //findElements metodu WebElement nesnesinden oluşan liste döndürür. Web elementleri bulmak için kullanılır.
        //By.cssSelector metodu ise CSS selector yapısına göre web elementleri bulur. String tipinde parametre alır.
        // Bu satırın yaptığı işlem ise class name'i "inventory_item_name" içeren Web Elementlerini bulup bir nesneye
        // atamaktır.
        String name;
        for (WebElement element:elements){
            name = element.getText();
            //getText metodu herhangi bir parametre almaz. İlgili Web elemtin un text ini döndürür.
            System.out.println(name);

        }


        String title = webDriver.getTitle();
        //getTitle metodu ilgili sayfanın title içeriğini String tipinde döndürür.
        //Herhangi bir parametre almaz.

        System.out.println("Sayfa Basligi= "+title);

        String currentUrl = webDriver.getCurrentUrl();
        //getCurrentUrl metodu ilgili sayfanın url içeriğini String tipinde döndürür.
        //Herhangi bir parametre almaz.

        System.out.println("Sayfa Url'i= "+currentUrl);

        webDriver.navigate().refresh();
        //Bulunulan sayfayı refresh eder herhangi bir parametre almaz ve değer döndürmez.
        webDriver.navigate().back();
        //Bulunulan sayfadan tarayıcı geçmişinde bir önceki sayfaya geçer
        // herhangi bir parametre almaz ve değer döndürmez.


        Thread.sleep(5000);
        webDriver.quit();


    }
}