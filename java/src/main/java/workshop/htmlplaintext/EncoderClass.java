package workshop.htmlplaintext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncoderClass {
    private List<PatternMatcherForHTML> converterList;
    public EncoderClass( List<PatternMatcherForHTML> converterList ){
        this.converterList=converterList;
    }
    public String basicHtmlEncode(String source) {
        List<String> result;
        result = new ArrayList<>();
        List<String> charArray=Arrays.asList(source.split(""));
        for(String charItr : charArray){
            String temp=charItr;
            for(PatternMatcherForHTML converterItr: converterList){
                if(converterItr.doesMatch(charItr)){
                    temp= converterItr.patternReturner();
                    break;
                }
            }
            result.add(temp);
        }
        return String.join("", result);
    }
}
