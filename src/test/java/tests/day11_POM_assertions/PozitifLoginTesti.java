package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PozitifLoginTesti {
    @Test(groups = "smoke")
    public void pozitifLoginTesti(){
            // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


            // login linkine tiklayin
        QdemyPage qdemyPage =new QdemyPage();
        qdemyPage.ilkLoginLinki.click();


            // gecerli kullanici adi ve password ile giris yapin
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));

        qdemyPage.cerezKabul.click();
        ReusableMethods.bekle(5);
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdemyPage.loginButonu.click();

            // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdemyPage.basariliGirisElementi.isDisplayed());
        Driver.closeDriver();
    }



    }

