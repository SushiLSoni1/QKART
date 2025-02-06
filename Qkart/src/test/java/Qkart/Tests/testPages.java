package Qkart.tests;

import java.net.MalformedURLException;

import javax.xml.stream.events.StartDocument;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Qkart.pages.Login;
import Qkart.pages.Register;

public class testPages {

    static WebDriver driver;
    public static void logStatus(String type, String message, String status) {

        System.out.println(String.format("%s | %s | %s | %s", String.valueOf(java.time.LocalDateTime.now()), type, message, status));
        
    }

    @BeforeClass(enabled = true)
    public static void assignDriver() throws MalformedURLException {
        logStatus("driver","initalizing driver","started");
        driver = new ChromeDriver();
        logStatus("driver","initalizing driver", "success");
        
    }

    @AfterClass(enabled = true)
    public static void closeDriver() {
        logStatus("driver","closing driver","started");
        driver.quit();
        logStatus("driver","closing driver", "success");
    }

    @Test(description = "Verify functionality of navigate to register page", enabled = true)
    public void Test_navigateToRegisterPage() {
        logStatus("pagetest","navigate to register page","started");
        try{
            Register register = new Register(driver);
            register.navigateToRegisterPage();
            logStatus("pagetest","navigate to register page", "success");
        }
        catch(Exception e){
            logStatus("pagetest","navigate to register page", "failed");
            e.printStackTrace();
        }
    }

    @Test(description = "Verify functionality of register a user in register page", enabled = true, priority = 1)
        public  void testRegister_RegisterUser(){
            logStatus("pageTest", "register user", "stared ");
            try{
                Register register = new Register(driver);
                register.navigateToRegisterPage();
                register.registerUser("test123", "test123", "test123", true);
                logStatus("pageTest", "register user", "success");
            }
            catch(Exception e){
                logStatus("pageTest", "register user", "failed");   
                e.printStackTrace();
            }
             
        }

        @Test(description = "verify the user navigate to login", enabled = true)
        public void test_loginUser() throws Exception{
            Thread.sleep(5000);
            logStatus("testpage", "navigate to login page", "started");
            try{
                Login login = new Login(driver);
                login.navigateToLoginPage();
                logStatus("testpage", "navigate to login page", "success");
            }    
            catch(Exception e){
                logStatus("testpage", "navigate to login page", "failed");
                e.printStackTrace();
            }

        }
        @Test(description = "Verify functionality of login a user in login page", enabled = true, priority = 2)
        public  void testLogin_LoginUser() throws Exception{
            Thread.sleep(5000);
            logStatus("pageTest", "login user", "stared ");
            try{
                Login login = new Login(driver);
                login.navigateToLoginPage();
                login.performlogin("test123", "test123");
                logStatus("pageTest", "login user", "success");
            }
            catch(Exception e){
                logStatus("pageTest", "login user", "failed");   
                e.printStackTrace();
            }
        }
        
    

}
