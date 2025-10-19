package utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import pages.registerPage;

public class commonUtilities {



	//This will convert the Test object into the webelement
	@Keyword
	def static convertToWebelement(TestObject to) {

		return WebUI.findWebElement(to)
	}

	@Keyword
	def static select(TestObject to,String s) {

		WebElement e = WebUI.findWebElement(to)

		def select = new Select(e)
		select.selectByVisibleText(s)
	}

	@Keyword
	def static explicitWait(TestObject to) {

		WebUI.waitForElementVisible(to, 20)

		return to;
	}

	//To call the text methods based on the word it contains
	@Keyword
	def static String callMsgMethod(String expectedMessage) {

		def register = new registerPage()

		// 1. Initialize variables
		String actualMessage = ""
		// TestObject messageElement = null // Used for the initial wait/check

		// 2. Use if-else if chain to map the expected message text to the correct getter method
		// NOTE: This logic assumes the EXPECTED_VALIDATION_MESSAGE column contains the actual message text.

		if (expectedMessage.contains("firstname is required")) {
			// Map to the element that displays the "First Name Required" error

			actualMessage = register.getFirstNameRequiredMsgText()
		} else if (expectedMessage.contains("lastname is required")) {
			actualMessage = register.getLastNameRequiredMsgText()
		} else if (expectedMessage.contains("passwd is required")) {
			actualMessage = register.getPasswordRequiredMsgText()
		} else if (expectedMessage.contains("too long. Maximum length: 32")) {
			// Check which 'too long' error to validate (First Name or Last Name)
			if (expectedMessage.contains("firstname")) {
				actualMessage = register.getFirstNameTooLongMsgText()
			} else if (expectedMessage.contains("lastname")) {
				actualMessage = register.getLastNameTooLongMsgText()
			} else if (expectedMessage.contains("passwd")) {
				actualMessage = register.getPasswordTooLongMsgText()
			}
		} else if (expectedMessage.contains("Invalid date of birth")) {
			actualMessage = register.getDateOfBirthMissingMsgText()
		} else if (expectedMessage.contains("passwd is invalid")) {
			actualMessage = register.getInvalidPasswordMsgText()
		} else if (expectedMessage.contains("An account using this email address has already been registered")) {
			actualMessage = register.getAlreadyRegisteredMsgText()
		} else if (expectedMessage.contains("Your account has been created")) {
			// This is a success message, which is usually in a different location
			actualMessage = register.getSuccessMsgText()
		}


		return actualMessage
	}
}
