package parser_cvs;

import java.util.ArrayList;
import java.util.List;

import parser_cvs.data.CVSFile;
import parser_cvs.data.Row;

public class TableConstructor {

    /** table creator realisation */
    private static CVSFile createNewTableFromCVS(CVSFile file, int ... i){
        List<Row> table = new ArrayList<>();
        table.add(new Row(file.getTitle().getPosition(i)));

        for(Row row : file.getData()){
            table.add(new Row(row.getPosition(i)));
        }
        return new CVSFile(table);
    }
   
    

    /** interface part of class */
    public static CVSFile getTable(CVSFile cvsFile, int ...i) {
        return createNewTableFromCVS(cvsFile, i);
    } 

}
