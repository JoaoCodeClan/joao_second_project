package interfaces;

import models.Menu;

public interface Client {

     void makeOrder(Menu menu, MenuItem item);
    double getExpense();
    void setBill(double newBill);
}
