package com.maxifier.test.service.impl;

import com.maxifier.test.service.ThirdPartyService;
import com.maxifier.test.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class LocalThirdPartyService implements ThirdPartyService {

    private static Logger LOGGER = LoggerFactory.getLogger(LocalThirdPartyService.class);

    private String directoryPath = "\\csvFiles";

    public Set<String> getFileNames() {
        Set<String> fileNames = new HashSet<>();
        File directory = new File(Utils.getCurrentAbsolutePath() + directoryPath);
        for (final File fileEntry : directory.listFiles()) {
            if (fileEntry.isFile()) {
                fileNames.add(fileEntry.getName());
            }
        }
        return fileNames;
    }

    public InputStream getInputStream(String fileName) {
        File directory = new File(Utils.getCurrentAbsolutePath() + directoryPath);
        for (final File fileEntry : directory.listFiles()) {
            if (fileEntry.isFile() && fileEntry.getName().equals(fileName)) {
                try {
                    return new FileInputStream(fileEntry);
                } catch (FileNotFoundException e) {
                    LOGGER.error("File with name {} not founded in local directory", fileEntry.getName());
                    throw new RuntimeException(e);
                }
            }
        }
        throw new RuntimeException("File with name" + fileName + "not founded in local directory");
    }

    String getDirectoryPath() {
        return directoryPath;
    }

    void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }
}
