package com.maxifier.test.util.converters;

import com.maxifier.test.entity.Entity;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DescriptionWithoutVowelsConverterTest {

    Converter converter = new DescriptionWithoutVowelsConverter();

    @Test
    public void testConvert() throws Exception {
        String entityDescription = "NameAEIBzzOUiofugG";
        String expectedDescription = "NmBzzfgG";
        Entity entity = new Entity("name", entityDescription);
        converter.convert(entity);
        assertEquals(expectedDescription, entity.getDescription());
    }

}