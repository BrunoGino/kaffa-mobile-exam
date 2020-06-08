package questionone;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class CNPJValidator {

    public boolean isCnpjValid(CNPJ cnpj){
        return false;
    }

    public String applyMask(CNPJ cnpj) {
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##.###.###/####-##");
            maskFormatter.setValueContainsLiteralCharacters(true);
            return maskFormatter.valueToString(cnpj.getValue());
        } catch (ParseException e) {
            e.printStackTrace();
            return "Could not parse CNPJ, please check its text";
        }
    }
}
