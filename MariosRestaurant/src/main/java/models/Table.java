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

    public double getTotalBill() {
        double tableTotal = 0.0;
        for(Client client : table){
            tableTotal +=client.getExpense();
        }
        return tableTotal;
    }

    public void SplitTotalEqually() {
        double tableTotal = 0.0;
        for (Client client : table) {
            tableTotal += client.getExpense();
        }
        for (Client client : table) {
            double totalTable = tableTotal / table.size();
            client.setBill(totalTable);
        }
    }



}
