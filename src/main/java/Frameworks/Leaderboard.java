package Frameworks;

import java.io.*;


public class Leaderboard {
    public static void write(String[] args) {
        try {
            //  The boolean allows us to not overwrite the file contents everytime we write to it.
            BufferedWriter writer = new BufferedWriter(new FileWriter("Leaderboard_File.txt", true));

            writer.write("Khushil ");
            writer.write("\nNagd");

            String[] names = {"James", "Sergio", "Kevin"};

            for (String name : names) {
                writer.write("\n" + name);
            }

            // This line below allows us to create the file and WRITE to it.
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Leaderboard_File.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // System.out.println(reader.readLine());
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
