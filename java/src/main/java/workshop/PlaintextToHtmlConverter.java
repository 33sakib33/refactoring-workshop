package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    private ReadFromFile readerField;
    private String pathField;
    private EncoderClass encodeField;
    PlaintextToHtmlConverter(String pathParam, EncoderClass encodeField){
        this.pathField=pathParam;
        this.encodeField=encodeField;
        readerField = new ReadFromFile(getPathField());
    }
    public String getPathField() {
        return pathField;
    }

    public ReadFromFile getReaderField() {
        return readerField;
    }

    public void setReaderField(ReadFromFile readerField) {
        this.readerField = readerField;
    }

    public void setPathField(String pathField) {
        this.pathField = pathField;
    }

    public String toHtml() throws Exception {
        String input=readerField.read();
        String htmlLines = encodeField.basicHtmlEncode(input);
        return htmlLines;
    }
}
