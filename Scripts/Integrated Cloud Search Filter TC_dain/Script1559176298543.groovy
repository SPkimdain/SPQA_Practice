import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join

// 통합 클라우드
String url = 'https://54.250.198.183/'

/*
 * 테스트 시 변경할 변수
 * id : 계정 아이디
 * pw : 계정 비밀번호
 * page : 테스트 할 페이지
 * content : 검색 할 항목
 * list : 검색 키워드 데이터
 *
 * */

// 계정 아이디, 비밀번호
String id = "cd8025@nate.com"
String pw = "a1234567!"
// 테스트 할 페이지 - 1 : 전체 프로젝트 목록, 2 : 전체 분석 목록
int page = 1
// 검색 할 항목 - <전체 프로젝트 목록> 1 : 프로젝트명 | <전체 분석 목록> 1 : 프로젝트명
int content = 1
// 검색 키워드 데이터
List<String> list = new ArrayList()
list.add('Improper') // 포함
list.add('improper') // 포함하지 않음
list.add('improper') // 같음
list.add('Imp') // 시작함
list.add('per') // 끝남
list.add('improper') // 패턴일치

switch (page) {
    case '1':
        url += 'projects'
        break
    case '2':
        url += 'analyses'
        break
}

WebUI.openBrowser(url)

def driver = DriverFactory.getWebDriver()

String baseUrl = url

selenium = new WebDriverBackedSelenium(driver, baseUrl)

// 로그인

selenium.type("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/DIV[2]/DIV[1]/DIV[1]/INPUT[1]", id)
selenium.type("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/DIV[2]/DIV[2]/DIV[1]/INPUT[1]", pw)
selenium.click("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/BUTTON[1]")


// xpath
String modal = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/BUTTON[1]'

String dropDown = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(content)) + ']/DIV[2]/A[1]/DIV[1]/B[1]'

String select = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(content)) + ']/DIV[2]/DIV[1]/UL[1]'

String textField = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(content)) + ']/INPUT[1]'

String btnSearch = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(page + 6)) + ']/BUTTON[1]'

String btnReset = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(page + 6)) + ']/BUTTON[2]'

// 드롭다운 인덱스
int liIndex = 0

// 검색 모달창
for (int index = 0; index < 6; index++) {
    // 1초 정지
    Thread.sleep(1000)

    liIndex = (index + 1)

    // 모달창 펼침
    selenium.click(modal)

    // 드롭다운 펼침
    selenium.click(dropDown)

    // 포함~패턴일치 선택
    selenium.click(((select + '/LI[') + String.valueOf(liIndex)) + ']')

    // 텍스트 필드에 입력
    selenium.type(textField, list.get(index))

    // 검색 버튼
    selenium.click(btnSearch)
}



