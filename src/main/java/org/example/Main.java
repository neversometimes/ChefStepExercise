package org.example;

import java.util.*;
import java.io.*;

// Code in main() reads in a file containing X number of words
// Words are added to a linkedHashSet which recognizes order and doesn't allow duplicates
// The linkedHashSet is then written to an output.txt file
// Using large test files and measuring execution time shows using a linkedHashSet
// in this way is very fast and efficient.
//  This was an interview screen question I got from ChefSteps recruiters to solve.
//  My solution written in C is very long and complicated compared to this Java version.

public class Main {
    public static void main(String[] args) throws IOException{

        Scanner entre = null;
        PrintWriter egress = null;
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // get start time here
        double startTime = System.currentTimeMillis();

        try {
            entre = new Scanner(new BufferedReader(new FileReader("300kNoDups.txt")));
            egress = new PrintWriter(new FileWriter("output.txt"));

            while (entre.hasNext()) {
                set.add(entre.next());
            }
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                egress.print(it.next() + " ");
            }
        } finally {
            if (entre != null) {
                entre.close();
            }
            if (egress != null) {
                egress.close();
            }
        }

        // get end time here
        double endTime = System.currentTimeMillis();

        // calc elapsed time of code execution end-start time (ms)
        double timeElapsedMillis = endTime - startTime;
        double ms2sec = timeElapsedMillis/1000.0;  //convert ms to secs

        System.out.println(ms2sec); //print out the elapsed time in secs

    }

} // end class Main