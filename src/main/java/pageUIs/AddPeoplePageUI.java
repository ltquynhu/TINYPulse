package pageUIs;

public class AddPeoplePageUI {
    public static final String DYNAMIC_BY_COLUMN = "//th[contains(text(),'%s')]/preceding::th";
    public static final String DYNAMIC_INPUT_BY_COLUMNINDEX = "//tr[%s]//td[%s]";
    public static final String DYNAMIC_BY_ROW = "//tr//input[@field='%s']";
    public static final String DYNAMIC_INPUT_BY_ROWINDEX = "//input[@field='%s' and @refkey='%s']";

    public static final String MANAGER_DROPDOWN_BY_ROW = "//span[contains(text(),'Select ...')]";
    public static final String ADDPEOPLE_BUTTON = "//div[@role='button']/span[contains(text(),'Add People')]";
    public static final String CONGRATULATION_MESSAGE = "//*[contains(text(),'Congratulations')]";
    public static final String CURRENT_DATE = "//div[contains(@class,'DateItem__selected___3Zwpg')]";
    public static final String SEARCH_INPUT = "//*[@role ='list']//input";
    public static final String DYNAMIC_SEARCH_RESULT = "//p[contains(text(),'%s')]";
    public static final String ADD_MORE_LINK = "//*[@role='button']/span[contains(text(),'Add more')]";
}
