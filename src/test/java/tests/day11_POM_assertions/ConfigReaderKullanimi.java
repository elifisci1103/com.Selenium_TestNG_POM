package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ConfigReaderKullanimi {
    @Test
    public void test01(){
    //Amazon anasayfaya gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    //Nutella için arama yapalım.
        AmazonPage amazonpage = new AmazonPage();
        amazonpage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
    //Arama sonuçlarının nutella içerdiğini test edelim.
        String actualIcerik=amazonpage.aramaSonucElementi.getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        Driver.closeDriver();
}}
