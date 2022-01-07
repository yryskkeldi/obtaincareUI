package com.obtaincare.UI.methods;

import org.openqa.selenium.WebDriver;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

	private WebDriver driver;

	public BrowserHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void goForward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandles());

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandles());
		driver.switchTo().window(windowsId.get(0));
	}

	public void switchToParentWithChildClose() {
		switchToParentWindow();

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandles());

		for (int i = 1; i < windowsId.size(); i++) {
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}
		switchToParentWindow();
	}

	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

}