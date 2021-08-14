package webtests.seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.configuration.SessionLocalTempDirectory;
import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import webtests.seleniumeasy.pageobjects.DownloadPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
@WithTag("local")
public class WhenDownloadingFiles {

    @Managed
    WebDriver driver;

    DownloadPage downloadPage;

    @Test
    public void weCanDownloadAFileToOurHardDrive() {

        downloadPage.open();

        // Download a file
        downloadPage.downloadSamplePngFile();

        // Identify the temporary download directory
        File downloadedFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("sample.png").toFile();

        // Wait for the file to download
        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(downloadedFile::exists);

        // Check that the file exists
        assertThat(downloadedFile).exists();
    }
}
