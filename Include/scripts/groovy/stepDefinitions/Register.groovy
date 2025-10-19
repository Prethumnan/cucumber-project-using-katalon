package stepDefinitions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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
import org.openqa.selenium.support.ui.Select
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
import pages.registerPage
import helper.UserData
import helper.MessageLoader
import utilities.commonUtilities




class Register {

	def home = new homePage()
	def register = new registerPage()
	def data = UserData.getNewUser()
	def ms = new MessageLoader()

	@Given("User is on the signin page")
	def nativageToSigninPage() {

		home.clickSignin()
	}

	@When("User enters a valid email address in create account section")
	def enterValidEmailAddress() {

		//Using the generated email id by the faker from the UserData.java class

		String email = data.email
		register.enterEmail(email)
	}



	@And("User clicks on Create an account button")
	def clickCreateAccountButton() {

		register.clickCreateAccountBtn()
	}





	@And("Enters all mandatory fiels and click register button")
	def verifyCreateAccountWithvalidDatas() {

		String gender = data.gender
		if(gender.equals("Male")) {

			register.chooseMale()
		}

		else {
			register.chooseFemale()
		}

		register.enterFirstName(data.firstName)
		register.enterLastName(data.lastName)
		register.enterPassword(data.password)
		register.selectDay(data.day)
		register.selectMonth(data.month)
		register.selectYear(data.year)




		Boolean news= data.newsletter
		if(news) {
			register.clickNewsletter()
		}


		register.clickRegisterBtn()
	}

	@Then("User should get a success message")
	def validatingSuccessMsg() {



		WebUI.verifyMatch(register.getSuccessMsgText(),ms.getRegisterMessage("expected_account_created_success_msg"), false)
	}

	@And("User should log out")
	def signoutFromTheAccountPage() {
		register.clicksignout()
	}


	@When("user enters no email id")
	def createAccountWithNoemail() {

		//Using the generated email id by the faker from the UserData.java class


		register.enterEmail(" ")
	}



	@Then("the error message should appear")
	def validatingInvalidEmailMsg() {

		WebUI.verifyMatch(register.getInvaliedEmailText(),ms.getRegisterMessage("expected_invalid_email_msg"), false)
	}

	@When("user enters already registered email")
	def createAccountWithRegisteredEmail() {

		register.enterEmail(ms.getRegisterMessage("already_registered_email"))
	}

	@Then("the error message already registered should appear")
	def validatingAlreadyRegisteredMsg() {

		WebUI.verifyMatch(register.alreadyRegisteredMsgText,ms.getRegisterMessage("expected_already_registered_msg"), false)
	}


	@And("enter longer name and fill fills rest of the fields")
	def enteringLongerFirstNameInUserRegistraionPage() {

		String gender = data.gender
		if(gender.equals("Male")) {

			register.chooseMale()
		}

		else {
			register.chooseFemale()
		}
		register.enterFirstName(ms.getRegisterMessage("longerFirstName"))
		register.enterLastName(data.lastName)
		register.enterPassword(data.password)
		register.selectDay(data.day)
		register.selectMonth(data.month)
		register.selectYear(data.year)
	}

	@And("User clicks on register button")
	def clickRegisterButton() {

		register.clickRegisterBtn()
	}

	@Then("the error message first name too long message should appear")
	def validatingLongerFirstNameMsg() {

		WebUI.verifyMatch(register.firstNameTooLongMsgText,ms.getRegisterMessage("expected_first_name_toolong_msg"), false)
	}

	@And("password less than 5 character and fills the rest of the fields")
	def enterPasswordLessthan5Characters() {

		String gender = data.gender

		if(gender.equals("Male")) {

			register.chooseMale()
		}

		else {
			register.chooseFemale()
		}
		register.enterFirstName(data.firstName)
		register.enterLastName(data.lastName)
		register.enterPassword(ms.getRegisterMessage("shortPassoword"))
		register.selectDay(data.day)
		register.selectMonth(data.month)
		register.selectYear(data.year)
	}


	@Then("the error message invalid password should appear")
	def validatingInvalidPasswordMsg() {

		WebUI.verifyMatch(register.invalidPasswordMsgText,ms.getRegisterMessage("expected_password_invalid_msg"), false)
	}
}



