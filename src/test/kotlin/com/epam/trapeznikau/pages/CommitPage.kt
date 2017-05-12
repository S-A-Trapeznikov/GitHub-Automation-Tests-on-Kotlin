package com.epam.trapeznikau.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

/**
 * Created by Siarhei_Trapeznikau on 5/12/2017.
 */
class CommitPage (driver : WebDriver) : AbstractPage(driver){
    private val COMMIT_PAGE_URL = "https://github.com/GitHubTestingProject/ModifyRepo/new/master?readme=1"

    init {
        PageFactory.initElements(this.driver,this)
    }

    @FindBy(xpath = "//button[@id='submit-file']")
    lateinit var buttonCommit : WebElement
    @FindBy(xpath = "//a[@title='README.md']")
    lateinit var readmeFile : WebElement


    override fun openPage() = driver.navigate().to(COMMIT_PAGE_URL)

    fun commitReadMeToRepo() : String{
        buttonCommit.click()
        return readmeFile.text
    }
}