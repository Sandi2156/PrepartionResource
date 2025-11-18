package auction.bidder;

import auction.mediator.IMediator;

import java.util.List;

public class AuctionBidder implements IBidder {
    private String name;
    private IMediator mediator;

    public AuctionBidder(String name, IMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public  void placeBid(int amount) {
        mediator.placeBid(this, amount);
    }

    public void receiveNotification(String name, int amount) {
        System.out.println("Received Message "+ this.name + ": Bidder - " + name + " has placed a bid of amount " + amount);
    }

    public String getName() {
        return name;
    }
}
