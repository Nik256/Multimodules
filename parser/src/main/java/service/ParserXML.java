package service;

import entity.pojo.Goods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ParserXML {
    private static final Logger log = LogManager.getLogger(ParserXML.class.getName());

    private ParserXML() {
    }

    public static void showXMLStructure(File xmlFile) {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFile));

            JAXBContext context = JAXBContext.newInstance(Goods.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<Goods> jb = unmarshaller.unmarshal(xmlEventReader, Goods.class);
            Goods goods = jb.getValue();
            log.info(goods.toString());
        } catch (JAXBException | XMLStreamException | FileNotFoundException e) {
            log.error(e.getMessage());
        }
    }
}