package tests.day13_crossBrowserTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class DataProviderNegatifLoginTesti {

    /*
        Verilen 5 farkli username ve password'u kullanarak
        qualitydemy uygulamasina girilemedigini test edin
     */

    @DataProvider
    public static Object[][] kullanicilar() {

        String[][] kullaniciList={{"Zafer","12345"},
                {"Mehmet","34567"},
                {"Sevilay","67890"},
                {"Enver","56789"},
                {"Ahmet Emre","54321"}};
        return kullaniciList;
    }

    @Test(dataProvider = "kullanicilar")
    public void negatifLogin1(String username, String password){
        QdemyPage qdemyPage= new QdemyPage();
        ReusableMethods.bekle(3);
        qdemyPage= new QdemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(username);
        qdemyPage.passwordKutusu.sendKeys(password);
        ReusableMethods.bekle(2);
        qdemyPage.loginButonu.submit();

        Assert.assertTrue(qdemyPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }
}
