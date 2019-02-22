package main;

import model.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Customer seller = new Customer("Jan Kowalski");
        Auction auction = new Auction.AuctionBuilder()
                .withId(1)
                .withItem("Coffee")
                .withDescription(null)
                .withLocalDateTime(LocalDateTime.now().plusDays(2L))
                .withSeller(seller)
                .withHighestBid(0)
                .withBuyer(null)
                .build();

        AuctionNotifier auctionNotifier = new AuctionNotifierImp();

        Customer customerOne = new Customer("Anna Kowalik");
        Customer customerTwo = new Customer("Krzysztof Adamowicz");

        auctionNotifier.registerObserver(customerOne);
        auctionNotifier.registerObserver(customerTwo);

        AuctionService auctionService = AuctionService.getInstance();

        auctionService.bid(auction,customerOne,20);
        auctionNotifier.notifyObservers();
        auctionService.bid(auction,customerTwo,25);
        auctionNotifier.notifyObservers();


        customerOne.printNotifications();

        System.out.println("Auction with id: " + auction.getId()+ " finished. Highest bid: " + auction.getHighestBid() + " PLN.");
    }
}
