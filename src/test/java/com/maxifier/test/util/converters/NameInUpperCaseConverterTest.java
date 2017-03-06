package com.maxifier.test.util.converters;

import com.maxifier.test.entity.Entity;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NameInUpperCaseConverterTest {

    Converter converter = new NameInUpperCaseConverter();

    @Test
    public void testConvert() throws Exception {
        String entityName = "entityName";
        String expectedEntityName = "ENTITYNAME";
        Entity entity = new Entity(entityName, "Descr");
        converter.convert(entity);
        assertEquals(entity.getName(), expectedEntityName);
    }

}