// AuctionSystem.java
import java.util.*;

public class AuctionSystem {
  private final Map<Integer, List<Bid>> bidMap; 
  private final PriorityQueue<Integer> bidQueue; 
  private final LinkedHashMap<Integer, Bid> bidOrder;
  

    public AuctionSystem() {
        bidMap = new HashMap<>();
        bidQueue = new PriorityQueue<>(Collections.reverseOrder()); // Max-Heap to get highest bid
        bidOrder = new LinkedHashMap<>();
    }

    public void placeBid(int amount, String bidderId) {
        long timestamp = System.currentTimeMillis();
        Bid bid = new Bid(amount, bidderId, timestamp);

        bidMap.putIfAbsent(amount, new ArrayList<>());
        bidMap.get(amount).add(bid);
        bidQueue.add(amount);
        bidOrder.putIfAbsent(amount, bid);

        System.out.println("Bid placed: $" + amount + " by " + bidderId);
    }

    public void determineWinner(boolean restartOnTie) {
        while (!bidQueue.isEmpty()) {
            int highestBid = bidQueue.poll();
            List<Bid> bidders = bidMap.get(highestBid);

            if (bidders.size() == 1) {
                System.out.println("Winner: " + bidders.get(0).bidderId + " with $" + highestBid);
                return;
            } else if (restartOnTie) {
                System.out.println("Tie detected! Restarting auction with minimum bid: $" + (highestBid + 1));
                resetAuction(highestBid + 1);
                return;
            }
        }
        System.out.println("No unique bid found. No winner.");
    }

    private void resetAuction(int newMinBid) {
        bidMap.clear();
        bidQueue.clear();
        bidOrder.clear();
        System.out.println("Auction restarted. New minimum bid: $" + newMinBid);
    }
}

