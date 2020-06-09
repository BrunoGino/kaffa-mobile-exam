package questionone.utils;

import java.util.ArrayList;
import java.util.List;

public class CNPJUtils {
    public  List<String> parseArrayOfCharsAsListOfString(String value) {
        List<String> characters = new ArrayList<>();
        char[] chars = value.toCharArray();
        for (char aChar : chars) {
            characters.add(String.valueOf(aChar));
        }
        return characters;
    }
}
