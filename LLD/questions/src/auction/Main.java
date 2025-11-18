package auction;

import auction.bidder.AuctionBidder;
import auction.bidder.IBidder;
import auction.mediator.AuctionMediator;
import auction.mediator.IMediator;

public class Main {
    public static void main(String[] args) {
        IMediator auctionMediator = new AuctionMediator();

        IBidder bidder1 = new AuctionBidder("Sandipan", auctionMediator);
        IBidder bidder2 = new AuctionBidder("Susama", auctionMediator);
        IBidder bidder3 = new AuctionBidder("Sarbani", auctionMediator);

        auctionMediator.addBidder(bidder1);
        auctionMediator.addBidder(bidder2);
        auctionMediator.addBidder(bidder3);

        bidder2.placeBid(100);
        bidder3.placeBid(900);
    }
}
