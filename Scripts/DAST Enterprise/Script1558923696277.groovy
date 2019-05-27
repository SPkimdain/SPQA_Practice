import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('http://dastwin.fasoo.com:39000/login?redirect=%2Fdashboard')

WebUI.navigateToUrl('http://dastwin.fasoo.com:39000/login?redirect=%2Fdashboard')

WebUI.setText(findTestObject('Page_Sparrow DAST/input'), 'dain')

WebUI.setEncryptedText(findTestObject('Page_Sparrow DAST/input_1'), 'HeCM15nHKBI=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow DAST/input_2'), 'HeCM15nHKBI=')

WebUI.click(findTestObject('Page_Sparrow DAST/button_'))

WebUI.click(findTestObject('Page_/div_'))

WebUI.click(findTestObject('Object Repository/Page_  -/button__limn-filter limn-toggle-filter'))

WebUI.setText(findTestObject('Object Repository/Page_  -/input__main'), 'dain')

WebUI.click(findTestObject('Object Repository/Page_  -/button_'))

WebUI.click(findTestObject('Object Repository/Page_  -/button__limn-filter limn-toggle-filter'))

WebUI.click(findTestObject('Object Repository/Page_  -/button_'))

WebUI.click(findTestObject('Object Repository/Page_  -/li_'))

WebUI.click(findTestObject('Object Repository/Page_  -/button_'))

WebUI.click(findTestObject('Object Repository/Page_  -/button__limn-filter limn-toggle-filter'))

WebUI.click(findTestObject('Object Repository/Page_  -/span_'))

WebUI.click(findTestObject('Object Repository/Page_  -/li_'))

WebUI.click(findTestObject('Object Repository/Page_  -/button_'))

