package com.avviotech.labs.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.avviotech.labs.dto.User;
import com.avviotech.labs.model.CustomerModel;
import com.avviotech.labs.repository.UserRepository;

public class Automate {

	
	public static CustomerModel automate(String userId, String pass,String otp,UserRepository userRepository) {
		CustomerModel model = new CustomerModel();
		User user = getUser(userId, pass,userRepository);
		model.setUser(user);
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\swayamagrawal\\Downloads\\chromedriver.exe");

			ChromeDriver chromedriver = new ChromeDriver();
			
			//driver.setDownloadImages(false);
			//driver.setAcceptSslCertificates(true);
			HtmlUnitDriver driver = new HtmlUnitDriver();

			if(user.getOtprequired())
			{
				chromedriver.get(user.getUrl());
				System.out.println("Title of the page is -> " + driver.getTitle());
				if(driver.getTitle().equalsIgnoreCase("Please Confirm your identity"))
				{
					user.setUrl("");
					user.setOtprequired(false);
					userRepository.save(user);
					model.setUser(user);
					
					WebElement codeElement = driver.findElement(By.name("code"));
					WebElement continueElement = driver.findElement(By.className("a-button-input"));
					codeElement.sendKeys(otp);
					//driver.setJavascriptEnabled(true);
					continueElement.click();
					System.out.println("Title of the page is -> "
							+ driver.getTitle());
					
					if (chromedriver.getTitle().equalsIgnoreCase("Amazon Sign In")) {
						WebElement email = driver.findElement(By.id("ap_email"));
						WebElement password = driver.findElement(By.id("ap_password"));
						WebElement loginBtn = driver.findElement(By.id("signInSubmit"));

						email.sendKeys(userId);
						password.sendKeys(pass);

						loginBtn.click();
						System.out.println("Title of the page is -> "
								+ driver.getTitle());
					}
					if (chromedriver.getTitle().equalsIgnoreCase("Amazon Sign In")) {
						WebElement email = driver.findElement(By.id("ap_email"));
						WebElement password = driver.findElement(By.id("ap_password"));
						WebElement loginBtn = driver.findElement(By.id("signInSubmit"));
						if(email.isDisplayed())
							email.sendKeys(userId);
						password.sendKeys(pass);

						loginBtn.click();
						System.out.println("Title of the page is -> "
								+ driver.getTitle());
					}
					if (chromedriver.getTitle().equalsIgnoreCase("Amazon Sign In")) {
						WebElement email = driver.findElement(By.id("ap_email"));
						WebElement password = driver.findElement(By.id("ap_password"));
						WebElement loginBtn = driver.findElement(By.id("signInSubmit"));
						if(email.isDisplayed())
							email.sendKeys(userId);
						password.sendKeys(pass);

						loginBtn.click();
						System.out.println("Title of the page is -> "
								+ driver.getTitle());
					}
					
					List<WebElement> es = chromedriver
							.findElementsByClassName("a-row");

					for (int i = 0; i < es.size(); i++) {

						WebElement e1 = es.get(i);
						if (e1.getText().equalsIgnoreCase("Name:"))
						{
							System.out.println("Element - "
								+ es.get(i + 1).getText());
							user.setName(es.get(i + 1).getText());
							userRepository.save(user);
						}
					}
					model.setStatus("success");
					model.setError("");
					model.setUser(user);
					chromedriver.close();
					return model;
				}
				else if (chromedriver.getTitle().equalsIgnoreCase("Amazon Sign In")) {
					WebElement email = driver.findElement(By.id("ap_email"));
					WebElement password = driver.findElement(By.id("ap_password"));
					WebElement loginBtn = driver.findElement(By.id("signInSubmit"));

					email.sendKeys(userId);
					password.sendKeys(pass);

					loginBtn.click();
					System.out.println("Title of the page is -> "
							+ driver.getTitle());
					
					if (chromedriver.getTitle().equalsIgnoreCase("Amazon Sign In")) {
						email = driver.findElement(By.id("ap_email"));
						password = driver.findElement(By.id("ap_password"));
						loginBtn = driver.findElement(By.id("signInSubmit"));
						if(email.isDisplayed())
							email.sendKeys(userId);
						password.sendKeys(pass);

						loginBtn.click();
						System.out.println("Title of the page is -> "
								+ driver.getTitle());
					}
					
					List<WebElement> es = chromedriver
							.findElementsByClassName("a-row");

					for (int i = 0; i < es.size(); i++) {

						WebElement e1 = es.get(i);
						if (e1.getText().equalsIgnoreCase("Name:"))
						{
							System.out.println("Element - "
								+ es.get(i + 1).getText());
							user.setName(es.get(i + 1).getText());
							userRepository.save(user);
						}
					}
					model.setStatus("success");
					model.setError("");
					model.setUser(user);
					chromedriver.close();
					return model;
				}
			}
			else
			{
				driver.get("https://www.amazon.in/ap/signin?openid.pape.preferred_auth_policies=http%3A%2F%2Fschemas.openid.net%2Fpape%2Fpolicies%2F2007%2F06%2Fmulti-factor-physical&openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fap%2Fcnep%3Fie%3DUTF8%26orig_return_to%3Dhttps%253A%252F%252Fwww.amazon.in%252Fyour-account%26openid.assoc_handle%3Dinflex%26pageId%3Dinflex&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&intercept=false&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
				System.out.println("Title of the page is -> " + driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Amazon Sign In")) {
					WebElement email = driver.findElement(By.id("ap_email"));
					WebElement password = driver.findElement(By.id("ap_password"));
					WebElement loginBtn = driver.findElement(By.id("signInSubmit"));

					email.sendKeys(userId);
					password.sendKeys(pass);
					//driver.setJavascriptEnabled(true);
					loginBtn.click();
					System.out.println("Title of the page is -> "
							+ driver.getTitle());
				}
				
				if(driver.getTitle().equalsIgnoreCase("Please Confirm your identity"))
				{
					System.out.println("OTP URL - " + driver.getCurrentUrl());
					if(!user.getOtprequired())
					{
						user.setUrl(driver.getCurrentUrl());
						user.setOtprequired(true);
						userRepository.save(user);
					}
					WebElement codeElement = driver.findElement(By.name("code"));
					WebElement continueElement = driver.findElement(By.className("a-button-input"));
					codeElement.sendKeys(otp);
					continueElement.click();
					System.out.println("Title of the page is -> "
							+ driver.getTitle());
				}
				
				user.setOtprequired(false);
				userRepository.save(user);

				List<WebElement> es = driver
						.findElementsByClassName("a-row");

				for (int i = 0; i < es.size(); i++) {

					WebElement e1 = es.get(i);
					if (e1.getText().equalsIgnoreCase("Name:"))
					{
						System.out.println("Element - "
							+ es.get(i + 1).getText());
						user.setName(es.get(i + 1).getText());
						userRepository.save(user);
					}
				}
				model.setStatus("success");
				model.setError("");
				model.setUser(user);
				driver.close();
				return model;
			}
			
		} catch (Exception e) {
			model.setStatus("failed");
			model.setError("");
			e.printStackTrace();
		}
		model.setUser(user);
		
		return model;

	}
	
	public static User getUser(String email, String password,UserRepository userRepository)
	{
		User t = userRepository.findByuserName(email);
		if(t != null)
		{
			t.setPassword(password);
			userRepository.save(t);
			return t;
		}
		else
		{
			t = new User();
			t.setUserName(email);
			t.setPassword(password);
			userRepository.save(t);
			return t;
		}
		
	}
}
