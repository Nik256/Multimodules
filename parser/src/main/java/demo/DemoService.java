package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ConverterXMLJSON;
import service.ParserXML;
import service.ValidatorXML;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class DemoService {
    private static final Logger log = LogManager.getLogger(DemoService.class.getName());

    public void execute() {
        Properties properties = new Properties();
        File xmlFile = null;
        File xsdFile = null;
        File jsonFile = null;
        File resultXmlFile = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream("config.properties")) {
            properties.load(inputStream);
            xmlFile = new File(properties.getProperty("xml"));
            xsdFile = new File(properties.getProperty("xsd"));
            jsonFile = new File(properties.getProperty("json"));
            resultXmlFile = new File(properties.getProperty("result.xml"));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        ParserXML.showXMLStructure(xmlFile);
        log.info("XML is valid? " + ValidatorXML.validate(xmlFile, xsdFile));

        ConverterXMLJSON.convertXMLtoJSON(xmlFile.getPath(), jsonFile.getPath());
        ConverterXMLJSON.convertJSONtoXML(jsonFile.getPath(), resultXmlFile.getPath());
    }
}