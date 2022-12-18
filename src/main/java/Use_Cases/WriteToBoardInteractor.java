package Use_Cases;

public class WriteToBoardInteractor implements WriteToBoardInputBoundary {

    final String userName;
    WriteToBoardGatewayBoundary writeToBoardAccess;
    public WriteToBoardInteractor(String userName, WriteToBoardGatewayBoundary writeToBoardAccess){
        this.userName = userName;
        this.writeToBoardAccess = writeToBoardAccess;
    }

    @Override
    public void writeToDatabase(WriteToBoardRequestModel writeToBoardRequestModel) {
        writeToBoardAccess.writeToDatabase(this.userName, writeToBoardRequestModel.getTime());
    }
}
