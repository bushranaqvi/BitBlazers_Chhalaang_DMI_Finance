package com.DmiFinance.BitBlazers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonXmlParser {

    public static void tryfunc() {
        System.out.println("checking try function");
    }

    public static void readFiles() throws IOException {
        File folder = new File("D:\\Intellij_Projects\\BitBlazers\\uploads");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                // Process the file

                // Dynamic Json parsing without creating class
                ObjectMapper jsonMapper = new ObjectMapper();

                Map<String, Object> data1 = jsonMapper.readValue(file, Map.class);
                String jsonString1 = jsonMapper.writeValueAsString(data1);

                boolean ans1= isValid(jsonString1);
                System.out.println(file.getName()); // Example
                System.out.println("json is "+ans1);

            }
        }
    }


    public static boolean isValid(String json){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.readTree(json);

        }
        catch(JacksonException e){
            return false;
        }
        return true;
    }


}