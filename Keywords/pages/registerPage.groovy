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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import utilities.commonUtilities


import internal.GlobalVariable

class registerPage {

	// 🟢 Lazy getters for all elements
	private TestObject getCreateAccountEmail() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/Create account email')
	}

	private TestObject getCreateAccountBtn() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/Create account btn')
	}

	private TestObject getMale() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/Male')
	}

	private TestObject getFemale() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/Female')
	}

	private TestObject getFirstName() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/First name')
	}

	private TestObject getLastName() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/Last name')
	}

	private TestObject getPassword() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/input__passwd')
	}

	private TestObject getDay() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/days')
	}

	private TestObject getMonth() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/months')
	}

	private TestObject getYear() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/years')
	}

	private TestObject getNewsLetter() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/newsletter')
	}

	private TestObject getRegisterBtn() {
		return findTestObject('Object Repository/Register/Page_Login - My Shop/Register btn')
	}

	private TestObject getWelcomeMsg() {
		return findTestObject('Object Repository/Register/Messages/Welcome message')
	}

	private TestObject getSuccessMsg() {
		return findTestObject('Object Repository/Register/Messages/Account created success message')
	}

	private TestObject getAlreadyRegisteredMsg() {
		return findTestObject('Object Repository/Register/Messages/alreadyRegisteredMsg')
	}

	private TestObject getInvalidEmailMsg() {
		return findTestObject('Object Repository/Register/Messages/invalidEmailMsg')
	}

	private TestObject getFirstNameRequiredMsg() {
		return findTestObject('Object Repository/Register/Messages/firstNameRequiredMsg')
	}

	private TestObject getLastNameRequiredMsg() {
		return findTestObject('Object Repository/Register/Messages/Page_Login - My Shop/lastNameRequiredMsg')
	}

	private TestObject getFirstnameTooLongMsg() {
		return findTestObject('Object Repository/Register/Messages/firstNameToolongMsg')
	}

	private TestObject getLastNameTooLongMsg() {
		return findTestObject('Object Repository/Register/Messages/lastNameToolongMsg')
	}

	private TestObject getDateOfBirthMissingMsg() {
		return findTestObject('Object Repository/Register/Messages/invalidDateofBirthMsg')
	}

	private TestObject getPasswordRequiredMsg() {
		return findTestObject('Object Repository/Register/Messages/passwordRequiredMsg')
	}

	private TestObject getInvalidPasswordMsg() {
		return findTestObject('Object Repository/Register/Messages/passwordInvalidMsg')
	}

	private TestObject getPasswordTooLongMsg() {
		return findTestObject('Object Repository/Register/Messages/passwordTooLongMsg')
	}

	private TestObject signout() {
		return findTestObject('Object Repository/Register/sign out')
	}

	// 🟡 Actions
	@Keyword
	def enterEmail(String email) {
		WebUI.setText(getCreateAccountEmail(), email)
	}

	@Keyword
	def clickCreateAccountBtn() {
		WebUI.click(getCreateAccountBtn())
	}

	@Keyword
	def chooseMale() {
		WebUI.click(getMale())
	}

	@Keyword
	def chooseFemale() {
		WebUI.click(getFemale())
	}

	@Keyword
	def enterFirstName(String first) {
		WebUI.setText(getFirstName(), first)
	}

	@Keyword
	def enterLastName(String last) {
		WebUI.setText(getLastName(), last)
	}

	@Keyword
	def enterPassword(String pass) {
		WebUI.setText(getPassword(), pass)
	}

	@Keyword
	def selectDay(String dayValue) {

		WebUI.selectOptionByValue(getDay(), dayValue, false)
	}

	@Keyword
	def selectMonth(String monthValue) {

		WebUI.selectOptionByLabel(getMonth(), monthValue, false)
	}

	@Keyword
	def selectYear(String yearValue) {



		WebUI.selectOptionByLabel(getYear(), yearValue, false)
	}

	@Keyword
	def clickNewsletter() {
		WebUI.click(getNewsLetter())
	}

	@Keyword
	def clickRegisterBtn() {
		WebUI.click(getRegisterBtn())
	}

	def clicksignout() {

		WebUI.waitForElementVisible(signout(), 10)

		WebUI.click(signout())
	}

	//Getters

	@Keyword
	def firstname() {

		getFirstName()
	}




	// 🟣 Validation Messages
	@Keyword def getWelcomeMsgText() {




		return WebUI.getText(commonUtilities.explicitWait(getWelcomeMsg()))
	}
	@Keyword def getSuccessMsgText() {


		return WebUI.getText(commonUtilities.explicitWait(getSuccessMsg()))
	}
	@Keyword def getAlreadyRegisteredMsgText() {


		return WebUI.getText(commonUtilities.explicitWait(getAlreadyRegisteredMsg()))
	}
	@Keyword def getFirstNameRequiredMsgText() {

		return WebUI.getText(commonUtilities.explicitWait(getFirstNameRequiredMsg()))
	}
	//------------------------------------------------------------
	@Keyword
	def getLastNameRequiredMsgText() {
		return WebUI.getText(commonUtilities.explicitWait(getLastNameRequiredMsg()))
	}

	@Keyword
	def getFirstNameTooLongMsgText() {
		return WebUI.getText(commonUtilities.explicitWait(getFirstnameTooLongMsg()))
	}

	@Keyword
	def getLastNameTooLongMsgText() {
		return WebUI.getText(commonUtilities.explicitWait(getLastNameTooLongMsg()))
	}

	@Keyword
	def getDateOfBirthMissingMsgText() {
		return WebUI.getText(commonUtilities.explicitWait(getDateOfBirthMissingMsg()))
	}

	@Keyword
	def getPasswordRequiredMsgText() {
		return WebUI.getText(commonUtilities.explicitWait(getPasswordRequiredMsg()))
	}

	@Keyword
	def getInvalidPasswordMsgText() {
		return WebUI.getText(commonUtilities.explicitWait(getInvalidPasswordMsg()))
	}

	@Keyword
	def getPasswordTooLongMsgText() {
		return WebUI.getText(commonUtilities.explicitWait(getPasswordTooLongMsg()))
	}

	@Keyword
	def getInvaliedEmailText() {
		return WebUI.getText(commonUtilities.explicitWait(getInvalidEmailMsg()))
	}
}
