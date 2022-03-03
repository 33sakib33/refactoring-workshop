package workshop.htmlplaintext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/*** Removed conditionals with polymorphism
 Removed primitive obsession, removed some redundant code
Fixed a large class*/
public class PlaintextToHtmlConverter {
    private EncoderClass encodeField;
    public PlaintextToHtmlConverter(EncoderClass encodeField){
        this.encodeField=encodeField;

    }
    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    public String toHtml() throws Exception {
        return encodeField.basicHtmlEncode(read());
    }
}
