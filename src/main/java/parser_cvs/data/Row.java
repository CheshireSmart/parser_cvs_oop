package parser_cvs.data;

public class Row {
    public Row(String[] nextLine) {
        this.row = nextLine;
    }

    public Row() {
    }

    // public Row(Row newRow) {
    //     this.row = new String[newRow.size()];
    //     for(int i = 0 ; i < newRow.size() ; i++){
    //         this.row[i] = newRow.getRawString(i);
    //     }
    // }

    private String[] row;
    
    public String getFormattedString(int pozition){
        return this.row[pozition].replaceAll("^\"|\"$", "").replace(',', '.');
    }

    public String getRawString(int pozition) {
        return this.row[pozition];
    }

    public void setRawString(int pozition, String string) {
        this.row[pozition] = string;
    }

    public String getSecondWord(int pozition){
        return this.row[pozition].split(" ", 2)[1].trim().split("[.]", 0)[0].replaceAll("\\w+$", "").replaceAll(" +", " ");
    }
 
    public void print() {
        for (String string : this.row) {
            System.out.printf("%-40s \t",string);
        }
    }

    public int size() {
        return this.row.length;
    }

    public String[] getPosition(int[] i) {
        String[] str = new String[i.length];
        int len = 0;
        for (int j : i) {
            str[len] = this.row[j];
            len++;
        }
        return str;
    }
}
