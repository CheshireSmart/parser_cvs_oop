package parser_cvs;

import java.math.BigDecimal;

import parser_cvs.data.CVSFile;
import parser_cvs.interfaces.Table;


public class Movements extends CVSFile implements Table{
 
    int accountType = 1;
  
    int income = 6;
    int expence = 7;
       
    public Movements(CVSFile file) {
        super(file);
    }

    public BigDecimal getIncomeSum() {
        return countTotalByColumn(income);
    }

    public BigDecimal getExpenceSum() {
        return countTotalByColumn(expence);
    }

    @Override
    public CVSFile create(CVSFile file) {
        return new Movements(file);
    }


}
