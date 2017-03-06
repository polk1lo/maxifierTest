package com.maxifier.test.util;

import com.google.common.collect.Lists;
import com.maxifier.test.entity.Entity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CsvHelper {

    private final static int NAME_INDEX = 0;
    private final static int DESCRIPTION_INDEX = 1;

    private AtomicInteger idGen = new AtomicInteger(0);

    public List<Entity> collectEntities(Reader reader) {
        return getRecords(reader)
                .stream()
                .skip(1)
                .map(this::processCsvRecord)
                .collect(Collectors.toList());
    }

    private List<CSVRecord> getRecords(Reader in) {
        try {
            CSVParser parser = CSVFormat.EXCEL.parse(in);
            return Lists.newArrayList(parser);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Entity processCsvRecord(CSVRecord csvRecord) {
        Entity entity = new Entity();
        entity.setId(idGen.incrementAndGet());
        entity.setName(csvRecord.get(NAME_INDEX));
        entity.setDescription(csvRecord.get(DESCRIPTION_INDEX));
        return entity;
    }

}
