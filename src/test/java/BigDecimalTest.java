import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BigDecimalTest {

    ObjectMapper mapper = new ObjectMapper();
    BigDecimal expected = BigDecimal.valueOf(0.05);

    @Test
    public void shouldDeserializeBigDecimalFromJacksonCore() {

        BigDecimal actualFromJacksonCore = NumberInput.parseBigDecimal(".05", true);
        assertEquals(expected, actualFromJacksonCore);
    }

    @Test
    public void shouldDeserializeBigDecimalFromJacksonDataBind() throws JsonProcessingException {

        BigDecimal actualFromJacksonDataBind = mapper.readValue("""
                                                                        {"value":".05"}
                                                                        """, TestDTO.class).getValue();
        assertEquals(expected, actualFromJacksonDataBind);
    }

}
