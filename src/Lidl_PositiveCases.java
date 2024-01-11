import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import java.util.List;

public class Lidl_PositiveCases extends BaseDriver {
    @Test
    public void US101() {
        driver.get("https://www.lidl.com/");

        Assert.assertEquals("Is the entered url correct? = ","https://www.lidl.com/", driver.getCurrentUrl());
        MyMethods.waitAndQuit();
    }

     @Test
        public void US102(){
         driver.get("https://www.lidl.com/");
         MyMethods.myWait(1);

         MyMethods.cookies();
         MyMethods.myWait(2);

         WebElement signIn = driver.findElement(By.cssSelector("li.sign-in"));
         signIn.click();
         MyMethods.myWait(2);

         WebElement joinMyLidl = driver.findElement(By.cssSelector("a[data-test='register']"));
         joinMyLidl.click();

         Assert.assertEquals("Is the entered url (register) correct?  =  = ", "https://www.lidl.com/register", driver.getCurrentUrl());
         MyMethods.myWait(1);

         WebElement firstNameInputBox = driver.findElement(By.name("firstName"));
         firstNameInputBox.click();
         firstNameInputBox.sendKeys("Nessa");
         MyMethods.myWait(1);

         WebElement lastNameInputBox = driver.findElement(By.name("lastName"));
         lastNameInputBox.sendKeys("Dougherty");
         MyMethods.myWait(1);

         WebElement emailInputBox = driver.findElement(By.name("email"));
         emailInputBox.sendKeys("ndougherty91@webmd.com");
         MyMethods.myWait(2);

         WebElement confirmEmailInputBox = driver.findElement(By.name("confirm_email"));
         confirmEmailInputBox.sendKeys("ndougherty91@webmd.com");
         MyMethods.myWait(2);

         WebElement passWordInputBox = driver.findElement(By.name("password"));
         passWordInputBox.sendKeys("Qwerty12");
         MyMethods.myWait(1);

         WebElement phoneNumberInputBox = driver.findElement(By.name("phone"));
         phoneNumberInputBox.sendKeys("(555)345-6178");
         MyMethods.myWait(2);

         WebElement zipCodeInputBox = driver.findElement(By.name("zip"));
         zipCodeInputBox.sendKeys("43217");
         MyMethods.myWait(2);

         WebElement birthdayInputBox = driver.findElement(By.name("birthday"));
         birthdayInputBox.sendKeys("10/25/1996");
         MyMethods.myWait(2);

         WebElement addressLineInputBox = driver.findElement(By.name("mailingStreet"));
         addressLineInputBox.sendKeys("Room 1695 9 Sunfield Hill");
         MyMethods.myWait(1);

         WebElement cityInput = driver.findElement(By.name("mailingCity"));
         cityInput.sendKeys("Columbus");
         MyMethods.myWait(1);

         WebElement stateDropbox = driver.findElement(By.id("select0"));
         stateDropbox.click();
         MyMethods.myWait(2);

         List<WebElement> dropdownOptions = driver.findElements(By.name("mailingState"));
         for (WebElement e : dropdownOptions) {
             e.getText();
             e.sendKeys("New York");
             e.click();
         }
         MyMethods.myWait(2);

         WebElement termsSelect = driver.findElement(By.cssSelector("span[class='square']"));
         termsSelect.click();
         if (termsSelect.isSelected()) {
             termsSelect.click();
         }
         MyMethods.myWait(1);

         WebElement submit = driver.findElement(By.cssSelector("div[class='spinnie-container']"));
         submit.click();
         MyMethods.myWait(3);

         WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
         Assert.assertEquals("Is the account correct?  = ","Nessa D.",myAccountName.getText());
         MyMethods.logout();
         waitAndQuit();
     }

     @Test
     public void US103(){

         MyMethods.login();
         MyMethods.myWait(2);

         WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
         myAccountName.click();
         MyMethods.myWait(2);

         WebElement myName = driver.findElement(By.cssSelector("div.info>div.name"));
         myName.click();
         MyMethods.myWait(1);

         Assert.assertEquals("Account Name = ","Nessa D.",myAccountName.getText());

         WebElement lastNameInputBox = driver.findElement(By.name("lastName"));
         lastNameInputBox.clear();
         MyMethods.myWait(1);
         lastNameInputBox.sendKeys("12");
         MyMethods.myWait(1);

         WebElement saveBtn = driver.findElement(By.cssSelector("button[type='submit']"));
         saveBtn.click();
         MyMethods.myWait(2);

         WebElement successMsg = driver.findElement(By.cssSelector("div.success > p[aria-live='assertive']"));

         Assert.assertEquals("Success message","profile updated successfully",successMsg.getText());
         MyMethods.logout();
         waitAndQuit();
     }

     @Test
     public void US104(){

         MyMethods.login();
         MyMethods.myWait(2);

         WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
         myAccountName.click();
         MyMethods.myWait(2);

         WebElement myName = driver.findElement(By.cssSelector("div.info>div.name"));
         myName.click();
         MyMethods.myWait(1);

         WebElement preferences = driver.findElement(By.partialLinkText("preferences"));
         preferences.click();

         WebElement kidFriendlyToggle = driver.findElement(By.cssSelector("input[name='kidfriendly']"));
         kidFriendlyToggle.click();

         WebElement kosherToggle = driver.findElement(By.cssSelector("input[name='kosher']"));
         kosherToggle.click();

         WebElement organicToggle = driver.findElement(By.cssSelector("input[name='organic']"));
         organicToggle.click();

         MyMethods.myWait(1);

         WebElement saveBtn = driver.findElement(By.cssSelector("button[type='submit']"));
         saveBtn.click();
         WebElement successMsg = driver.findElement(By.cssSelector("div.success > p[aria-live='assertive']"));
         System.out.println(successMsg.getText());
         MyMethods.myWait(2);

         Assert.assertEquals("Success message","profile updated successfully",successMsg.getText());
         MyMethods.logout();
         waitAndQuit();
     }

     @Test
     public void US105(){

         MyMethods.login();

         WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
         myAccountName.click();
         MyMethods.myWait(2);

         WebElement myName = driver.findElement(By.cssSelector("div.info>div.name"));
         myName.click();
         MyMethods.myWait(1);

         WebElement accountManagement = driver.findElement(By.partialLinkText("account management"));
         accountManagement.click();
         MyMethods.myWait(1);

         WebElement deleteBtn = driver.findElement(By.cssSelector("button[type='submit']"));
         deleteBtn.click();
         MyMethods.myWait(1);

         WebElement deleteConfirmMsg = driver.findElement(By.cssSelector("div.dialog-content"));

         Assert.assertEquals("Delete confirm message","Are you sure you want to delete your account? Think it over long and hard!",deleteConfirmMsg.getText());

         WebElement deleteConfirmBtn = driver.findElement(By.cssSelector("button[data-test='confirmation-button']"));
         deleteConfirmBtn.click();
         waitAndQuit();
     }
}

