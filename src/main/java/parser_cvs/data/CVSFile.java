package parser_cvs.data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import parser_cvs.TableConstructor;


public class CVSFile {

    public CVSFile(List<Row> newList) {
        initDataOfClassBy(newList);
    }

    public CVSFile() {
        initDataOfClassBy(new ArrayList<Row>());
    }

    public CVSFile(CVSFile file) {
        this.titleLineSection = file.getTitle();
        this.dataSectoion = file.getData();
    }

    protected Row titleLineSection;
    protected List<Row> dataSectoion;
    
    private void initDataOfClassBy(List<Row> file) {
        this.titleLineSection = file.get(0);// init title from first line
        //this.titleLineSection.print();
        file.remove(0);//femove first line from file
        this.dataSectoion = new ArrayList<>();
        for(Row stringArrayFromFile : file){// init data section from file without first line 
            this.dataSectoion.add(stringArrayFromFile);
        }    
    }
    
    private BigDecimal countTotal(int column) {
        MathContext mc = new MathContext(5);
        BigDecimal result = new BigDecimal(0, mc);
        for (Row row : this.getData()) {
            result = result.add(new BigDecimal(Float.valueOf(row.getFormattedString(column)), mc));
        }
        return result;
    }

    private List<Row> data() {
        return this.dataSectoion;
    }

    private Row title(){
        return this.titleLineSection;
    }
    
    
    
    
    public void print() {
        // TODO Auto-generated method stub
        this.getTitle().print();
        System.out.println("\n");
        for(Row row : this.getData()){
            row.print();
            System.out.println();
        }
    }
    
    public void describe() {
        getTitle().print();
        System.out.println();
        System.out.println("столбцов - "+this.getTitle().size());
        System.out.println("строк - "+this.getData().size());  
        System.out.println();
        System.out.println();      
    }
    
    public CVSFile createTable(int ... i) {
        return TableConstructor.getTable(this, i);
    }
   
    public BigDecimal countTotalByColumn(int column) {
        return countTotal(column);
    }
  
    public Iterator<Row> iterator() {
        return getData().iterator();
    }
   
    public Row getRow(int row) {
        return getData().get(row);
    }
    
    public void removeRow(int index) {
        getData().remove(index);
    }
    
    public Row getTitle() {
        return title();
    }
   
    public List<Row> getData() {
        return data();
    }

    public int size(){
        return getData().size();
    }

}
