package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageUIs.AddPeoplePageUI;

public class AddPeoplePageObject extends BasePage {

    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public AddPeoplePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTableData(String fieldName, String value) {
        waitForElementVisible(driver, AddPeoplePageUI.DYNAMIC_BY_ROW, fieldName);
        int rowIndex = getElementSize(driver, AddPeoplePageUI.DYNAMIC_BY_ROW, fieldName);
        for (int i = 1; i <= rowIndex; i++) {
            String rowIndexString = String.valueOf(i);
            waitForElementVisible(driver, AddPeoplePageUI.DYNAMIC_INPUT_BY_ROWINDEX, fieldName, rowIndexString);
            sendKeysElement(driver, AddPeoplePageUI.DYNAMIC_INPUT_BY_ROWINDEX, fieldName, rowIndexString, value);

        }
    }

    public void selectDateToTableData(String fieldName, String columnName) {
        waitForElementVisible(driver, AddPeoplePageUI.DYNAMIC_BY_ROW, fieldName);
        int rowIndex = getElementSize(driver, AddPeoplePageUI.DYNAMIC_BY_ROW, fieldName);

        for (int i = 1; i <= rowIndex; i++) {
            String rowIndexString = String.valueOf(i);
            waitForElementVisible(driver, AddPeoplePageUI.DYNAMIC_BY_COLUMN, columnName);
            String columnIndexString = String.valueOf(getElementSize(driver, AddPeoplePageUI.DYNAMIC_BY_COLUMN, columnName) + 1);
            clickElement(driver, AddPeoplePageUI.DYNAMIC_INPUT_BY_COLUMNINDEX, rowIndexString, columnIndexString);
            clickElement(driver, AddPeoplePageUI.CURRENT_DATE);
        }
    }

    public void clickToAddPeople() {
        clickElement(driver, AddPeoplePageUI.ADDPEOPLE_BUTTON);
        softAssert.assertTrue(isCongratulationMessageDisplayed());
        softAssert.assertAll();
    }

    public boolean isCongratulationMessageDisplayed() {
        return isControlDisplayed(driver, AddPeoplePageUI.CONGRATULATION_MESSAGE);
    }

    public void selectItemDropdownToTableData(String columnName, String keySearch) {
        waitForElementVisible(driver, AddPeoplePageUI.MANAGER_DROPDOWN_BY_ROW);
        int rowIndex = getElementSize(driver, AddPeoplePageUI.MANAGER_DROPDOWN_BY_ROW);

        for (int i = 1; i <= rowIndex; i++) {
            String rowIndexString = String.valueOf(i);
            waitForElementVisible(driver, AddPeoplePageUI.DYNAMIC_BY_COLUMN, columnName);
            String columnIndexString = String.valueOf(getElementSize(driver, AddPeoplePageUI.DYNAMIC_BY_COLUMN, columnName) + 1);
            waitForElementVisible(driver, AddPeoplePageUI.DYNAMIC_INPUT_BY_COLUMNINDEX, rowIndexString, columnIndexString);
            clickElement(driver, AddPeoplePageUI.DYNAMIC_INPUT_BY_COLUMNINDEX, rowIndexString, columnIndexString);
            waitForElementVisible(driver, AddPeoplePageUI.SEARCH_INPUT);
            sendKeysElement(driver, AddPeoplePageUI.SEARCH_INPUT, keySearch);
            clickElement(driver, AddPeoplePageUI.DYNAMIC_SEARCH_RESULT, keySearch);
        }
    }

    public void addMore() {
        clickElement(driver, AddPeoplePageUI.ADD_MORE_LINK);
        waitForElementVisible(driver, AddPeoplePageUI.DYNAMIC_BY_ROW, "firstName");
        int rowIndex = getElementSize(driver, AddPeoplePageUI.DYNAMIC_BY_ROW, "firstName");
        softAssert.assertTrue(rowIndex == 8);
        softAssert.assertAll();
    }
}
