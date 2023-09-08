package LMS.Login;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class DailyTask {

    WebDriver driver;
    String baseUrl = "https://hcltech-lms.career-shaper.com/login/index.php";
    WebElement Username;
    WebElement password;
    WebElement button;
    WebElement login;
    WebElement Batchname;
    WebElement Next;
    WebElement DailyTask;
    WebElement taskstatus1;
    WebElement taskstatus2;
    WebElement Status_Menu;
    WebElement screenshot;
    File source;
    File trg;

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
        DailyTask = driver.findElement(By.xpath("//span[@class='vector-icon file-solid']"));
        DailyTask.click();
        Thread.sleep(2000);
        // Adding Task 1
        driver.findElement(By.xpath("//button[@class='add-task-button']")).click();
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CRT Final Assements");
        driver.findElement(By.xpath("//textarea [@class='form-control']")).sendKeys("IKM & LAB Final Assesments");
        // driver.findElement(By.id("yui_3_17_2_1_1693638013111_49")).sendKeys("08/31/2023");
        driver.findElement(By.xpath("(//span[text()='Group'])[1]")).click();
        driver.findElement(By.xpath("(//span[text()='High'])[1]")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        taskstatus1 = driver.findElement(By.xpath("(//span[@class='checkmark'])[1]"));
        taskstatus1.click();
        Thread.sleep(2000);
        System.out.println("Task 1 Completion Status 100 % :" + taskstatus1.isEnabled());
        // Adding Task 2
        driver.findElement(By.xpath("//button[@class='add-task-button']")).click();
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("OJT Start Status");
        driver.findElement(By.xpath("//textarea [@class='form-control']")).sendKeys("BI Interaction Session");
        // driver.findElement(By.id("yui_3_17_2_1_1693638013111_49")).sendKeys("08/31/2023");
        driver.findElement(By.xpath("(//span[text()='Group'])[1]")).click();
        driver.findElement(By.xpath("(//span[text()='High'])[1]")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        taskstatus2 = driver.findElement(By.xpath("(//span[@class='checkmark'])[2]"));
        taskstatus2.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        System.out.println("Task 2 Completion Status 100 % :" + taskstatus2.isEnabled());
        // Opening the Completed Tasks
        Status_Menu = driver.findElement(By.xpath("//div[@class='filter-dropdown']"));
        Status_Menu.click();
        driver.findElement(By.xpath("//li[@data-target='completed']")).click();
        screenshot = driver.findElement(By.xpath("//div[@class='row todo-row']"));
        // Taking the Screenshot
        TakesScreenshot ts = (TakesScreenshot) screenshot;
         source = ts.getScreenshotAs(OutputType.FILE);
        trg = new File(".\\Screenshots\\Task.png");
        Files.copy(source, trg);

    }
    

    @AfterMethod
    public void teardown() {
        driver.close();
    }

 

}