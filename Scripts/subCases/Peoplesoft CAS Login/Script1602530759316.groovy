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
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Login Process/manual/CAS login'))

WebUI.setText(findTestObject('Login Process/recorded/CAS/Page_Login - CAS  Central Authentication Service/input_username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Login Process/recorded/CAS/Page_Login - CAS  Central Authentication Service/input_password'), 
    GlobalVariable.password)

'If there is no NETID the submit button will be un-clickable and this would fail'
WebUI.click(findTestObject('Login Process/recorded/CAS/Page_Login - CAS  Central Authentication Service/submit'))

'Verify message after submit'
if (WebUI.verifyTextPresent('Password is a required field.', false, FailureHandling.OPTIONAL) == true) {
    'stop processing'
    println('***** Missing Password *****')

    throw new com.kms.katalon.core.exception.StepFailedException('Missing Username or Password')
} else if (WebUI.verifyTextPresent('Invalid credentials.', false, FailureHandling.OPTIONAL) == true) {
    'stop processing'
    println('***** Invalid Username and/or Password *****')

    throw new com.kms.katalon.core.exception.StepFailedException('Invalid Username and/or Password')
} else {
    'Login should have been sucessful here'
    println('Username or Password should be good here')
}

