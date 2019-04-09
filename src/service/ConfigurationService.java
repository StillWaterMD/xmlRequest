package service;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;

import java.io.File;
import java.io.IOException;

public class ConfigurationService {

    private final static String STORAGE = "src/data";
    private final  static Version VER = Configuration.VERSION_2_3_27;

    public static Configuration getConfiguration() throws IOException{

        Configuration cfg = new Configuration(VER);
            cfg.setDirectoryForTemplateLoading(new File(STORAGE));

        cfg.setDefaultEncoding("UTF-8");
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg;

    }


}
