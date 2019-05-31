package service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entity.pojo.Goods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ConverterXMLJSON {
    private static final Logger log = LogManager.getLogger(ConverterXMLJSON.class.getName());

    private ConverterXMLJSON() {
    }

    public static void convertXMLtoJSON(String filePathXML, String filePathJSON) {
        String data = readFileToString(filePathXML);
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        try {
            Goods goods = xmlMapper.readValue(data, Goods.class);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
            objectMapper.writeValue(new File(filePathJSON), goods);
            log.info("Converting xml -> json completed");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void convertJSONtoXML(String filePathJSON, String filePathXML) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        try {
            Goods goods = objectMapper.readValue(new File(filePathJSON), Goods.class);
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(filePathXML), goods);
            log.info("Converting json -> xml completed");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private static String readFileToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return contentBuilder.toString();
    }
}
