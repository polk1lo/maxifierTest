package com.maxifier.test.util;

import com.maxifier.test.entity.Entity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final Object[] HEADER = {"name", "description"};

    public static String getCurrentAbsolutePath() {
        Path currentPath = Paths.get("");
        return currentPath.toAbsolutePath().toString();
    }

    public static List<Entity> generateEntities(int numberOfGeneratedEntities) {
        List<Entity> entities = new ArrayList<>(numberOfGeneratedEntities);
        for (int i = 0; i < numberOfGeneratedEntities; i++) {
            Entity entity = new Entity("entityName" + i, "entityDescription" + i);
            entities.add(entity);
        }
        return entities;
    }

    @SuppressWarnings("unchecked")
    public static void generateFilesOfEntities(String path, int numberOfGeneratedFiles, int numberOfGeneratedEntitiesInFile) {
        try {
            FileWriter fileWriter;
            CSVPrinter csvPrinter;
            for (int i = 0; i < numberOfGeneratedFiles; i++) {
                fileWriter = new FileWriter(path + i);
                CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
                csvPrinter = new CSVPrinter(fileWriter, csvFileFormat);
                csvPrinter.printRecord(HEADER);
                for (Entity entity : generateEntities(numberOfGeneratedEntitiesInFile)) {
                    List<String> entityRecord = new ArrayList();
                    entityRecord.add(entity.getName());
                    entityRecord.add(entity.getDescription());
                    csvPrinter.printRecord(entityRecord);
                }
                fileWriter.flush();
                fileWriter.close();
                csvPrinter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
