package com.example.ordering;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	static WebDriver driver;
	
	@BeforeAll
	public static void initDriver() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@AfterAll
	public static void quit() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		driver.close();
	}
	
	@BeforeEach
	void move() {
		driver.get("http://localhost:8080/service");
	}

	@Test
	void すべて選択する() {
		driver.findElement(By.id("order")).click(); //選択画面へ
		
		List<WebElement> foodListitems = driver.findElements(By.className("foodListItem"));
		for(WebElement foodListitem : foodListitems){
			foodListitem.click();
		}
	}
	
	@Test
	void すべて購入個数を選択し合計金額を表示() {
		driver.findElement(By.id("order")).click(); //選択画面へ
		
		List<WebElement> foodListitems = driver.findElements(By.className("foodListItem"));
		for(WebElement foodListitem : foodListitems){
			foodListitem.click();
		}
		
		List<WebElement> selects = driver.findElements(By.className("numPurchase"));
		for(WebElement select : selects){
			Select selecttag = new Select(select);
			selecttag.selectByVisibleText("10");
		}
	}
	
	@Test
	void セッション() {
		driver.findElement(By.id("order")).click(); //選択画面へ
		
		List<WebElement> foodListitems = driver.findElements(By.className("foodListItem"));
		for(WebElement foodListitem : foodListitems){
			foodListitem.click();
		}
		
		List<WebElement> selects = driver.findElements(By.className("numPurchase"));
		for(WebElement select : selects){
			Select selecttag = new Select(select);
			
			Random rd = new Random();
			selecttag.selectByVisibleText(String.valueOf(rd.nextInt(14)+1));
		}
		
		driver.findElement(By.id("submit")).click(); //確認画面へ
		
		driver.findElement(By.id("correct")).click(); //選択画面へ
		
		List<WebElement> deleteButtons = driver.findElements(By.className("deleteButton")); //選択画面へ
		for(int i=0;i < deleteButtons.size();i++) {
			if(i>2&&10>i) {
				deleteButtons.get(i).click();
			}
		}
		
		driver.findElement(By.id("submit")).click(); //確認画面へ
	}
	
	@Test
	void 一通りの動作確認() {
		driver.findElement(By.id("order")).click(); //選択画面へ
		
		List<WebElement> foodListitems = driver.findElements(By.className("foodListItem"));
		for(WebElement foodListitem : foodListitems){
			foodListitem.click();
		}
		
		List<WebElement> selects = driver.findElements(By.className("numPurchase"));
		for(WebElement select : selects){
			Select selecttag = new Select(select);
			
			Random rd = new Random();
			selecttag.selectByVisibleText(String.valueOf(rd.nextInt(14)+1));
		}
		
		driver.findElement(By.id("submit")).click(); //確認画面へ
		
		driver.findElement(By.id("correct")).click(); //選択画面へ
		
		List<WebElement> deleteButtons = driver.findElements(By.className("deleteButton")); //選択画面へ
		for(int i=0;i < deleteButtons.size();i++) {
			if(i>2&&10>i) {
				deleteButtons.get(i).click();
			}
		}
		
		driver.findElement(By.id("submit")).click(); //確認画面へ
		driver.findElement(By.id("confirmed")).click(); //完了画面へ
	}

}
	