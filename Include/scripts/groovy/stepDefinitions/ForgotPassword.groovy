
package stepDefinitions

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import pages.homePage
import pages.forgotPasswordPage
import helper.MessageLoader


class ForgotPassword {
	
	
	def homepage = new homePage()
	def forgot = new forgotPasswordPage()
	def ms = new MessageLoader()
	
	
	
	@Given("user is on the forgot password page")
	def navigateToForgotPasswordPage() {
		
		homepage.clickSignin()
		forgot.clickForgotPassword()
	}
	
	@When("User enters email {string}")
	def enterEmail(String email) {
				
		forgot.enterEmail(email)
	}
	
	@And("click retrive password button")
	def clickingTheRetrivePasswordButton() {
		
		forgot.clickRetrievePasswordBtn()
	}
	
	@Then("User should get the A confirmation email has been sent to your address message")
	def validatingSuccessMsg() {
		
		String actualMsg = forgot.getConfirmMsg()
		String expectedMsg = ms.getForgotMessage("expected_confirmation_message")

		WebUI.verifyEqual(actualMsg.contains(expectedMsg), true)


	}
	
	@Then("User should get the There is no account registered for this email address message")
	def validatingRetrivePasswordwithNewemail() {
		
		WebUI.verifyMatch(forgot.getNoRegisteredAccountMsg(),ms.getForgotMessage("expected_no_registered_account_msg"), false)
	}
	
	@When("User enters no email id")
	def enteringNoEmailId() {
		
		
	}
	
	@Then("User should get the Invalid email address message")
	def validateRetrivePasswordWithNoemail() {
		
		WebUI.verifyMatch(forgot.getInvalidEmailMsg(),ms.getForgotMessage("expected_invalid_email_address_msg"), false)
	}
	
	
	

   
}
