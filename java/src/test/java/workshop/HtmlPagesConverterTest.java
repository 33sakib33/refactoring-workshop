package workshop;

import org.junit.Test;
import workshop.htmlplaintext.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlPagesConverterTest {
    PatternMatcherForHTML obj1= new ForNewLine();
    PatternMatcherForHTML obj2= new ForAmp();
    PatternMatcherForHTML obj3= new ForGreaterThan();
    PatternMatcherForHTML obj4= new ForLessThan();
    List<PatternMatcherForHTML> aList = new ArrayList<>();
    ReaderClass readerObj= new ReaderClass("sample.txt");
    EncoderClass encoderObj= new EncoderClass(aList);
    void initiate(){

    }
    PlaintextToHtmlConverterFake converter;

    @Test
    public void charConversion() throws Exception {
        aList.add(obj1);
        aList.add(obj2);
        aList.add(obj3);
        aList.add(obj4);
        PlaintextToHtmlConverterFake converter = new PlaintextToHtmlConverterFake(encoderObj);
        converter.setRead("<");
        assertEquals("&lt;", converter.toHtml());

        converter.setRead(">");
        assertEquals("&gt;", converter.toHtml());

        converter.setRead("&");
        assertEquals("&amp;", converter.toHtml());

        converter.setRead("\n");
        assertEquals("<br />", converter.toHtml());
    }

    @Test
    public void noConversion() throws Exception {
        aList.add(obj1);
        aList.add(obj2);
        aList.add(obj3);
        aList.add(obj4);
        PlaintextToHtmlConverterFake converter = new PlaintextToHtmlConverterFake(encoderObj);
        converter.setRead("simple");
        assertEquals("simple", converter.toHtml());
    }

    @Test
    public void mixedCharConversion() throws Exception {
        aList.add(obj1);
        aList.add(obj2);
        aList.add(obj3);
        aList.add(obj4);
        PlaintextToHtmlConverterFake converter = new PlaintextToHtmlConverterFake(encoderObj);
        converter.setRead("<small>\n&space");
        assertEquals("&lt;small&gt;<br />&amp;space", converter.toHtml());
    }

    class PlaintextToHtmlConverterFake extends PlaintextToHtmlConverter {
        String text;

        public PlaintextToHtmlConverterFake( EncoderClass encodeField) {
            super(encodeField);
        }

        public void setRead(String text) {
            this.text = text;
        }
        @Override
        public String read() throws IOException {
            return text;
        }
    }
}
