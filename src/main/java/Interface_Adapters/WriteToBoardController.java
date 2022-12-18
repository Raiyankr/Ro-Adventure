package Interface_Adapters;
import Use_Cases.WriteToBoardInputBoundary;
import Use_Cases.WriteToBoardRequestModel;

import java.io.*;

public class WriteToBoardController {

    WriteToBoardInputBoundary writeToBoardInteractor;
    public WriteToBoardController(WriteToBoardInputBoundary writeToBoardInputBoundary) {
        this.writeToBoardInteractor = writeToBoardInputBoundary;
    }

    public void writeToDatabase(int time) {
        this.writeToBoardInteractor.writeToDatabase( new WriteToBoardRequestModel(time));
        }

}
