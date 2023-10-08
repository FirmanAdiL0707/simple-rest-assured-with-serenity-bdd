package stepDefinitions.common;

import java.util.HashMap;
import java.util.Map;

public class CommonHeaders {
    
    public static Map<String, String> addBasicHeader() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Content-Type", "application/json");
        
        return params;
    }
}
