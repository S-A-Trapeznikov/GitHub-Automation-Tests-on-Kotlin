package com.epam.trapeznikau.pages

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

/**
 * Created by Siarhei_Trapeznikau on 5/4/2017.
 */
open class LoginPage(driver: WebDriver) : AbstractPage(driver) {
    private val LOGIN_PAGE_URL : String = "https://github.com/login"

    init{
        PageFactory.initElements(this.driver,this)
    }

    @FindBy(xpath ="//input[@id ='login_field']")
    lateinit var loginField : WebElement
    @FindBy(xpath ="//input[@id ='password']")
    lateinit var passwordField : WebElement
    @FindBy(xpath ="//input[@value ='Sign in']")
    lateinit var buttonSignIn : WebElement
    @FindBy(xpath ="//a[@aria-label='View profile and more']")
    lateinit var httpAdress : WebElement


    override fun openPage() = driver.navigate().to(LOGIN_PAGE_URL)

    fun signIn(login :String, password :String) :String {
        loginField.sendKeys(login)
        passwordField.sendKeys(password)
        buttonSignIn.click()
        return httpAdress.getAttribute("href")
    }
}