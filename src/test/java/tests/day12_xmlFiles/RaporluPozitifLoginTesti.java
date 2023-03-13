package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class RaporluPozitifLoginTesti extends TestBaseRapor {
    @Test
    public void pozitifLoginTesti(){
        extentTest = extentReports.createTest("Pozitif login testi","gecerli bilgilerle giris yapilabilmeli");
        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("Qualitydemy anasayfaya gidildi");

        // login linkine tiklayin
        QdemyPage qdemyPage =new QdemyPage();
        qdemyPage.ilkLoginLinki.click();
        extentTest.info("İlk Login linkine tıklandı.");

        // gecerli kullanici adi ve password ile giris yapin
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));

        qdemyPage.cerezKabul.click();
        ReusableMethods.bekle(5);
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdemyPage.loginButonu.click();

        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdemyPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("Basarılı bir şekilde giriş yapıldı.");

    }

    }





