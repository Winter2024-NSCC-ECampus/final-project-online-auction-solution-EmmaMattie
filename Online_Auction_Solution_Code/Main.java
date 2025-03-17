import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AuctionSystem auction1 = new AuctionSystem();
        AuctionSystem auction2 = new AuctionSystem();
        Random random = new Random();

        System.out.println("===== Auction 1: Tie Between Highest Bidders (Restart) =====");
        auction1.placeBid(random.nextInt(50) + 20, "User1");
        auction1.placeBid(random.nextInt(50) + 20, "User2");

        int highestTieBid = random.nextInt(50) + 100; // Generates a high bid that will be tied
        auction1.placeBid(highestTieBid, "User3");
        auction1.placeBid(highestTieBid, "User4"); // Intentional tie at the highest bid level

        auction1.placeBid(random.nextInt(50) + 50, "User5"); 

        auction1.determineWinner(true); // Will restart since highest bid is tied

        System.out.println("\n===== Auction 2: Unique Highest Bid Wins =====");
        auction2.placeBid(random.nextInt(50) + 20, "User1");
        auction2.placeBid(random.nextInt(50) + 20, "User2");
        auction2.placeBid(random.nextInt(50) + 50, "User3");
        auction2.placeBid(random.nextInt(50) + 50, "User4");

        int uniqueHighBid = random.nextInt(50) + 150; // Ensures a unique highest bid
        auction2.placeBid(uniqueHighBid, "User5");

        auction2.determineWinner(false); // No restart, first highest bid wins
    }
}

