package Testing;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertyFileTest {
    @Test
    void propertyFile() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./src/test/resources/Test.property"));
        if(properties.isEmpty()) return;
        Set<Object> keys = properties.keySet();
        Map <Object, Object> map = new LinkedHashMap<>();
        for(Object key : keys){
            Object value = properties.get(key);
            if(key.equals("Age")){
                properties.setProperty((String) key,"26");
            }
            map.put(key,value);
        }
        System.out.println(map);
        System.out.println(properties.getProperty("Age"));
    }
}
