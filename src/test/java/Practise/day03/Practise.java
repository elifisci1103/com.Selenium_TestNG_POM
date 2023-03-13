package Practise.day03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Practise {
    QdemyPage qdemyPage=new QdemyPage();
    @Test
    public void test01(){

    // Kullanici https://qualitydemy.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

    // Siteye basarili bir sekilde giris yapar

        qdemyPage.cerezKabul.click();
        ReusableMethods.bekle(2);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(qdemyPage.homeSignUpButonu.isDisplayed());

        //Login olur.

        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdemyPage.loginButonu.click();
        ReusableMethods.bekle(10);

    // sag taraf bulunan kullanici menusunden User Profile kismina gider
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(qdemyPage.userProfileImg).perform();
        qdemyPage.userProfileText.click();

    // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
       String nameValue=qdemyPage.userProfileFirstName.getAttribute("value");
       String lastNameValue=qdemyPage.userProfileLastName.getAttribute("value");
       softAssert.assertTrue(nameValue.contains("Nevzat"));
       softAssert.assertTrue(lastNameValue.contains("Celik"));
       Driver.getDriver().switchTo().frame(qdemyPage.iframe);
       String biographyValue=qdemyPage.biography.getText();
       softAssert.assertTrue(biographyValue.contains("Wisequarter"));

        Driver.getDriver().switchTo().defaultContent();
    // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular
      qdemyPage.userProfileFirstName.clear();
      qdemyPage.userProfileFirstName.sendKeys("Ali");
      qdemyPage.userProfileLastName.clear();
      qdemyPage.userProfileLastName.sendKeys("Veren");
      Driver.getDriver().switchTo().frame(qdemyPage.iframe);
      qdemyPage.biography.clear();
      qdemyPage.biography.sendKeys("ögrenci");
      Driver.getDriver().switchTo().defaultContent();
      actions.sendKeys(Keys.PAGE_DOWN).build().perform();
      qdemyPage.saveButonu.submit();
      ReusableMethods.bekle(3);
      String username=qdemyPage.homeUserName.getText();
      String expectedUsername="Ali Veren";
      softAssert.assertEquals(username,expectedUsername);
        softAssert.assertAll();


}}
