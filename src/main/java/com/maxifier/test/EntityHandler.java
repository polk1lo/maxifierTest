package com.maxifier.test;

import com.google.inject.Inject;
import com.maxifier.test.entity.Entity;
import com.maxifier.test.service.EntityService;
import com.maxifier.test.service.ThirdPartyService;
import com.maxifier.test.util.CsvHelper;
import com.maxifier.test.util.converters.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class EntityHandler implements Handler {

    private ThirdPartyService thirdPartyService;

    private EntityService entityService;

    private Converter converter;

    private CsvHelper csvHelper;

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityHandler.class);

    @Inject
    public EntityHandler(ThirdPartyService thirdPartyService, EntityService entityService, Converter converter) {
        this.thirdPartyService = thirdPartyService;
        this.entityService = entityService;
        this.converter = converter;
        this.csvHelper = new CsvHelper();
    }

    public void handle() {
        processEntities(parseEntitiesFromFiles());
    }

    private List<Entity> parseEntitiesFromFiles() {
        Set<String> fileNames = thirdPartyService.getFileNames();
        LOGGER.info("File names from thirdPartyService = {}", fileNames);
        List<Entity> entities = new ArrayList<>();
        for (String fileName : fileNames) {
            InputStream inputStream = thirdPartyService.getInputStream(fileName);
            entities.addAll(collectEntities(inputStream));
        }
        return entities;
    }

    /**
     * Collects entities from InputStream from File
     *
     * @param inputStream from File
     * @return List of collected entities
     */
    private List<Entity> collectEntities(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return csvHelper.collectEntities(inputStreamReader);
    }

    private void processEntities(List<Entity> entities) {
        for (Entity entity : entities) {
            LOGGER.info("Trying process {}", entity);
            converter.convert(entity);
            entityService.update(entity);
        }
    }
}
