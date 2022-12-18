package Frameworks;

import Use_Cases.WriteToBoardGatewayBoundary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToBoardGateway implements WriteToBoardGatewayBoundary {
    @Override
    public void writeToDatabase(String userName, int time) {
        try {
            //  The boolean allows us to not overwrite the file contents everytime we write to it.
            BufferedWriter writer = new BufferedWriter(new FileWriter("Frameworks//Leaderboard_File.txt", true));

            writer.write("\n" + userName + time);

            // This line below allows us to create the file and WRITE to it.
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
