import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;


/*
	Using Problem022.txt, a text file containing five-thousand first names,
	begin by sorting them into alphabetical order. Then working out the 
	alphabetical value for each name, multiply this value by its alphabetical
	position in the list to obtain a name score.

	For example, when the list is sorted into alphabetical order, COLIN, which
	is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
	So, COLIN would obtain a score of 938 x 53 = 49714.

	What is the total of all the name scores in the file?
*/

public class Problem022 {
    public static void main(String[] args) throws IOException {
        String file = "Problem022.txt";
        FileReader reader = new FileReader(file);
        BufferedReader breader = new BufferedReader(reader);
        String lineString = "";
        lineString = breader.readLine();

        String[] names = lineString.split(",");
        
        System.out.println(names.length);
    }

    String[] sort(String[] a) { 
         
    }

    void transpose(String[] array, int a, int b) {
   	if (array[a] == array[b]) {
            return;
	} else if (a < b && array[a] > array[b]) {
            String temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        } else if (a > b && array[a] < array[b]) {
            temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }
}
