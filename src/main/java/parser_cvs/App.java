package parser_cvs;


import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


import parser_cvs.data.CVSFile;
import parser_cvs.parser.Parser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws URISyntaxException
    {
        URL fileCVS = App.class.getClassLoader().getResource("movementList.csv");// path to file URL type

        CVSFile file = Parser.getFile(Paths.get(fileCVS.toURI()));// 
        

        Movements movements = new Movements(file);
        System.out.println("\n");
        System.out.printf("%-60s %-10s", "Сумма доходов: " , movements.getIncomeSum());
        System.out.println();
        System.out.printf("%-60s %-10s", "Сумма расходов: " , movements.getExpenceSum());
        System.out.println();

        ContrAgents contrAgents = new ContrAgents(file).sortByComparation();
        System.out.println("\n\nСумма расходов и доходов по контрагентам:\n");
        contrAgents.print();
        System.out.println();
        System.out.printf("%-60s %-10s", "Сумма расходов по таблице размера "+contrAgents.size()+" : "   , contrAgents.countTotalByColumn(1));
        
     
    }
}