package com.maxifier.test.service.impl;

import com.maxifier.test.entity.Entity;
import com.maxifier.test.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogEntityService implements EntityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogEntityService.class);

    public void update(Entity entity) {
        LOGGER.info("Entity with id = {} and name = {}  was updated", entity.getId(), entity.getName());
    }
}
