package infoClasses;

import freemarker.core.ParseException;
import freemarker.template.*;
import service.ConfigurationService;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

public class Request {


    private String request;

    private Template template;

    public String getRequest() {

        return this.request;

    }

    public Template getTemplate() {

        return this.template;

    }

    public Request(String template, HashMap<String, String> params) throws IOException, TemplateException {

        Configuration config = ConfigurationService.getConfiguration();
        this.template = config.getTemplate(template);
        StringWriter sw = new StringWriter();
        this.template.process(params, sw);
        this.request = sw.toString();


    }
}
