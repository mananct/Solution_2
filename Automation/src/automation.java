import java.time.DayOfWeek;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class automation extends BaseClass{
	private static org.openqa.selenium.WebElement webElement = null;
	
	  @Test(priority=1)
	  public void validateHomePageTitle() throws InterruptedException 
	  {
			String actualHomePageTitle = driver.getTitle();
			if (actualHomePageTitle.equals(Configuration.expectedHomePageTitle)) 
			{
			System.out.println("this is actual title :" + actualHomePageTitle);
			System.out.println("Title is correct ... !!!!");
			} 
			else 
			{
				Assert.fail("Please check title of HomePage, Title is wrong");
			}
	  }
	  
	  @Test(priority=2)
	  public void validateFindMeetingTitle() throws InterruptedException 
	  {
		  webElement = driver.findElement(By.xpath("//*[@id='ela-menu-visitor-desktop-supplementa_find-a-meeting']"));
		  webElement.click();
			String actualFindMeetingTitle = driver.getTitle();
			System.out.println("Title is correct ... !!!!" + actualFindMeetingTitle);
			
			if (actualFindMeetingTitle.equals(Configuration.expectedFindMeetingTitle)) 
			{
			System.out.println("this is actual title :" + actualFindMeetingTitle);
			System.out.println("Title is correct ... !!!!");
			} 
			else 
			{
				Assert.fail("Please check title of Find Meeting, Title is wrong");
			}
	  }
	  
	  @Test(priority=3)
	  public void validateMeetingZipCode() throws InterruptedException 
	  {
		  
		  // webElement - meeting search field
			webElement = driver.findElement(By.xpath("//*[@id='meetingSearch']"));
			webElement.sendKeys("10011");
			Thread.sleep(2000);
			
			// webElement - search button 
			webElement = driver.findElement(By.xpath("//*[@class='btn btn-default form-blue-pill__btn']"));
			webElement.click();
			Thread.sleep(2000);
			
			// webElement - first search result
			webElement = driver.findElement(By.xpath(
					"//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span"));
			String first_FindMeetingSearchResult = webElement.getText();
			System.out.println("First result from Find meeting : " + first_FindMeetingSearchResult);

			// webElement - first search result distance 
			webElement = driver.findElement(By.xpath(
					"//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[2]"));
			String first_FindMeetingDistance = webElement.getText();
			System.out.println("First result Distance  : " + first_FindMeetingDistance);
			
			// webElement - first search result
			webElement = driver.findElement(By.xpath(
					"//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span"));
			webElement.click();
			Thread.sleep(2000);
			
			// webElement - after you click on first search result 
			webElement = driver.findElement(By.xpath(
					"//*[@id='content']/div/div/ui-view/ui-view/div[1]/div/div/div[1]/div[2]/div[2]/div/location-address/div/div/div[1]/div/span"));
			
			String first_FindMeetingSearchResult_ClickOnLink = webElement.getText();
			
			
			if (first_FindMeetingSearchResult.equals(first_FindMeetingSearchResult_ClickOnLink)) 
			{
			System.out.println("Title of FindMeeting Distance first Link is correct ... !!!!");
			} 
			else 
			{
				Assert.fail("Title of FindMeeting Distance first Link is Not correct");
			}
			
			
			LocalDate date = LocalDate.now();
			DayOfWeek dayOfweek_actual = date.getDayOfWeek(); // SUNDAY 
			System.out.println("Today's day is : " + dayOfweek_actual); //sunday 
			
			Thread.sleep(2000);
			// rotate 7 days 
			for(int i = 1 ; i <= 7 ;i++) 
			{
				webElement = driver.findElement(By.xpath("//*[@id='content']/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/"+ "li["+i+"]/div/div[1]"));
				String dayOfWeek = webElement.getText() ;
				// dayOfWeek= sunday , monday 
				
				
				if(dayOfWeek.equalsIgnoreCase(dayOfweek_actual.toString())){
					webElement = driver.findElement(By.xpath("//*[@id='content']/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/"+ "li["+i+"]/div/div[2]"));
					System.out.println("Today's hours is : " + webElement.getText());
				
				}
			}
			
			
	  }
	  	
	}














