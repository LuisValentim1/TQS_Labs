package com.toptal.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeveloperApplyPage {
    private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(id="talent_create_applicant_email")
    WebElement developer_email;

    @FindBy(id = "talent_create_applicant_password")
    WebElement developer_password;

    @FindBy(id = "talent_create_applicant_password_confirmation")
    WebElement developer_password_confirmation;

    @FindBy(id = "talent_create_applicant_full_name")
    WebElement developer_full_name;

    @FindBy( id ="save_new_talent_create_applicant")
    WebElement join_toptal_button;

    @FindBy( css =".has-default_value")
    WebElement developer_talent;

    @FindBy( css = ".custom_select-options_item")
    WebElement developer_talent_option;

    @FindBy( css = ".cookie_banner-btn_allow")
    WebElement cookie_button;


    //Constructor
    public DeveloperApplyPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void setDeveloper_talent() {
        developer_talent.click();
        developer_talent_option.click();
    }

    public void setDeveloper_email(String email){
        developer_email.clear();
        developer_email.sendKeys(email);
    }

    public void setDeveloper_password(String password){
        developer_password.clear();
        developer_password.sendKeys(password);
    }

    public void  setDeveloper_password_confirmation(String password_confirmation){
        developer_password_confirmation.clear();
        developer_password_confirmation.sendKeys(password_confirmation);
    }

    public void setDeveloper_full_name (String fullname){
        developer_full_name.clear();
        developer_full_name.sendKeys(fullname);
    }

    public void clickOnJoin(){
        cookie_button.click();
        join_toptal_button.click();
    }

    public boolean isPageOpened(){
        //Assertion
        return heading.getText().toString().contains("Apply to Join");
    }
}
