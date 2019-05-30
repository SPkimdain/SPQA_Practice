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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://54.250.198.183/login?redirect=%2F')

WebUI.setText(findTestObject('Page_Sparrow /input'), 'cd8025@nate.com')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_1'), 'J7R4ejOak4Y=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_2'), 'sFQ/sJkzszM=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_3'), 'Aun1WIhHykk=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_4'), 'GaTb6kjfkao=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_5'), 'TPWnJBNgUs0=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_6'), 'eFl1iyAb2pw=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_7'), 'ZUgKSRs8gNk=')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_8'), 'i5Tq7bplk6MF9WrVZAohcg==')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_9'), 'i5Tq7bplk6P0C1eZvqsR5w==')

WebUI.setEncryptedText(findTestObject('Page_Sparrow /input_10'), 'i5Tq7bplk6P0C1eZvqsR5w==')

WebUI.sendKeys(findTestObject('Page_Sparrow /input_11'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_/div_'))

WebUI.click(findTestObject('Object Repository/Page_   -/th_ ID'))

WebUI.click(findTestObject('Object Repository/Page_   -/th_'))

WebUI.click(findTestObject('Object Repository/Page_   -/th_'))

WebUI.click(findTestObject('Object Repository/Page_   -/th_  _1'))

WebUI.click(findTestObject('Object Repository/Page_   -/th_  _2'))

WebUI.doubleClick(findTestObject('Object Repository/Page_   -/div__limn-loading'))

WebUI.click(findTestObject('Object Repository/Page_   -/th_  _3'))

WebUI.click(findTestObject('Object Repository/Page_   -/th_  _4'))

