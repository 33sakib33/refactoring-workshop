package workshop;

import org.junit.Test;
import workshop.htmlplaintext.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlPagesConverterIntegrationTest {
    @Test
    public void convertFromActualFile() throws Exception {
        PatternMatcherForHTML obj1= new ForNewLine();
        PatternMatcherForHTML obj2= new ForAmp();
        PatternMatcherForHTML obj3= new ForGreaterThan();
        PatternMatcherForHTML obj4= new ForLessThan();
        List<PatternMatcherForHTML> aList = new ArrayList<>();
        aList.add(obj1);
        aList.add(obj2);
        aList.add(obj3);
        aList.add(obj4);
        EncoderClass encoderObj= new EncoderClass(aList);
        PlaintextToHtmlConverter converter = new PlaintextToHtmlConverter(encoderObj);
        assertEquals("abc&lt;hello&gt;", converter.toHtml());
    }
}
