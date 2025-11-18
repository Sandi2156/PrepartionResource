package auction.bidder;

public interface IBidder {
    public void placeBid(int amount);
    public void receiveNotification(String name, int amount);
    public String getName();
}
