package stepDefinitions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pages.homePage
import pages.signinPage
import helper.MessageLoader
import pages.homePage
import pages.signinPage



class signin {



	def homepage = new homePage()

	def signinpage = new signinPage()
	
	def ms = new MessageLoader()


	@Given("user is on the signin page")
	def navigateToSigninPage() {

		
		homepage.clickSignin()
	}
	@When("User enters email {string} and password {string}")
	def enterValidEmailAndPasssword(String email, String password) {
		
		signinpage.enterEmail(email)
		signinpage.enterPassword(password)
		
	}
	
	@And("click signin button")
	def clickSigninButton() {
		signinpage.clickSignInBtn()
	}
	
	@Then("User should get the {string} message")
	def I_verify_the_status_in_step(String expected) {
		MessageLoader messageloader = new MessageLoader()
		String actual = signinpage.getWelcomeMsgText()
		WebUI.verifyMatch(actual, expected,false)
	}
	
	@And("click signout")
	def clickSignout() {
		
		signinpage.clickLogout()
	}
	
	@When("User enters nothinng")
	def doNotEnterEmailAndPassword() {
    // This method is now empty and does nothing
}

	@Then("User should get the email required message")
	def validatingEmptyLogin() {
	
		WebUI.verifyMatch(signinpage.getInvalidEmailAddressMsgText(),ms.getSigninMessage("expected_email_required_message") ,false)
	
}

	
	@Then("User should get authontication failed message")
	def validatingLoginwithWrongPassword() {
		
		WebUI.verifyMatch(signinpage.getAuthonticationFailedMsgText(),ms.getSigninMessage("expected_authontication_failed_message") ,false)
		
	}
	
	@Then("User should get the invalid email address message")
	def validatingWithInvalidEmailAddress() {
		
		WebUI.verifyMatch(signinpage.getInvalidEmailAddressMsgText(),ms.getSigninMessage("expected_invalid_email_address_message") ,false)
	}
}

	
