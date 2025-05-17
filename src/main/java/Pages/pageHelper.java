package Pages;

import CommonAssertions.CommonAssertions;
import Utilities.Actions;
import Utilities.jsonReader;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class pageHelper extends pageElements {
    Actions actions = new Actions();
    public void assertGoogleHomePage()
    {
        CommonAssertions.assertElementDisplayed(googleSearchButton);
    }
    public void changeLanguage()
    {
        actions.click(language);
    }
    public void searchFor()
    {
        actions.type((jsonReader.getValueFromJson(fileName,"searchText")),searchBar);
    }


    public void searchForMercedesSpecs() {
        int paginationCount = 0;
        int resultIndex = 0;
        boolean found = false;

        while (true) {
            List<WebElement> results = actions.listOfElements(searchResults);

            for (int i = 0; i < results.size(); i++) {
                String text = results.get(i).getText().toLowerCase();
                if(text.contains("engine") || text.contains("horsepower")|| text.contains("Specs")) {
                    resultIndex = i + 1; // Convert to 1-based index
                    found = true;
                    break;
                }
            }

            if (found) break;

            if (!found) {
               Actions.scrollToEachElement(results);
                Actions.click(nextButton);
                paginationCount++;
                try {
                    Thread.sleep(2000); // Wait for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("ResultIndex", resultIndex);
        result.put("PaginationCount", paginationCount);
        System.out.println("Found keyword in result #" + resultIndex);
        System.out.println("Pagination (Next): " + paginationCount);

    }


}
