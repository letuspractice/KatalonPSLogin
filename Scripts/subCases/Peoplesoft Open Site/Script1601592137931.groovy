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

'Set a local varaible to the string in the Global variable to get the length'
String gURL = GlobalVariable.url

'Check to see if there is a URL before going forward'
if (gURL.length() == 0) {
    'stop processing and throw error'
    println('***** There is no URL in the current profile *****')

    throw new com.kms.katalon.core.exception.StepFailedException('Missing URL in the current profile')
}

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

if (GlobalVariable.type == 'local') {
    println('This is a local login')
	'call test case for local login'
	WebUI.callTestCase(findTestCase('subCases/Peoplesoft Local Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else if (GlobalVariable.type == 'cas') {
    'call test case for cas login'
    println('This is a cas login')
	WebUI.callTestCase(findTestCase('subCases/Peoplesoft CAS Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    println('This is a login type is unknown')

    WebUI.closeBrowser()

    throw new com.kms.katalon.core.exception.StepFailedException('Missing login type in the current profile')
}



