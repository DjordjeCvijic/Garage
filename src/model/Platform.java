package model;

public class Platform {
    public static int counter=0;
    private Field[][] fields;
    private int platformNumber;
    private static int NUM_OF_COLUMNS=8;
    private static int NUM_OF_ROWS=10;
    private int numberOfAvailableParkingFields;
    private String[][] currentMarks;


    public Platform(){
        counter++;
        platformNumber=counter;
        fields=new Field[NUM_OF_ROWS][NUM_OF_COLUMNS];
        for(int i=0;i<NUM_OF_ROWS;i++)
            for(int j=0;j<NUM_OF_COLUMNS;j++)
                fields[i][j]=new Field(this);

        numberOfAvailableParkingFields=28;

        currentMarks=new String [NUM_OF_ROWS][NUM_OF_COLUMNS];

        for(int i=0;i<NUM_OF_ROWS;i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
                if ((j == 0 || j == 3 || j == 4 || j == 7) && (i != 0 && i != 1 && i != 8 && i != 9))
                    fields[i][j].setParking(true);
                if ((i == 8 && (j == 0 || j == 7)) || (i == 9 && (j == 0 || j == 7)))
                    fields[i][j].setParking(true);
            }
        }
        for(int i=0;i<NUM_OF_ROWS;i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
                if (fields[i][j].isParking())
                    currentMarks[i][j] = "*";
                else
                    currentMarks[i][j] = "";
            }
        }

    }







}
