package com.epam.trapeznikau.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

/**
 * Created by MrHacker on 07.05.2017.
 */
class CreateRepository(driver : WebDriver) : AbstractPage(driver) {
    private val CREATE_NEW_REPOSITORY_PAGE_URL = "https://github.com/new"

    init{
        PageFactory.initElements(this.driver, this)
    }

    @FindBy(xpath = "//input[@id='repository_name']")
    lateinit var nameRepoField : WebElement
    @FindBy(xpath = "//button[contains(text(),'Create repository')]")
    lateinit var buttonCreateRepo : WebElement
    @FindBy(xpath = "//strong[@itemprop='name']")
    lateinit var nameRepo : WebElement


    override fun openPage() = driver.navigate().to(CREATE_NEW_REPOSITORY_PAGE_URL)

    fun createRepo(nameRepo : String) : String{
        nameRepoField.sendKeys(nameRepo)
        buttonCreateRepo.click()
        return this.nameRepo.text
    }

}