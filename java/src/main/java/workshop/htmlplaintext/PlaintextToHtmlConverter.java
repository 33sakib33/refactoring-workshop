package workshop.htmlplaintext;

import workshop.Trivia.ReadFromFile;

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
        return encodeField.basicHtmlEncode(input);
    }
}
