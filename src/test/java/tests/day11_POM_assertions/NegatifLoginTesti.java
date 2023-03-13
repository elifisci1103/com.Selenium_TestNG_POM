package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NegatifLoginTesti {
    // qd anasayfaya gidin
    // 3 test method'u olusturun ve
    // asagidaki durumlarda giris yapilamadigini test edin
    // 1- gecerli username, gecersiz password
    // 2- gecersiz username, gecerli password
    // 3- gecersiz username, gecersiz password
    QdemyPage qdemyPage;
    @Test
    public void negatifLoginTesti1(){
        // 1- gecerli username, gecersiz password
        qdemyPage= new QdemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdemyPage.cerezKabul.click();
        ReusableMethods.bekle(5);
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdemyPage.loginButonu.click();
        Assert.assertTrue(qdemyPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

    @Test(groups = "smoke")

    public void negatifLoginTesti2(){
    //2- gecersiz username, gecerli password
        qdemyPage= new QdemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdemyPage.cerezKabul.click();
        ReusableMethods.bekle(5);
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdemyPage.loginButonu.click();
        Assert.assertTrue(qdemyPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void negatifLoginTesti3(){
    // 3- gecersiz username, gecersiz password
        qdemyPage= new QdemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdemyPage.cerezKabul.click();
        ReusableMethods.bekle(5);
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdemyPage.loginButonu.click();
        Assert.assertTrue(qdemyPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }
}
