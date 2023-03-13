package tests.day13_crossBrowserTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class DataProvider extends TestBaseCross {
    @org.testng.annotations.DataProvider
    public static Object[][] urlListesi() {
        String[][] liste={{"amazonUrl"},{"wiseUrl"}};

        return liste;
    }

    /*
        Verilen 4 farkli websitesine gidin
        o sayfaya gidildigini test edin
        sayfayi kapatin
        amazonUrl
        wiseUrl
        qdUrl
        youtubeUrl
     */

    @Test(dataProvider = "urlListesi")
    public void urlTest(String gidilecekSite){

        Driver.getDriver().get(ConfigReader.getProperty(gidilecekSite));
        ReusableMethods.bekle(2);
        String actualurl= Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualurl,ConfigReader.getProperty(gidilecekSite)+"/");

        Driver.closeDriver();
    }
}
