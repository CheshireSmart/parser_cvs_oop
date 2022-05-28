package parser_cvs.parser;

import java.io.FileReader;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import parser_cvs.data.CVSFile;
import parser_cvs.data.Row;


public final class Parser {

    private static CVSFile parserCvs(Path filePath) {
        List<Row> file = new ArrayList<>(); 
        try (/** its how we do initialisation of myNewFile */
        CSVReader reader = new CSVReader(new FileReader(filePath.toString(),Charset.forName("UTF-8")))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                file.add(new Row(nextLine));
            }
            return new CVSFile(file) ;
        } catch (CsvValidationException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
     return new CVSFile();
    }



    public static CVSFile getFile(Path path) {
        return parserCvs(path); 
    }

 

}
