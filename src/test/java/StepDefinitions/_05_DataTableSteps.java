package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _05_DataTableSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable items) {
        List<String> strButtons = items.asList(String.class);

        for (String strButton : strButtons) {

            WebElement element = ln.getWebElement(strButton);

            ln.clickFunction(element);
        }
    }

    @And("Click on the element in DialogContent")
    public void clickOnTheElementInDialogContent(DataTable dt) {
        List<String> strButtons = dt.asList(String.class);
        for (String strButton : strButtons) {

            WebElement element = dc.getWebElement(strButton);

            dc.clickFunction(element);
        }

    }

    @And("User sending the keys in Dialog Content")
    public void userSendingTheKeysInDialogContent(DataTable dt) {
        List< List<String> > items= dt.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement element= dc.getWebElement(items.get(i).get(0));
            dc.sendKeysFunction(element, items.get(i).get(1));
        }

    }

    @And("User delete item from Dialog Content")
    public void userDeleteItemFromDialogContent(DataTable dt) {
        List<String> strButtons = dt.asList(String.class);

        for (String strDeleteText : strButtons) {
            dc.deleteItem(strDeleteText);
        }
    }
}
