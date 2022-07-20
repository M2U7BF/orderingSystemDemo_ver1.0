package com.example.ordering;

import java.util.List;

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
		driver.findElement(By.id("order")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Test
	void すべて選択する() {
		List<WebElement> foodListitems = driver.findElements(By.className("foodListItem"));
		for(WebElement foodListitem : foodListitems){
			foodListitem.click();
		}
	}
	
	@Test
	void すべて購入個数を選択し合計金額を表示() {
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

}
