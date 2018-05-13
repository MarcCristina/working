package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BillingInformationPage {
    @FindBy(id = "billing:firstname")
    private WebElement firstNameField;

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    @FindBy(id = "billing:middlename")
    private WebElement middleNameField;

    public WebElement getMiddleNameField() {
        return middleNameField;
    }

    @FindBy(id = "billing:lastname")
    private WebElement lastNameField;

    public WebElement getLastNameField() {
        return lastNameField;
    }

    @FindBy(id = "billing:company")
    private WebElement companyField;

    public WebElement getCompanyField() {
        return companyField;
    }

    @FindBy(id = "billing:email")
    private WebElement emailField;

    public WebElement getEmailField() {
        return emailField;
    }

    @FindBy(id = "billing:street1")
    private WebElement streetField1;

    public WebElement getStreetField() {
        return streetField1;
    }

    @FindBy(id = "billing:street2")
    private WebElement getStreetField2;

    public WebElement getGetStreetField2() {
        return getStreetField2;
    }

    @FindBy(id = "billing:city")
    private WebElement cityField;

    public WebElement getCityField() {
        return cityField;
    }

    @FindBy(id = "billing:region_id")
    private WebElement stateSelectList;

    public Select getStateSelectList() {
        return new Select(stateSelectList);
    }

    @FindBy(id = "billing:postcode")
    private WebElement postCodeField;

    public WebElement getPostCodeField() {
        return postCodeField;
    }

    @FindBy(id = "billing:country_id")
    private WebElement countryField;

    public WebElement getCountryField() {
        return countryField;
    }

    @FindBy(id = "billing:telephone")
    private WebElement telephoneField;

    public WebElement getTelephoneField() {
        return telephoneField;
    }

    @FindBy(id = "billing:fax")
    private WebElement faxField;

    public WebElement getFaxField() {
        return faxField;
    }

    @FindBy(css = "#billing-buttons-container .button")
    private WebElement continueButton;

    public WebElement getContinueButton() {
        return continueButton;
    }

    @FindBy(id = "s_method_ups_XPD")
    private WebElement expeditedShippingMethod;

    public WebElement getExpeditedShippingMethod() {
        return expeditedShippingMethod;
    }
    @FindBy("")

}
