package com.epam.trapeznikau

import com.epam.trapeznikau.steps.Steps
import org.testng.Assert
import org.testng.Assert.*
import org.testng.annotations.AfterTest

import org.testng.annotations.BeforeTest
import org.testng.annotations.Parameters
import org.testng.annotations.Test

class GitHubAutomationTest {

    lateinit var step : Steps

    @BeforeTest
    fun initSteps(){
        step = Steps()
        step.initBrowser()
    }

    @AfterTest
    fun closeDriver(){
//        step.closeDriver()
    }

    @Test
    @Parameters("login", "password")
    fun tstGitLoginIn(login : String, password : String)
        = assertEquals("https://github.com/GitHubTestingProject",step.signIn(login, password))

    @Test(dependsOnMethods = arrayOf("tstGitLoginIn"))
    @Parameters("nameRepo")
    fun tstCreateRepository(nameRepo : String)
            = assertEquals("NewRepo",step.createRepo(nameRepo))

    @Test(dependsOnMethods = arrayOf("tstCreateRepository"))
    @Parameters("newNameRepo")
    fun tstModifyRepository(nameRepo : String)
            = assertEquals("ModifyRepo",step.modifyRepo(nameRepo))

    @Test(dependsOnMethods = arrayOf("tstModifyRepository"))
    fun tstCommitToRepository()
            = assertEquals("README.md",step.commitReadmeToRepo())

    @Test(dependsOnMethods = arrayOf("tstCommitToRepository"))
    @Parameters("newNameRepo")
    fun tstDeleteRepository(nameRepo : String)
            = assertTrue(step.deleteRepo(nameRepo))

}