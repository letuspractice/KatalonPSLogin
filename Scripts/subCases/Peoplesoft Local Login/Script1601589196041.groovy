import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('Login Process/manual/Local Login'))

WebUI.setText(findTestObject('Login Process/recorded/Local/Page_Sign In  Home at Azusa Pacific University/input_APU NetId_userid'),
	GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Login Process/recorded/Local/Page_Sign In  Home at Azusa Pacific University/input_Password_pwd'),
	GlobalVariable.password)

WebUI.click(findTestObject('Login Process/recorded/Local/Page_Sign In  Home at Azusa Pacific University/input_Guest Access_Submit'))

'Verify message after logging in'
if (WebUI.verifyTextPresent('User ID and Password are required.', false, FailureHandling.OPTIONAL) == true) {
	'stop processing'
	println("Missing Username or Password")
	throw new com.kms.katalon.core.exception.StepFailedException('Missing Username or Password')
	
} else if (WebUI.verifyTextPresent('Your User ID and/or Password are invalid.', false, FailureHandling.OPTIONAL) == true) {
	'stop processing'
	println("Invalid Username and/or Password")
	throw new com.kms.katalon.core.exception.StepFailedException('Invalid Username and/or Password')
} else {
	println("Username or Password should be good")

}
