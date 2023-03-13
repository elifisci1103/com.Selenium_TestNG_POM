package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QdemyPage {
    public QdemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")
    public WebElement emailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement basariliGirisElementi;
    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement cerezKabul;
    @FindBy(xpath = "(//a[text()='Sign Up'])[1]")
    public WebElement homeSignUpButonu;

    @FindBy(xpath = "(//img[@class='img-fluid'])[1]")
    public WebElement userProfileImg;
    @FindBy(xpath="//a[text()='User profile']")
    public WebElement userProfileText;

    @FindBy(xpath = "//input[@id='FristName']")
    public WebElement userProfileFirstName;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement userProfileLastName;

    @FindBy(id="Biography_ifr")
    public WebElement iframe;

    @FindBy(xpath = "//body[@data-id='Biography']")
    public WebElement biography;

    @FindBy(xpath = "//button[@class='btn red px-5 py-2 radius-8']")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[@class='user-box']")
    public WebElement homeUserName;

}
