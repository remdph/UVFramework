
package uvframework.tools;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class TableViewRow extends HashMap {
    
    public void addField(String key, Object value){
        this.put(key, value.toString());
    }
    
    public JSONObject toJSONObject(){
        JSONObject jrow = new JSONObject();
        
        Iterator keys = this.keySet().iterator();
        while(keys.hasNext()){
            String key = (String) keys.next();
            String value = this.get(key).toString();
            jrow.put(key, value);
        }

        return jrow;
    }
}
