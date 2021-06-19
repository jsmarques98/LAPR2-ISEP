package app.Adapter;

import app.domain.model.Client;
import app.domain.model.Test;

import java.util.Comparator;
import java.util.List;

public class SortClientsAlgorithms {

    private Test test;

    public void showNameList(List<Client> clientList){
        clientList.sort(Comparator.comparing(Client::getName));
        for(Client list: clientList){
            System.out.println(list);
        }
    }


    public void showTINList(List<Client> clientList){
        clientList.sort(Comparator.comparing(Client::getTINNumber));
        for( Client list : clientList){
            System.out.println(list);
        }
    }
}
