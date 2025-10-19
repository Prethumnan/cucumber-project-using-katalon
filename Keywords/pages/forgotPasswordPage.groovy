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


public class forgotPasswordPage {

	// 🟢 Lazy getters for all elements
	private TestObject getForgotPasswordLink() {
		return findTestObject('Object Repository/Forgot_password/Page_Login - My Shop/Forgot password')
	}

	private TestObject getEmailField() {
		return findTestObject('Object Repository/Forgot_password/Page_Forgot your password - My Shop/Forgot password emai')
	}

	private TestObject getRetrieveBtn() {
		return findTestObject('Object Repository/Forgot_password/Page_Forgot your password - My Shop/Retrive password btn')
	}

	private TestObject getConfirmMsgField() {
		return findTestObject('Object Repository/Forgot_password/Messages/Confirmation message')
	}

	private TestObject getInvalidEmailMsgField() {
		return findTestObject('Object Repository/Forgot_password/Messages/invalidEmailAddress')
	}

	private TestObject getNoRegisteredAccountMsgField() {
		return findTestObject('Object Repository/Forgot_password/Messages/noRegisteredAccountMsg')
	}

	// 🟡 Actions
	@Keyword
	def clickForgotPassword() {
		WebUI.click(getForgotPasswordLink())
	}

	@Keyword
	def enterEmail(String email) {
		WebUI.setText(getEmailField(), email)
	}

	@Keyword
	def clickRetrievePasswordBtn() {
		WebUI.click(getRetrieveBtn())
	}

	// 🟣 Validation Messages
	@Keyword
	def getConfirmMsg() {
		return WebUI.getText(getConfirmMsgField())
	}

	@Keyword
	def getInvalidEmailMsg() {
		return WebUI.getText(getInvalidEmailMsgField())
	}

	@Keyword
	def getNoRegisteredAccountMsg() {
		return WebUI.getText(getNoRegisteredAccountMsgField())
	}
}
