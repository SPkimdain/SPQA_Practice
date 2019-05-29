import static org.junit.Assert.*

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

WebUI.openBrowser('http://dastwin.fasoo.com:39000/login?redirect=/results/projects')
def driver = DriverFactory.getWebDriver()
String baseUrl = "http://dastwin.fasoo.com:39000/login?redirect=/results/projects"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
// 로그인
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='취소'])[1]/following::input[1]", "dain")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='취소'])[1]/following::input[2]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='취소'])[1]/following::input[2]", "1")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='취소'])[1]/following::button[1]")

// 검색 키워드 데이터
List<String> list = new ArrayList()
list.add("1")
list.add("2")
list.add("3")
list.add("4")
list.add("5")
list.add("6")

// 드롭다운 인덱스
int liIndex = 0;

// 결과 보기 - 검색 모달창
for(int index = 0 ; index <list.size() ; index++ ){
	// 1초 정지
	Thread.sleep(1000)
	
	liIndex = index + 1
		
	// 모달창 펼침
	selenium.click("xpath=/HTML[1]/BODY[1]/DIV[12]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/BUTTON[1]/I[1]")
	// 드롭다운 펼침
	selenium.click("xpath=/HTML[1]/BODY[1]/DIV[12]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/A[1]/DIV[1]/B[1]")
	// 포함 선택
	selenium.click("xpath=/HTML[1]/BODY[1]/DIV[12]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[1]/UL[1]/LI["+liIndex+"]")
	// 텍스트 필드에 입력
	selenium.type("xpath=/HTML[1]/BODY[1]/DIV[12]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/INPUT[1]", list.get(index))
	// 검색 버튼
	selenium.click("xpath=/HTML[1]/BODY[1]/DIV[12]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[7]/BUTTON[1]")
	
}
