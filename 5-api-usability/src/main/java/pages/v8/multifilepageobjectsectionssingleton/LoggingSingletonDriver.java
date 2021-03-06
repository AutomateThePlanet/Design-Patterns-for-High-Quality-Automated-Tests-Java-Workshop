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

package pages.v8.multifilepageobjectsectionssingleton;

import core.*;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Optional;

public class LoggingSingletonDriver extends DriverDecorator {
    private static LoggingSingletonDriver instance;

    private LoggingSingletonDriver(Driver driver) {
        super(driver);
    }

    public static LoggingSingletonDriver getInstance() {
        if (instance == null) {
            instance = new LoggingSingletonDriver(new WebCoreDriver());
        }

        return instance;
    }

    @Override
    public void start(Browser browser) {
        System.out.printf("start browser = %s", browser.name());
        driver.start(browser);
    }

    @Override
    public void quit() {
        System.out.println("close browser");
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        System.out.printf("go to url = %s", url);
        driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        System.out.println("find element");
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        System.out.println("find elements");
        return driver.findElements(locator);
    }
}
