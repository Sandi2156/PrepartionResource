package auction.mediator;

import auction.bidder.IBidder;

public interface IMediator {
    public void addBidder(IBidder bidder);
    public void placeBid(IBidder bidder, int amount);
}
