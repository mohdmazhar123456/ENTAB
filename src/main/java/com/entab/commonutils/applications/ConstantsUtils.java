package com.entab.commonutils.applications;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;


public class ConstantsUtils {

    private static ConstantsUtils constants;
    private static Properties props = null;
    private static final String ENV_FILE_PATH = System.getProperty("user.dir");
    private static final String PROPERTIES_FILE_PATH = ENV_FILE_PATH + "/src/main/resources/properties/";
    private static final String PROPERTIES_ENV_PATH = PROPERTIES_FILE_PATH + "sit" + ".properties";
    private static final String COMMON_PROPERTIES_PATH = PROPERTIES_FILE_PATH + "common.properties";
    private static final List<String> fileList = Arrays.asList(PROPERTIES_ENV_PATH,COMMON_PROPERTIES_PATH);

    private ConstantsUtils() {
        props = new Properties();
        fileList.forEach(file -> {
            Scanner inFile;
            try {
                inFile = new Scanner(new FileReader(file));
                inFile.next();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try {
                InputStream input = Files.newInputStream(Paths.get(file));
                props.load(input);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public static ConstantsUtils getInstance() {
        if (constants == null) {
            constants = new ConstantsUtils();
        }
        return constants;
    }

    public String getValue(String key) {
        return props.getProperty(key);
    }
}
