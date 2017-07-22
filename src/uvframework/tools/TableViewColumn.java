
package uvframework.tools;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class TableViewColumn {
    String key;
    String title;
    public Boolean visible;
    public Double width;
    public Double maxWidth;
    public TVColumnType format;
    
    public TableViewColumn(String key,String title){
        this.key = key;
        this.title = title;
        this.visible = true;
        this.width = 100.00;
        this.maxWidth = 600.00;
        this.format = TVColumnType.STRING;
    }
    
    public TableViewColumn(String key,String title,TVColumnType type){
        this.key = key;
        this.title = title;
        this.visible = true;
        this.width = 100.00;
        this.maxWidth = 600.00;
        this.format = type;
    }
    
    public TableViewColumn(String key,String title,Boolean visible){
        this.key = key;
        this.title = title;
        this.visible = visible;
        this.width = 100.00;
        this.maxWidth = 600.00;
        this.format = TVColumnType.STRING;
    }
    
    public TableViewColumn(String key,String title,Boolean visible,TVColumnType type){
        this.key = key;
        this.title = title;
        this.visible = visible;
        this.width = 100.00;
        this.maxWidth = 600.00;
        this.format = type;
    }
    
    public TableViewColumn(String key,String title,Double width){
        this.key = key;
        this.title = title;
        this.visible = true;
        this.width = width;
        this.maxWidth = 600.00;
        this.format = TVColumnType.STRING;
    }
    
    public TableViewColumn(String key,String title,Double width, TVColumnType type){
        this.key = key;
        this.title = title;
        this.visible = true;
        this.width = width;
        this.maxWidth = 600.00;
        this.format = type;
    }
    
    public TableViewColumn(String key,String title,Double width, Double maxWidth){
        this.key = key;
        this.title = title;
        this.visible = true;
        this.width = width;
        this.maxWidth = maxWidth;
        this.format = TVColumnType.STRING;
    }
    
    public TableViewColumn(String key,String title,Double width, Double maxWidth, TVColumnType type){
        this.key = key;
        this.title = title;
        this.visible = true;
        this.width = width;
        this.maxWidth = maxWidth;
        this.format = type;
    }
    
    public String getKey(){
        return this.key;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getFormated(String unformated){
        switch(this.format){
            case STRING: return unformated; 
            case DATE: 
                Instant parsed = Instant.parse(unformated);
                return parsed.atZone(ZoneOffset.UTC).toLocalDate().toString();
            case MONEY: return Double.toString(Double.parseDouble(unformated));
            case DECIMAL: return Double.toString(Double.parseDouble(unformated));
            case OPTION: return unformated;
            default: return unformated;
        }
    }
    
    @Override
    public String toString(){
        return this.title;
    }
}
