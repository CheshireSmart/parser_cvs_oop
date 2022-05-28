package parser_cvs.interfaces;

import java.math.BigDecimal;
import java.util.List;

import parser_cvs.data.CVSFile;
import parser_cvs.data.Row;


public interface Table extends Iterable <Row>{
    public Row getTitle();
    public List<Row> getData();
    public void print();
    public void describe(); 
    public CVSFile createTable(int ... i);
    public BigDecimal countTotalByColumn(int i);
    public Row getRow(int i);
    public void removeRow(int i);
    CVSFile create(CVSFile table);
    
}
