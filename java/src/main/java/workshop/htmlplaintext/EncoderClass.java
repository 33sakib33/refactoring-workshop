package workshop.htmlplaintext;

import java.util.ArrayList;
import java.util.List;

public class EncoderClass {
    private List<Patternyzer2> converterList;
    EncoderClass( List<Patternyzer2> converterList ){
        this.converterList=converterList;
    }
    public String basicHtmlEncode(String source) {
        List<String> result;
        result = new ArrayList<>();
        String[] charArray=source.split("");
        for(String charItr : charArray){
            String temp=charItr;
            for(Patternyzer2 converterItr: converterList){
                if(converterItr.doesMatch(charItr)){
                    temp= converterItr.patternReturner();
                    break;
                }
            }
            result.add(temp);
        }
        return String.join("<br />", result);
    }
}
