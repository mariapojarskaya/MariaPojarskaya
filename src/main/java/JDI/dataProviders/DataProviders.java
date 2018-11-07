package JDI.dataProviders;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

import static JDI.utils.ParseJson.parseJson;

public class DataProviders {

    @DataProvider
    public Object[][] dataProviders() throws FileNotFoundException {
        return new Object[][]{
                {parseJson().getData_1()},
                {parseJson().getData_2()},
                {parseJson().getData_3()},
                {parseJson().getData_4()},
                {parseJson().getData_5()}
        };
    }
}
