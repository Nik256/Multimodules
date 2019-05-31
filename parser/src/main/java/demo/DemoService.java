package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ConverterXMLJSON;
import service.ParserXML;
import service.ValidatorXML;

import java.io.File;

public class DemoService {
    private static final Logger log = LogManager.getLogger(DemoService.class.getName());

    private DemoService() {
    }

    public static void execute() {
        File xml = new File("src/parser/resources/goods.xml");
        ParserXML.showXMLStructure(xml);

        File xsd = new File("src/parser/resources/goods.xsd");
        log.info("XML is valid? " + ValidatorXML.validate(xml, xsd));

        File json = new File("src/parser/resources/converted/goods.json");
        ConverterXMLJSON.convertXMLtoJSON(xml.getPath(), json.getPath());
        ConverterXMLJSON.convertJSONtoXML(json.getPath(), "src/parser/resources/converted/goods.xml");
    }
}
