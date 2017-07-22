
package uvframework.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class TableViewAdapter {
    
    private final TableView wt;
    private Consumer RowDoubleClickHandler = e->{};
    private Consumer RowClickHandler = e->{};
    
    
    public TableViewAdapter(TableView table){
        this.wt = table;
    }
    
    public void setRowDoubleClickHandler(Consumer RowDoubleClickHandler){
        this.RowDoubleClickHandler = RowDoubleClickHandler;
    }
    
    public void setRowClickHandler(Consumer RowClickHandler){
        this.RowClickHandler = RowClickHandler;
    }
    
    public ArrayList toArrayList(){
        ArrayList arrTable = new ArrayList();
        Iterator rows = this.wt.getItems().iterator();
        
        while(rows.hasNext()){
            TableViewRow row = (TableViewRow) rows.next();
            arrTable.add(row);
        }
        
        return arrTable;
    }
    
    public JSONArray toJSONArray(){
        JSONArray jtable = new JSONArray();
        
        Iterator rows = this.wt.getItems().iterator();
        
        while(rows.hasNext()){
            TableViewRow row = (TableViewRow) rows.next();
            jtable.put(row.toJSONObject());
        }

        return jtable;
    }
    
    public void fromArrayList(ArrayList<Map> data, ArrayList<TableViewColumn> titles){
        this.wt.getColumns().clear();
        this.wt.getItems().clear();
        Iterator columns = titles.iterator();

        //Añadimos Columnas
        if(titles.size() > 0){
            while(columns.hasNext()){
                TableViewColumn column = (TableViewColumn) columns.next();
                this.addColumn(column);
            }
        }

        if(data.size() > 0){
            
            Iterator rows = data.iterator();

            //Añadimos Lineas
            while(rows.hasNext()){
                columns = titles.iterator();
                Map jrow = (Map) rows.next();
                TableViewRow row = new TableViewRow();
                
                while(columns.hasNext()){
                    TableViewColumn column = (TableViewColumn) columns.next();
                    String content = column.getFormated(jrow.get(column.getKey()).toString());
                    row.addField(column.getKey(),content);
                }
                
                this.addRow(row);
            }
            
            wt.setRowFactory(tv -> {
                TableRow<Map> row = new TableRow<>();
                
                row.setOnMouseClicked(e ->  {
                    if(e.getClickCount() == 2){
                        this.RowDoubleClickHandler.accept(e);
                    }
                    
                    if(e.getClickCount() == 1){
                        this.RowClickHandler.accept(e);
                    }
                });
                
                
                return row;
            });
        }
    }
    
    public void fromJSONArray(JSONArray data, ArrayList<TableViewColumn> titles){
        this.wt.getColumns().clear();
        this.wt.getItems().clear();
        Iterator columns = titles.iterator();

        //Añadimos Columnas
        if(titles.size() > 0){
            while(columns.hasNext()){
                TableViewColumn column = (TableViewColumn) columns.next();
                this.addColumn(column);
            }
        }

        if(data.length() > 0){
            Iterator rows = data.iterator();
            
            //Añadimos Lineas
            while(rows.hasNext()){
                columns = titles.iterator();
                JSONObject jrow = (JSONObject) rows.next();
                TableViewRow row = new TableViewRow();
                
                while(columns.hasNext()){
                    TableViewColumn column = (TableViewColumn) columns.next();
                    String content = column.getFormated(jrow.get(column.getKey()).toString());
                    row.addField(column.getKey(),content);
                }
                
                this.addRow(row);
            }
            
            wt.setRowFactory(tv -> {
                TableRow<Map> row = new TableRow<>();
                
                row.setOnMouseClicked(e ->  {
                    if(e.getClickCount() == 2){
                        this.RowDoubleClickHandler.accept(e);
                    }
                    
                    if(e.getClickCount() == 1){
                        this.RowClickHandler.accept(e);
                    }
                });
                
                return row;
            });
        }
    }
    
    public void addColumn(TableViewColumn col){
        TableColumn<Map, String> column = new TableColumn<>(col.getTitle());
        column.setCellValueFactory(new MapValueFactory(col.getKey()));
        column.setVisible(col.visible);
        column.setPrefWidth(col.width);
        column.setMaxWidth(col.maxWidth);
        this.wt.getColumns().add(column);
    }
    
    public void addRow(Map<String, String> datarows){
        this.wt.getItems().addAll(datarows);
    }
    
    public void delRow(int index){
        this.wt.getItems().remove(index);
    }
}
