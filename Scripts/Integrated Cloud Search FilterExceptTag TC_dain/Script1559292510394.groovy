import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium

import groovy.transform.Field


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
@Field String id = "cd8025@nate.com"
@Field String pw = "a1234567!"
// 테스트 할 페이지 - 1 : 전체 프로젝트 목록, 2 : 전체 분석 목록
@Field int page = 2
/* 검색 할 항목 - <전체 프로젝트 목록> 1 : 프로젝트명, 2 : 전체 분석 수, 3 : 최근 분석 유형, 4 : 최근 분석 상태 5 : 최근 검출 취약점 
				  <전체 분석 목록> 1 : 프로젝트명, 2 : 유형, 3 : 상태, 4 : 분석 체커 수, 5 : 검출 취약점 */
@Field int content = 3

switch (page) {
case '1':
	Allvar.url += 'projects'
	break
case '2':
	Allvar.url += 'analyses'
	break
}

WebUI.openBrowser(Allvar.url)

def var = new Allvar() // openBrowser밑에 써줘야 함 !!


// 로그인
var.selenium.type("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/DIV[2]/DIV[1]/DIV[1]/INPUT[1]", id)
var.selenium.type("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/DIV[2]/DIV[2]/DIV[1]/INPUT[1]", pw)
var.selenium.click("xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/FORM[1]/BUTTON[1]")


// xpath (포함~패턴일치 | =~≤)
@Field String modal = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/BUTTON[1]'
@Field String dropDown = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(content)) + ']/DIV[2]/A[1]/DIV[1]/B[1]'
@Field String select = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(content)) + ']/DIV[2]/DIV[1]/UL[1]'
@Field String textField = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(content)) + ']/INPUT[1]'
@Field String btnSearch = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(page + 6)) + ']/BUTTON[1]'
@Field String btnReset = ('xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[' + String.valueOf(page + 6)) + ']/BUTTON[2]'

// xpath (드롭다운 형식)
@Field String dropDown2 = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV['+String.valueOf(content)+']/DIV[2]/UL[1]/LI[1]'
@Field String select2 = 'xpath=/HTML[1]/BODY[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV['+String.valueOf(content)+']/DIV[2]/DIV[1]/UL[1]'

if(page == 1){
	switch(content){
		case 1:
			textFiter()
			break;
		case 2:
			textFiter()
			break;
		case 3:
			dropFilter()
			break;
		case 4:
			dropFilter()
			break;
		case 5:
			textFiter()
			break;
	}
} else {
	switch(content){
	case 1:
		textFiter()
		break;
	case 2:
		dropFilter()
		break;
	case 3:
		dropFilter()
		break;
	case 4:
		textFiter()
		break;
	case 5:
		textFiter()
		break;
	}
}
void textFiter() {
	// 드롭다운 인덱스
	int liIndex = 0
	def var = new Allvar()
	// 검색 키워드 데이터
	List<String> list = new ArrayList()
	if(content == 1) {
		list.add('a') // 포함
		list.add('b') // 포함하지 않음
		list.add('c') // 같음
		list.add('d') // 시작함
		list.add('e') // 끝남
		list.add('f') // 패턴일치
	} else {
		list.add('1') // =
		list.add('2') // ≠
		list.add('3') // >
		list.add('4') // ≥
		list.add('5') // <
		list.add('6') // ≤
	}
	
	// 검색 모달창 (포함~패턴일치 | =~≤)
	for (int index = 0; index < 6; index++) {
		// 1초 정지
		Thread.sleep(1000)
	
		liIndex = (index + 1)
	
		// 모달창 펼침
		var.selenium.click(modal)
	
		// 드롭다운 펼침
		var.selenium.click(dropDown)
	
		// 포함~패턴일치 | =~≤ 선택
		var.selenium.click(((select + '/LI[') + String.valueOf(liIndex)) + ']')
	
		// 텍스트 필드에 입력
		var.selenium.type(textField, list.get(index))
	
		// 검색 버튼
		var.selenium.click(btnSearch)
	}
}

void dropFilter(){
	int range = 0
	int liIndex = 0
	def var = new Allvar()
	
	if(page == 1){
		switch(content){
			case 3:
				range = 2
				break;
			case 4:
				range = 8
				break;
		}	
	} else {
		switch(content){
			case 2:
				range = 2
				break;
			case 3:
				range = 8
				break;
		}
	}
	// 검색 모달창 (드롭다운 형식)
	for (int index = 0; index < range; index++) {
		// 1초 정지
		Thread.sleep(1000)
		
		liIndex = (index + 1)
		
		// 모달창 펼침
		var.selenium.click(modal)
		
		// 드롭다운 펼침
		var.selenium.click(dropDown2)
		
		// 드롭다운 선택
		var.selenium.click(((select2 + '/LI[') + String.valueOf(liIndex)) + ']')
		
		// 검색 버튼
		var.selenium.click(btnSearch)
		
		Thread.sleep(1000)
		// 모달창 펼침
		var.selenium.click(modal)
		
		// 초기화 버튼
		var.selenium.click(btnReset)
	}
}

class Allvar {
	static String url = "https://54.250.198.183/"
	def driver = DriverFactory.getWebDriver()
	def selenium = new WebDriverBackedSelenium(driver, url)
}

