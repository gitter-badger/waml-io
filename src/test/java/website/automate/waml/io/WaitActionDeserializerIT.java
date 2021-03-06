package website.automate.waml.io;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.WaitAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static website.automate.waml.io.model.CriterionValue.of;

public class WaitActionDeserializerIT extends DeserializerBase {

    @Test
    public void waitActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream waitAction = getSystemResourceAsStream("./website/automate/waml/io/wait-action.yaml");
        Action action = mapper.readValue(waitAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof WaitAction);
        WaitAction actualWaitAction = WaitAction.class.cast(action);
        assertThat(actualWaitAction.getTime(), is(of(new Integer(100))));
        assertThat(actualWaitAction.getWhen(), is("${isDesktop}"));
        assertThat(actualWaitAction.getUnless(), is("${isMobile}"));
    }
    
    @Test
    public void waitActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream waitAction = getSystemResourceAsStream("./website/automate/waml/io/wait-action-short-notation.yaml");
        Action action = mapper.readValue(waitAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof WaitAction);
        WaitAction actualWaitAction = WaitAction.class.cast(action);
        assertThat(actualWaitAction.getTime(), is(of(new Integer(100))));
    }
}
