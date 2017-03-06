package com.maxifier.test.service.impl;

import com.maxifier.test.entity.Entity;
import com.maxifier.test.util.CsvHelper;
import com.maxifier.test.util.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LocalThirdPartyServiceTest {

    private static final int NUMBER_OF_ENTITIES = 10;
    private static final String FILE_NAME = "testEntities";
    private static final String TESTING_DIR = "\\testingDir\\";

    private LocalThirdPartyService thirdPartyService = new LocalThirdPartyService();

    private CsvHelper csvHelper = new CsvHelper();

    @BeforeMethod
    public void setUp() throws Exception {
        Utils.generateFilesOfEntities(Utils.getCurrentAbsolutePath() + TESTING_DIR + FILE_NAME, 1, NUMBER_OF_ENTITIES);
        thirdPartyService.setDirectoryPath(TESTING_DIR);
    }

    @Test
    public void testGetFileNames() throws Exception {
        Set<String> fileNames = thirdPartyService.getFileNames();
        assertEquals(fileNames.size(), 1);
        assertTrue(fileNames.contains(FILE_NAME + 0));
    }

    @Test
    public void testGetInputStream() throws Exception {
        Set<String> fileNames = thirdPartyService.getFileNames();
        InputStreamReader inputStream = new InputStreamReader(thirdPartyService.getInputStream(fileNames.iterator().next()));
        List<Entity> actualEntities = csvHelper.collectEntities(inputStream);
        assertEquals(actualEntities.size(), NUMBER_OF_ENTITIES);
    }

}