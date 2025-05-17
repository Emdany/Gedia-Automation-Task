package Pages;

import org.openqa.selenium.By;

public class pageElements {
    String fileName="JsonFIle/Data.json";
    By searchBar= By.xpath("//textarea[@title=\"Search\" and @id=\"APjFqb\"]");
    By language =By.xpath("//a[contains(text(), \"English\")]");
    By googleSearchButton=By.xpath("(//input[@value=\"Google Search\"and @aria-label=\"Google Search\"])[2]");
    By searchResults=By.xpath("//div[@class=\"MjjYud\"]");
    By nextButton=By.xpath("//span[contains(text(),\"Next\")]");
}
