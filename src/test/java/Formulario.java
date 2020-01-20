import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Formulario {
    public static AppiumDriver<MobileElement> mobDriver;
    DesiredCapabilities cap = new DesiredCapabilities();

    @Test
    public void Formulario() throws MalformedURLException {
        File appAndroid = new File("apks/app-curso.apk");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.APP, appAndroid.getAbsolutePath());
        cap.setCapability("autoGrantPermissions", true);
        mobDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
       // mobDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        mobDriver.findElement(By.xpath("//*[@text='Formulário']")).click();
        WebDriverWait wait = new WebDriverWait(mobDriver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='XBox One']")));
        mobDriver.findElement(MobileBy.AccessibilityId("console")).click();
        mobDriver.findElement(By.xpath("//*[@text='" + "PS4" + "']")).click();

    }




    @Before
    public void ExecutaAntes(){

    }

    @After
    public void ExecutaDepois(){

    }
}
