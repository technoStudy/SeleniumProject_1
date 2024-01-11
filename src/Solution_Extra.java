import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class Solution_Extra extends BaseDriver {

    public static void main(String[] args) {
        // US101 :
        driver.get("https://www.lidl.com/");
        boolean isURL = driver.getCurrentUrl().contains("www.lidl.com");
        if (isURL) System.out.println("Is the entered url correct?  = " + isURL);
        else System.out.println("Is the entered url (homepage) correct?  = " + false);
        MyMethods.myWait(2);

        // US102 :
        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        if (!(acceptCookiesButton == null))
            acceptCookiesButton.click();
        WebElement signIn = driver.findElement(By.cssSelector("li.sign-in"));
        signIn.click();
        MyMethods.myWait(2);
        WebElement joinMyLidl = driver.findElement(By.cssSelector("a[data-test='register']"));
        joinMyLidl.click();
        isURL = driver.getCurrentUrl().contains("www.lidl.com/register");
        if (isURL) System.out.println("Is the entered url (register) correct?  = " + isURL);
        else System.out.println("Is the entered url correct?  = " + false);
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
        boolean isItMyAccount = myAccountName.getText().contains("Nessa");
        if (isItMyAccount) System.out.println("Is the account correct?  = " + isItMyAccount);
        else System.out.println("Is the account correct?  = " + false);

        // US103
        /* sign out */
        myAccountName.click();
        MyMethods.myWait(1);
        WebElement signOut = driver.findElement(By.cssSelector("li[data-test='signOut']"));
        signOut.click();
        MyMethods.myWait(2);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        isURL = driver.getCurrentUrl().equalsIgnoreCase("https://www.lidl.com/");
        if (isURL) System.out.println("Is the navigated url correct?  = " + isURL);
        else System.out.println("Is the navigated url (homepage) correct?  = " + false);


        /* login */
        Actions action = new org.openqa.selenium.interactions.Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        driver.navigate().refresh();
        MyMethods.myWait(3);
        signIn = driver.findElement(By.cssSelector("li.sign-in"));
        signIn.click();
        MyMethods.myWait(2);
        emailInputBox = driver.findElement(By.cssSelector("input[name='email']"));
        emailInputBox.sendKeys("ndougherty91@webmd.com");
        passWordInputBox = driver.findElement(By.cssSelector("input[name='password']"));
        passWordInputBox.sendKeys("Qwerty12");
        WebElement signInBtn = driver.findElement(By.cssSelector("button[data-test='signInButton']"));
        signInBtn.click();
        MyMethods.myWait(2);
        myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
        System.out.println("myAccountName = " + myAccountName.getText());
        myAccountName.click();
        MyMethods.myWait(2);
        WebElement myName = driver.findElement(By.cssSelector("div.info>div.name"));
        myName.click();
        MyMethods.myWait(1);
        isURL = driver.getCurrentUrl().contains("www.lidl.com/profile/general");
        if (isURL) System.out.println("Is the myAccount url correct?  = " + isURL);
        else System.out.println("Is the myAccount url (homepage) correct?  = " + false);

        firstNameInputBox = driver.findElement(By.name("firstName"));
        firstNameInputBox.sendKeys(Keys.CONTROL + "a");
        firstNameInputBox.sendKeys(Keys.BACK_SPACE);
        firstNameInputBox.sendKeys("Wanessa");
        lastNameInputBox = driver.findElement(By.name("lastName"));
        lastNameInputBox.sendKeys(Keys.CONTROL + "a");
        lastNameInputBox.sendKeys(Keys.BACK_SPACE);
        lastNameInputBox.sendKeys("Doughter");

        MyMethods.myWait(1);
        WebElement saveBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        saveBtn.click();
        MyMethods.myWait(2);
        WebElement successMsg = driver.findElement(By.cssSelector("div.success > p[aria-live='assertive']"));
        String strSuccessMsg = successMsg.getText();
        myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
        boolean isItSuccess = strSuccessMsg.contains("profile updated successfully");
        if (isItSuccess && myAccountName.getText().contains("Wanessa"))
            System.out.println("Is Profile Updated? = " + isItSuccess);
        else System.out.println("Is Profile Updated? = " + false);

        // US104 :
        WebElement preferences = driver.findElement(By.partialLinkText("preferences"));
        preferences.click();
        WebElement kidFriendlyToggle = driver.findElement(By.cssSelector("input[name='kidfriendly']"));
        WebElement kosherToggle = driver.findElement(By.cssSelector("input[name='kosher']"));
        WebElement organicToggle = driver.findElement(By.cssSelector("input[name='organic']"));
        kidFriendlyToggle.click();
        kosherToggle.click();
        organicToggle.click();
        MyMethods.myWait(1);
        saveBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        saveBtn.click();
        successMsg = driver.findElement(By.cssSelector("div.success > p[aria-live='assertive']"));
        isItSuccess = successMsg.getText().contains("profile updated successfully");
        if (isItSuccess)
            System.out.println("Is Preferences Updated? = " + isItSuccess);

        // US105 :
        myAccountName.click();
        MyMethods.myWait(2);
        myName = driver.findElement(By.cssSelector("div.info>div.name"));
        myName.click();
        MyMethods.myWait(1);
        WebElement accountManagement = driver.findElement(By.partialLinkText("account management"));
        accountManagement.click();
        MyMethods.myWait(1);
        WebElement deleteBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        deleteBtn.click();
        MyMethods.myWait(1);
        WebElement deleteConfirmMsg = driver.findElement(By.cssSelector("div.dialog-content"));
        boolean isMsg = deleteConfirmMsg.getText().contains("Are you sure you want to delete your account?");
        if (isMsg) {
            System.out.println("Are you sure you want to delete your account? : " + isMsg);
        } else System.out.println("Are you sure you want to delete your account? : " + false);
        WebElement deleteConfirmBtn = driver.findElement(By.cssSelector("button[data-test='confirmation-button']"));
        deleteConfirmBtn.click();

        // QUIT :
        waitAndQuit();
    }
}
