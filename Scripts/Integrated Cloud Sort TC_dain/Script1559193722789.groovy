import static org.junit.Assert.*

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
String projectID = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/TABLE[1]/THEAD[1]/TR[1]/TH[2]/I[2]'
String projectName = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/TABLE[1]/THEAD[1]/TR[1]/TH[3]/I[2]'
String analyticNum = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/TABLE[1]/THEAD[1]/TR[1]/TH[4]/I[1]'
String analyticType = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/TABLE[1]/THEAD[1]/TR[1]/TH[5]/I[1]'
String analyticState = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/TABLE[1]/THEAD[1]/TR[1]/TH[6]/I[1]'
String vulner = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/TABLE[1]/THEAD[1]/TR[1]/TH[6]/I[2]'
String date = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/TABLE[1]/THEAD[1]/TR[1]/TH[8]/I[1]'

Thread.sleep(3000)

// 프로젝트ID 정렬
//selenium.click(projectID)
//Thread.sleep(1000)
//
//// 프로젝트명 정렬
//selenium.click(projectName)
//Thread.sleep(1000)
//
//// 전체 분석 수 정렬
//selenium.click(analyticNum)
//Thread.sleep(1000)
//
//// 최근 분석 유형 정렬
//selenium.click(analyticType)
//Thread.sleep(1000)
//
//// 최근 분석 상태 정렬
//selenium.click(analyticState)
//Thread.sleep(1000)
//
//// 최근 검출 취약점 정렬
//selenium.click(vulner)
//Thread.sleep(1000)
//
//// 최근 분석 일시 정렬
//selenium.click(date)

//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='삭제'])[2]/following::th[2]")
// selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='프로젝트 ID'])[1]/following::th[1]")
// selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='프로젝트명'])[3]/following::th[1]")
// selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='전체 분석 수'])[2]/following::th[1]")
// selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='최근 분석 유형'])[2]/following::th[1]")
// selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='최근 분석 상태'])[2]/following::th[1]")
// selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='최근 검출 취약점'])[2]/following::th[1]")