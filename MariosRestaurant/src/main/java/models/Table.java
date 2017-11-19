package models;

import interfaces.Client;

import java.util.ArrayList;

public class Table {
    private ArrayList<Client> table;


    public Table(){
        this.table= new ArrayList();

    }

    public int countClients() {
        return this.table.size();
    }

    public void addClient(Client client) {
        this.table.add(client);
    }

    public void removeClient(Client client) {
        this.table.remove(client);
    }
}
