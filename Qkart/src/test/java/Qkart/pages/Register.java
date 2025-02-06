package Qkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.UUID;
public class Register {
     WebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/register";
    public String lastGeneratedUsername = "";

    public Register(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateToRegisterPage() {
        if(this.driver.getCurrentUrl()!=url){
            this.driver.get(url);
        }
    }

    public void registerUser(String email, String password, String confirmpassword, boolean isDynamicUserRequired) {
        String username;
        if(isDynamicUserRequired){
            username = email+UUID.randomUUID().toString();
        }
        else{
            username = email;
        }
        System.out.println("user name "+username);
        WebElement UserName = driver.findElement(By.id("username"));
        WebElement Password = driver.findElement(By.id("password"));
        WebElement ConfirmPassword = driver.findElement(By.id("confirmPassword"));
        WebElement Register_button = driver.findElement(By.xpath("//button[text()='Register Now']"));
        UserName.sendKeys(username);
        lastGeneratedUsername = username;
        Password.sendKeys(password);
        ConfirmPassword.sendKeys(confirmpassword);
        Register_button.click();
        
        

    }
    // public Boolean isRegisterPageisDisplayed(){
    //     return registerformHeader.isDisplayed();
    // }
}
