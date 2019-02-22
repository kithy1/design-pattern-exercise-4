package model;

import java.util.ArrayList;
import java.util.List;

public class AuctionNotifierImp implements AuctionNotifier {

    List<Observer> observers;

    public AuctionNotifierImp() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach((observer -> observer.update()));
    }


}