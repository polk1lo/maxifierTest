package com.maxifier.test.util;

public class FileGenerator {

    private static final int NUMBER_OF_ENTITIES = 100;
    private static final String FILE_NAME = "csvEntities";
    private static final String CSV_FILES_FOLDER_NAME = "\\csvFiles\\";
    private static final int NUMBER_OF_GENERATED_FILES = 3;

    public static void generateCsvFiles() {
        Utils.generateFilesOfEntities(Utils.getCurrentAbsolutePath() + CSV_FILES_FOLDER_NAME + FILE_NAME, NUMBER_OF_GENERATED_FILES, NUMBER_OF_ENTITIES);
    }
}
