package JDI.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParseJson {

    private static String filename = "src/main/resources/JDI_ex8_metalsColorsDataSet.json";

    public static Datas parseJson() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
        Datas data = gson.fromJson(reader, Datas.class);
        return data;
    }
}
