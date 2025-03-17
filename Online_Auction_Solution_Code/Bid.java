// Bid.java
public class Bid {
  int amount;
  String bidderId;
  long timestamp;

  public Bid(int amount, String bidderId, long timestamp) {
      this.amount = amount;
      this.bidderId = bidderId;
      this.timestamp = timestamp;
  }
}
