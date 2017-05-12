package com.epam.trapeznikau.steps

import com.epam.trapeznikau.driver.DriverSingleton
import com.epam.trapeznikau.pages.*
import org.openqa.selenium.WebDriver
import java.sql.Driver

/**
 * Created by Siarhei_Trapeznikau on 5/4/2017.
 */
class Steps() {

    lateinit private var driver : WebDriver

    fun initBrowser() {
        driver = DriverSingleton.getDriver()
    }

    fun closeDriver() = DriverSingleton.closeDriver()

    fun  signIn(login : String, password : String):String{
        val loginPage : LoginPage = LoginPage(driver)
        loginPage.openPage()
        return loginPage.signIn(login,password)
    }

    fun createRepo(nameRepo :String) :String{
        val createNewRepository : CreateRepository = CreateRepository(driver)
        createNewRepository.openPage()
        return createNewRepository.createRepo(nameRepo)
    }

    fun modifyRepo(newNameRepo : String):String{
        val settingsRepo : SettingsRepositoryPage  = SettingsRepositoryPage(driver)
        settingsRepo.openPage()
        return settingsRepo.modifyRepo(newNameRepo)
    }

    fun commitReadmeToRepo() :String{
        val commitPage : CommitPage = CommitPage(driver)
        commitPage.openPage()
        return commitPage.commitReadMeToRepo()
    }

    fun deleteRepo(newNameRepo : String) :Boolean{
        val deletePage : DeleteRepositoryPage = DeleteRepositoryPage(driver)
        deletePage.openPage()
        return deletePage.deleteRepo(newNameRepo)
    }

}