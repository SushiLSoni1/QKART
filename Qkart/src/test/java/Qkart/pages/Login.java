package Qkart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Login {
   
        WebDriver driver;   
        String url = "https://crio-qkart-frontend-qa.vercel.app/login";

    public Login(WebDriver driver) {
       this.driver = driver;

}

    public void navigateToLoginPage() {
        if(this.driver.getCurrentUrl()!=url){
            this.driver.get(url);
        }
}

        public void performlogin(String email, String password) throws InterruptedException {
            WebElement UserName = driver.findElement(By.id("username"));
           
            WebElement Password = driver.findElement(By.id("password"));
            
            WebElement Login_button = driver.findElement(By.xpath("//button[text()='Login to QKart']"));
            System.out.println("login with username "+UserName+" and password "+Password);
            // Enter UserName
           // lastGeneratedUsername = username;
            UserName.sendKeys(email);
            //Enter password
            Password.sendKeys(password);
            //Click on login button
            Login_button.click();

            Thread.sleep(5000);
           

           
        }

//         public Boolean verifyuserlogging(String UserName) {
//             try{
//                 Webelement username_lable = driver.findElement(By.id("username"));
//                 return username_lable.getText().equals(UserName);
//             }catch(Exception e){
//                 return false;
//             }
// }


}