package LMS.Login;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import browsers.BrowserFactory;
import jxl.Sheet;
import jxl.Workbook;

public class LoginWithMultipleSetsOfData extends JFrame{

    WebDriver driver;
    String baseUrl = "https://hcltech-lms.career-shaper.com/login/index.php";
    Workbook w;
    Sheet s;

    @Test(dataProvider = "credentials")
    public void verifyLoginCredentials(String scenario, String username, String password) throws InterruptedException {
      //  driver = BrowserFactory.startBrowser("chrome", baseUrl);
    	System.setProperty("webdriver.edge.driver","C:/Kavya_Selenium/msedgedriver.exe");
	    driver= new EdgeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(username);
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(password);
        driver.findElement(By.id("show-password-button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/section/div/div[1]/div/div[2]/div[2]/form/div[4]/div/label/span")).click();
        driver.findElement(By.xpath("//button[contains(@id,'login-button')]")).click();

        if(scenario.equals("bothcorrect")) {
            JFrame f1 = new JFrame();
            f1.getContentPane().setBackground(Color.BLACK);//BG Color
            f1.setLayout(null);//Remove the already build layout

            f1.setSize(300,200); 
            f1.setLocation(0,0);  
            f1.setVisible(true);
            JLabel heading = new JLabel("Both username and password are correct");
            heading.setBounds(20, 30, 1200, 60);
            heading.setFont(new Font("serif", Font.PLAIN, 15));
            heading.setForeground(Color.WHITE);
            f1.add(heading);
            Thread.sleep(2000);

            WebElement check = driver.findElement(By.linkText("TECHBEE_AMJ23_101_3"));
            Assert.assertTrue(check.isDisplayed(), "Login not success");
            Thread.sleep(2000);
            f1.dispose();

        }else if(scenario.equals("bothincorrect")){
            JFrame f2 = new JFrame();
            f2.getContentPane().setBackground(Color.BLACK);//BG Color
            f2.setLayout(null);//Remove the already build layout

            f2.setSize(300,200); 
            f2.setLocation(0,0);  
            f2.setVisible(true);
            JLabel heading = new JLabel("Both username and password are incorrect");
            heading.setBounds(20, 30, 1200, 60);
            heading.setFont(new Font("serif", Font.PLAIN, 15));
            heading.setForeground(Color.WHITE);
            f2.add(heading);
            Thread.sleep(2000);

            String errorMessage = driver.findElement(By.linkText("Invalid login, please try again")).getText();
            Assert.assertEquals(errorMessage, "Invalid login, please try again");
            Thread.sleep(2000);
            f2.dispose();

        }else if(scenario.equals("correctUsername")) {
            JFrame f3 = new JFrame();
            f3.getContentPane().setBackground(Color.BLACK);//BG Color
            f3.setLayout(null);//Remove the already build layout

            f3.setSize(300,200); 
            f3. setLocation(0,0);  
            f3. setVisible(true);
            JLabel heading = new JLabel("username correct, password incorrect");
            heading.setBounds(20, 30, 1200, 60);
            heading.setFont(new Font("serif", Font.PLAIN, 15));
            heading.setForeground(Color.WHITE);
            f3.add(heading);
            Thread.sleep(2000);

            String errorMessage = driver.findElement(By.linkText("Invalid login, please try again")).getText();
            Assert.assertEquals(errorMessage, "Invalid login, please try again");
            Thread.sleep(2000);
            f3.dispose();

        }else {
            JFrame f4 = new JFrame();
            f4.getContentPane().setBackground(Color.BLACK);//BG Color
            f4. setLayout(null);//Remove the already build layout

            f4.setSize(300,200); 
            f4. setLocation(0,0);  
            f4. setVisible(true);
            JLabel heading = new JLabel("username incorrect, password correct");
            heading.setBounds(20, 30, 1200, 60);
            heading.setFont(new Font("serif", Font.PLAIN, 15));
            heading.setForeground(Color.WHITE);
            f4.add(heading);
            Thread.sleep(2000);

            String errorMessage = driver.findElement(By.linkText("Invalid login, please try again")).getText();
            Assert.assertEquals(errorMessage, "Invalid login, please try again");
            Thread.sleep(2000);
            f4.dispose();

        }

        driver.close();

    }

    @DataProvider(name = "credentials")
    public Object [][] getData(){
        try {
            w = Workbook.getWorkbook(new File("C:\\Kavya_Selenium\\LMS Protal\\LMS_Login\\Testdata\\CredentialsForLMS.xls"));
            s = w.getSheet(0);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] a = new Object[s.getRows()][s.getColumns()];
        for(int i=0; i<s.getRows();i++) {
            for(int j=0; j<s.getColumns();j++) {
                a[i][j]= s.getCell(j, i).getContents();
            }
        }
        return a;
    }

}
