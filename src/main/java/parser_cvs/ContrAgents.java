package parser_cvs;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;


import parser_cvs.data.CVSFile;
import parser_cvs.data.Row;
import parser_cvs.interfaces.Table;


public class ContrAgents extends CVSFile implements Table{
    int contrAgents = 0;// номер столбца с контрагентами
    int expence = 1;// номер столбца с расходом 
    

    public ContrAgents(List<Row> newSortedList) {
        super(newSortedList);
    }

    public ContrAgents(CVSFile file) {
        super(TableConstructor.getTable(file, 5,7));
    }


    private ContrAgents getFormattedContragentsTable() {
        
        formateFirstColumn();
          
        int pozition = 0;
        List<Row> newSortedList = new ArrayList<>();
        for (Row row : this.getData()) {

            if (!isSet(newSortedList, row.getRawString(contrAgents)) || newSortedList.isEmpty()) {
                setNewContrAgent(newSortedList, pozition);
            } else {
                countExpenceSum(newSortedList,  pozition);
            }
            pozition++;// counter in list of 119 elements
        }

        newSortedList.add(0, this.getTitle()); 
         
        return new ContrAgents(newSortedList);
    }

    private void formateFirstColumn() {
        for (Row row : this.getData()) {
            row.setRawString(this.contrAgents, row.getSecondWord(contrAgents));
        }
    }

    private void countExpenceSum(List<Row> newSortedList, int pozition) {
        MathContext mc = new MathContext(5);

        for (Row row : newSortedList) {
            if (row.getRawString(contrAgents).equals(this.getData().get(pozition).getRawString(contrAgents))) {
                BigDecimal expence = new BigDecimal(Float.valueOf(row.getFormattedString(this.expence)), mc);
                expence = expence.add(new BigDecimal(Float.valueOf(this.getData().get(pozition).getFormattedString(this.expence)), mc));
                row.setRawString(this.expence, expence.toString());
            }
        }

    }

    private void setNewContrAgent(List<Row> newSortedList, int pozition) {
        newSortedList.add(this.getData().get(pozition));
    }

    private boolean isSet(List<Row> listByContrAgents, String name) {
        for (Row row : listByContrAgents) {
            if (name.equals(row.getRawString(contrAgents))) {
                return true;
            }
        }
        return false;
    }





    



   

    public ContrAgents sortByComparation() {
        return getFormattedContragentsTable();  
    }

    @Override
    public CVSFile create(CVSFile file) {
        return new ContrAgents(file);
    }
}
