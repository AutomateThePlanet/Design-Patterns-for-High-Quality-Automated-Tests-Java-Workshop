/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pages.v5.singlefilepageobjectnavibasepagesections;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseTestsWithPageObjects {
    private Driver driver;
    private static MainPage mainPage;
    private static CartPage cartPage;

    @BeforeMethod
    public void testInit() {
        driver = new LoggingDriver(new WebCoreDriver());
        driver.start(Browser.CHROME);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        driver.quit();
    }

    @Test(priority = 1)
    public void completePurchaseSuccessfully_whenNewClient() throws InterruptedException {
        mainPage.addRocketToShoppingCart();
        cartPage.applyCoupon("happybirthday");

        Assert.assertEquals(cartPage.getMessageNotification(), "Coupon code applied successfully.");

        cartPage.increaseProductQuantity(2);

        Assert.assertEquals("114.00€", cartPage.getTotal());

        cartPage.clickProceedToCheckout();

        var receivedMessage = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(receivedMessage.getText(), "Checkout");
    }

    private String GetUserPasswordFromDb(String userName) {
        return "@purISQzt%%DYBnLCIhaoG6$";
    }
}