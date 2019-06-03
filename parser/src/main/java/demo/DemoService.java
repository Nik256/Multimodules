package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ConverterXMLJSON;
import service.ParserXML;
import service.ValidatorXML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DemoService {
    private static final Logger log = LogManager.getLogger(DemoService.class.getName());

    public void execute() {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream("config.properties")) {
            properties.load(inputStream);
            File xmlFile = new File(properties.getProperty("xml"));
            File xsdFile = new File(properties.getProperty("xsd"));
            File jsonFile = new File(properties.getProperty("json"));
            File resultXmlFile = new File(properties.getProperty("resultXml"));

            ParserXML.showXMLStructure(xmlFile);
            log.info("XML is valid? " + ValidatorXML.validate(xmlFile, xsdFile));

            ConverterXMLJSON.convertXMLtoJSON(xmlFile.getPath(), jsonFile.getPath());
            ConverterXMLJSON.convertJSONtoXML(jsonFile.getPath(), resultXmlFile.getPath());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}