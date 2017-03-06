package com.maxifier.test.util.converters;

import com.maxifier.test.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DescriptionWithoutVowelsConverter implements Converter {

    private static final String VOWELS_STRING = "aeiouAEIOU";

    private static final Logger LOGGER = LoggerFactory.getLogger(DescriptionWithoutVowelsConverter.class);

    @Override
    public Entity convert(Entity entity) {
        LOGGER.info("Trying to update entity = {}", entity);
        String entityDescriptionBefore = entity.getDescription();
        String newEntityDescription = entityDescriptionBefore.replaceAll("[" + VOWELS_STRING + "]", "");
        entity.setDescription(newEntityDescription);
        LOGGER.info("Entity  = {} was updated", entity);
        return entity;
    }
}
