import static org.junit.Assert.*

import org.openqa.selenium.By
import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

// 통합 클라우드 새 프로젝트 추가
String url = 'https://54.250.198.183/projects'

/*
 * 테스트 시 변경할 변수
 * id : 계정 아이디
 * pw : 계정 비밀번호
 * list : 추가 할 프로젝트 데이터
 *
 * */

// 계정 아이디, 비밀번호
String id = "cd8025@nate.com"
String pw = "a1234567!"
// 검색 키워드 데이터
List<String> list = new ArrayList()
list.add('project') // 프로젝트명
list.add('littleDain') // 체커명
list.add('http://125.141.219.118:39251/benchmark/BenchmarkTest01660.html') // url
list.add('설명입니다') // 비고
list.add('태그') // 태그

WebUI.openBrowser(url)

def driver = DriverFactory.getWebDriver()

String baseUrl = url

selenium = new WebDriverBackedSelenium(driver, baseUrl)

// 로그인

selenium.type("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/DIV[2]/DIV[1]/DIV[1]/INPUT[1]", id)
selenium.type("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/DIV[2]/DIV[2]/DIV[1]/INPUT[1]", pw)
selenium.click("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/BUTTON[1]")


// xpath
String addBtn = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[1]/DIV[1]/BUTTON[1]'
String projectField = 'xpath=/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/SPAN[1]/INPUT[1]'
String dropDown = 'xpath=/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[2]/SPAN[1]/DIV[1]/A[1]/SPAN[1]'
String checkerField = 'xpath=/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[2]/SPAN[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[1]'
String checkerFieldKey = '/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[2]/SPAN[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[1]'
String urlField = 'xpath=/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[3]/DIV[1]/DIV[2]/SPAN[1]/INPUT[1]'
String descriptionField = 'xpath=/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[4]/DIV[1]/DIV[2]/SPAN[1]/INPUT[1]'
String tagField = 'xpath=/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[5]/DIV[1]/DIV[2]/SPAN[1]/DIV[1]/SPAN[1]/SPAN[1]/INPUT[2]'
String addBtn2 = 'xpath=/HTML[1]/BODY[1]/HEADER[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[3]/BUTTON[1]'


Thread.sleep(1000)
// 새 프로젝트 추가 버튼
selenium.click(addBtn)

// 프로젝트명 입력
selenium.type(projectField, list.get(0))

// 체커 그룹 드롭다운 펼침
selenium.click(dropDown)
 
// 체커 그룹명 입력 (현재 체커 그룹명 적용이 되지 않음)
selenium.type(checkerField, list.get(1))

// 엔터
driver.findElement(By.xpath(checkerFieldKey)).sendKeys(Keys.ENTER)

// url 입력
selenium.type(urlField, list.get(2))

// 비고 입력
selenium.type(descriptionField, list.get(3))

// 태그 입력
selenium.type(tagField, list.get(4))

// 추가 버튼
//selenium.click(addBtn2)



