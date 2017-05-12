package com.epam.trapeznikau.pages

import org.openqa.selenium.WebDriver

/**
 * Created by Siarhei_Trapeznikau on 5/4/2017.
 */
abstract class AbstractPage protected constructor(protected var driver : WebDriver){
        abstract fun openPage()
}