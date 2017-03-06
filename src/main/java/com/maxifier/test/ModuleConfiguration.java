package com.maxifier.test;

import com.google.inject.Module;
import com.maxifier.test.service.EntityService;
import com.maxifier.test.service.ThirdPartyService;
import com.maxifier.test.service.impl.LocalThirdPartyService;
import com.maxifier.test.service.impl.LogEntityService;
import com.maxifier.test.util.converters.Converter;
import com.maxifier.test.util.converters.NameInUpperCaseConverter;

public class ModuleConfiguration implements Module {

    public void configure(com.google.inject.Binder binder) {
        binder.bind(EntityService.class).to(LogEntityService.class);
        binder.bind(ThirdPartyService.class).to(LocalThirdPartyService.class);
        binder.bind(Converter.class).to(NameInUpperCaseConverter.class);
        binder.bind(Handler.class).to(EntityHandler.class);
    }
}
