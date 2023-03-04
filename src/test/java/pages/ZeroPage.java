package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {
    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
