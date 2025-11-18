package auction.mediator;

import auction.bidder.IBidder;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements IMediator{
    List<IBidder> bidders;

    public AuctionMediator() {
        bidders = new ArrayList<>();
    }

    public void addBidder(IBidder bidder) {
        bidders.add(bidder);
    }

    public void placeBid(IBidder bidder, int amount) {
        for(IBidder bidderObj: bidders) {
            if(!bidder.getName().equals(bidderObj.getName()))
                bidderObj.receiveNotification(bidder.getName(), amount);
        }
    }
}
