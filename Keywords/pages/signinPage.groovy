package pages

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

public class signinPage {

	//  Lazy Initialization
	private TestObject getEmailField() {
		return findTestObject('Object Repository/Signin/Page_Login - My Shop/Signin email')
	}

	private TestObject getPasswordField() {
		return findTestObject('Object Repository/Signin/Page_Login - My Shop/signin passwd')
	}

	private TestObject getSigninButton() {
		return findTestObject('Object Repository/Signin/Page_Login - My Shop/signin btn')
	}

	private TestObject getlogout() {
		return findTestObject('Object Repository/Signin/After signin/logout')
	}

	private TestObject getWelcomeMsg() {
		return findTestObject('Object Repository/Signin/After signin/Welcome message')
	}

	private TestObject getAuthonticationFailedMsg() {
		return findTestObject('Object Repository/Signin/Messages/authonticationFailedMsg')
	}

	private TestObject getEmailRequiredMsg() {
		return findTestObject('Object Repository/Signin/Messages/emailRequiredMsg')
	}

	private TestObject getInvalidEmailAddressMsg() {
		return findTestObject('Object Repository/Signin/Messages/invalidEmailAddressMsg')
	}



	// 🟡 Keywords
	@Keyword
	def enterEmail(String email) {
		WebUI.setText(getEmailField(), email)
	}

	@Keyword
	def enterPassword(String password) {
		WebUI.setText(getPasswordField(), password)
	}

	@Keyword
	def clickSignInBtn() {
		WebUI.click(getSigninButton())
	}

	@Keyword
	def getWelcomeMsgText() {
		return WebUI.getText(getWelcomeMsg())
	}

	@Keyword
	def clickLogout() {

		WebUI.click(getlogout())
	}

	@Keyword
	def getAuthonticationFailedMsgText() {
		return WebUI.getText(getAuthonticationFailedMsg())
	}

	@Keyword
	def getEmailRequiredMsgText() {
		return WebUI.getText(getEmailRequiredMsg())
	}

	@Keyword
	def getInvalidEmailAddressMsgText() {
		return WebUI.getText(getInvalidEmailAddressMsg())
	}
}
