package com.epam.trapeznikau.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.concurrent.TimeUnit


object DriverSingleton {
    private val driver: WebDriver
    private val WEBDRIVER_GECKO_DRIVER : String  = "webdriver.gecko.driver"
    private val GECKO_DRIVER_PATH : String = "driver\\geckodriver.exe"

    init {
          System.setProperty(WEBDRIVER_GECKO_DRIVER,GECKO_DRIVER_PATH)
          driver = FirefoxDriver()
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    fun getDriver() = driver

    fun closeDriver() = driver.close()
}