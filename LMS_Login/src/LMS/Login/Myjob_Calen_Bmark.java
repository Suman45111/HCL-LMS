package LMS.Login;

import java.io.File;
import java.util.concurrent.TimeUnit;

 

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

 

public class Myjob_Calen_Bmark {
    WebDriver driver;
    String baseUrl = "https://hcltech-lms.career-shaper.com/login/index.php";
    WebElement Username;
    WebElement password;
    WebElement button;
    WebElement login;
    WebElement Batchname;
    WebElement Next;
    WebElement Myjob;
    WebElement techni;
    WebElement bookmark1;
    WebElement bookmark2;
    WebElement course;
    WebElement specifycourse;
    WebElement countinue;
    WebElement slide;
    WebElement iframe;
    WebElement calenderbtn;
    WebElement techcalender;
    WebElement calender;
    TakesScreenshot ts;
    File source;
    File trg;
    WebElement bookmarkbtn;
    String actual1;
    String actual2;
    String expected1;
    String expected2;
    WebElement bookmarksverify;
    WebElement home;
    WebElement Logout;
    JavascriptExecutor js;

    @BeforeMethod
    
    public void lms() {

    	System.setProperty("webdriver.edge.driver","C:/Kavya_Selenium/msedgedriver.exe");
	    driver= new EdgeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Login() throws InterruptedException, Exception {
        Username = driver.findElement(By.xpath("//input[contains(@type,'text')]"));
        Username.sendKeys("HCLTB0397813");
        Thread.sleep(2000);
        password = driver.findElement(By.xpath("//input[contains(@type,'password')]"));
        password.sendKeys("P@ssw0rd");
        Thread.sleep(2000);
        button = driver.findElement(
                By.xpath("//label[normalize-space(text())='I agree with the']//following::span[@class='checkmark']"));
        button.click();
        Thread.sleep(2000);
        login = driver.findElement(By.xpath("//button[text()='Login']"));
        login.click();
        Thread.sleep(2000);
        Batchname = driver.findElement(By.xpath("//a[text()='TECHBEE_AMJ23_101_3']"));
        Batchname.click();
        Thread.sleep(2000);
        Next = driver.findElement(By.xpath("//a[normalize-space(text())='Next']"));
        Next.click();
        Thread.sleep(2000);

        Myjob = driver.findElement(By.xpath("//a[@class='menu-expander']"));
        Myjob.click();

        techni = driver.findElement(By.xpath("(//span[@class='vector-icon ic-star-solid'])[1]"));
        techni.click();

        expected1 = driver.findElement(By.xpath("//h6[text()='Software Engineering']")).getText();
        expected2 = driver.findElement(By.xpath("//h6[text()='Core Java+JDBC']")).getText();

        bookmark1 = driver.findElement(By.xpath("(//i[@class='fa fa-star-o mt-2 mark-as-favourite'])[1]"));
        bookmark1.click();

        bookmark2 = driver.findElement(By.xpath("(//i[@class='fa fa-star-o mt-2 mark-as-favourite'])[2]"));
        bookmark2.click();
        Thread.sleep(1000);
        course = driver.findElement(By.xpath("(//h6[@class='font-gothic'])[3]"));
        course.click();
        Thread.sleep(1000);
        
        specifycourse = driver.findElement(By.xpath("(//span[@class='instancename'])[5]"));
        specifycourse.click();
        iframe = driver.findElement(By.xpath("//iframe[@id='scorm_object']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(1000);
        
        countinue = driver.findElement(By.xpath("//button[text()='YES']"));
        countinue.click();
        slide = driver.findElement(By.xpath("//img[@id='img4_44f2f488']"));
        Thread.sleep(1000);
        
        ts = (TakesScreenshot) slide;
        source = ts.getScreenshotAs(OutputType.FILE);
        trg = new File(".\\screenshots\\Course Page.png");
        Files.copy(source, trg);
        driver.switchTo().defaultContent();
        Myjob = driver.findElement(By.xpath("//a[@class='menu-expander']"));
        Myjob.click();
        Thread.sleep(1000);
        
        WebElement element = driver.findElement(By.xpath("//span[@class='vector-icon ic-calendar-solid']"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
        Thread.sleep(2000);
        
        calenderbtn = driver.findElement(By.xpath("//span[@class='vector-icon ic-calendar-solid']"));
        calenderbtn.click();
        Thread.sleep(1000);
        
        techcalender = driver.findElement(By.xpath("//span[@class='instancename']"));
        techcalender.click();
        Thread.sleep(1000);

        calender = driver.findElement(By.xpath("//div[@class='box py-3 generalbox center clearfix']"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", calender);
        Thread.sleep(1000);
        
        ts = (TakesScreenshot) calender;
        source = ts.getScreenshotAs(OutputType.FILE);
        trg = new File(".\\screenshots\\Calender.png");
        Files.copy(source, trg);
        Thread.sleep(2000);
        
        bookmarkbtn = driver.findElement(By.xpath("(//span[@class='vector-icon ic-star-solid'])[2]"));
        bookmarkbtn.click();
        Thread.sleep(1000);
        
        actual1 = driver.findElement(By.xpath("(//h6[@class='font-gothic'])[1]")).getText();
        actual2 = driver.findElement(By.xpath("(//h6[@class='font-gothic'])[2]")).getText();
        System.out.println("Bookmarks are: " + actual1 + "\n" + actual2);
        Assert.assertEquals(actual1, expected1);
        Assert.assertEquals(actual2, expected2);

        bookmarksverify = driver.findElement(By.xpath("(//div[@class='row no-gutters'])[2]"));
        ts = (TakesScreenshot) bookmarksverify;
        source = ts.getScreenshotAs(OutputType.FILE);
        trg = new File(".\\screenshots\\Bookmarks.png");
        Files.copy(source, trg);

        driver.findElement(By.xpath("(//i[@title='Click to remove from favourites'])[1]")).click();
        driver.findElement(By.xpath("(//i[@title='Click to remove from favourites'])[2]")).click();

        home = driver.findElement(By.xpath("//span[@class='vector-icon ic-guage-solid']"));
        home.click();
    }

    @AfterMethod
    public void teardown() {

        Logout = driver.findElement(By.xpath("//span[@data-original-title='Logout']"));
        Logout.click();
        driver.close();
    }
}
