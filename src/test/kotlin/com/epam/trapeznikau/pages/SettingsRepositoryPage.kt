package com.epam.trapeznikau.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Created by MrHacker on 07.05.2017.
 */
class SettingsRepositoryPage(driver: WebDriver) :  AbstractPage(driver){
    private val SETTINGS_REPO_PAGE_URL = "https://github.com/GitHubTestingProject/NewRepo/settings"

    init {
        PageFactory.initElements(this.driver,this)
    }

    @FindBy(xpath = "//input[@id='rename_field']")
    lateinit var nameRepoField : WebElement
    @FindBy(xpath = "//button[contains(text(),'Rename')]")
    lateinit var buttonRename : WebElement
    @FindBy(xpath = "//strong[@itemprop='name']")
    lateinit var nameRepo : WebElement

    override fun openPage() = driver.navigate().to(SETTINGS_REPO_PAGE_URL)

    fun modifyRepo(newNameRepo : String) : String{
        nameRepoField.clear()
        nameRepoField.sendKeys(newNameRepo)
        val wait : WebDriverWait = WebDriverWait(driver,20)
        var element = wait.until { ExpectedConditions.visibilityOf(buttonRename)}
        buttonRename.click()
        driver.navigate().refresh()
        driver.navigate().refresh()
        element = wait.until { ExpectedConditions.visibilityOf(nameRepo)}
        return nameRepo.text
    }
}