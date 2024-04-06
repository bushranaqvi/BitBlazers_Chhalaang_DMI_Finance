package com.DmiFinance.BitBlazers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

import static com.DmiFinance.BitBlazers.JsonXmlParser.readFiles;
import static com.DmiFinance.BitBlazers.JsonXmlParser.tryfunc;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.multipart.support.*
//commons.CommonsMultipartResolver;


@SpringBootApplication
@RestController
public class BitBlazersApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BitBlazersApplication.class, args);
        System.out.println("Helloo DMI Finance");

        tryfunc();

    }


    @RequestMapping("/qwerty")
    public String q() {
        return "QWERTY is working  cool";
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "Holla!";
    }

    @PostMapping("/text")
    public String processText(@RequestBody String text) {
        // Process the received text
        return "You sent: " + text;
    }

    @PostMapping("/getJson")
    public Map<String, ?> processJson(@RequestBody Map<String, ?> text) {
        // Process the received text
        return text;
    }

}
