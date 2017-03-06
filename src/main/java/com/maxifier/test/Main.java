package com.maxifier.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.maxifier.test.util.FileGenerator;

public class Main {
    public static void main(String[] args) {
        FileGenerator.generateCsvFiles();
        Injector service = Guice.createInjector(new ModuleConfiguration());
        Handler handler = service.getInstance(Handler.class);
        handler.handle();
    }
}
