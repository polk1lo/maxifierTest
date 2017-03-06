package com.maxifier.test.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public interface ThirdPartyService {

    Set<String> getFileNames();

    InputStream getInputStream(String fileName);
}
