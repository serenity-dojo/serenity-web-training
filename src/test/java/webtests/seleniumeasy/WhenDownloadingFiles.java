package webtests.seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.configuration.SessionLocalTempDirectory;
import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import webtests.seleniumeasy.pageobjects.DownloadPage;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@RunWith(SerenityRunner.class)
public class WhenDownloadingFiles {

    @Managed
    WebDriver driver;

    DownloadPage downloadPage;

    @Test
    public void weCanDownloadAFileToOurHardDrive() throws InterruptedException {
        downloadPage.open();

        downloadPage.downloadSampleFile();

        File downloadedFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("sample.png").toFile();

        await().atMost(15, SECONDS).until(downloadedFile::exists);

        assertThat(downloadedFile).exists();

        assertThat(downloadedFile.getName()).isEqualTo("sample.png");
    }
}
