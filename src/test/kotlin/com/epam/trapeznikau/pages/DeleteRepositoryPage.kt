package com.epam.trapeznikau.pages

import org.openqa.selenium.*
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebElement

/**
 * Created by Siarhei_Trapeznikau on 5/12/2017.
 */

class DeleteRepositoryPage(driver: WebDriver) :  AbstractPage(driver) {

        private val DELETE_REPO_PAGE_URL = "https://github.com/GitHubTestingProject/ModifyRepo/settings"
        private val DELETE_MSG = "Your repository \"GitHubTestingProject/ModifyRepo\" was successfully deleted."

        init {
            PageFactory.initElements(this.driver,this)
        }

        @FindBy(xpath = "//button[contains(text(),'Delete this repository')]")
        lateinit var buttonDelRepo : WebElement
        @FindBy(xpath = ".//*[@id='facebox']/div/div/form/p/input")
        lateinit var deleteField: WebElement
        @FindBy(xpath = ".//*[@id='facebox']/div/div/form/button")
        lateinit  var confirmButton: WebElement
        @FindBy(xpath = ".//*[@id='js-flash-container']/div/div")
        lateinit var confirmationOfDelete: WebElement


        override fun openPage() = driver.navigate().to(DELETE_REPO_PAGE_URL)

        fun deleteRepo(newNameRepo : String) : Boolean{

            buttonDelRepo.click()
            val wait = WebDriverWait(driver, 20)
            var element : WebElement = wait.until(ExpectedConditions.visibilityOf(deleteField))
            deleteField.sendKeys(newNameRepo);
            element = wait.until(ExpectedConditions.visibilityOf(confirmButton))
            confirmButton.submit();
            element = wait.until(ExpectedConditions.visibilityOf(confirmationOfDelete))
            return confirmationOfDelete.text.equals(DELETE_MSG)
        }

}
