package com.maxifier.test.util.converters;

import com.maxifier.test.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NameInUpperCaseConverter implements Converter {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameInUpperCaseConverter.class);

    @Override
    public Entity convert(Entity entity) {
        LOGGER.info("Trying to update entity = {}", entity);
        entity.setName(entity.getName().toUpperCase());
        LOGGER.info("Entity  = {} was updated", entity);
        return entity;
    }

}
