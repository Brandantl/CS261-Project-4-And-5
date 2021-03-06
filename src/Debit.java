/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_5;

import java.util.*;

/**
 *
 * @author kalebstriplin
 */
public class Debit extends Account {

    public Debit(Debit card) {
        this.cardNumber = card.cardNumber;
        this.PIN = card.PIN;
        this.type = card.type;
        this.list.addAll(card.list);
    }

    public Debit(String number, Integer pin) {
        cardNumber = number;
        PIN = pin;
        list = new ArrayList<Receipt>();
        type = "Debit";
    }

    public String getPIN() {
        return PIN.toString();
    }

    @Override
    public String getType() {
        return super.getType(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public List<Receipt> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    private String cardNumber;
    private Integer PIN;

    public int total() {
        int total = 0;
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while (it.hasNext()) {
            current = it.next();
            total = total + current.getTotal();
        }
        return total;
    }

    public void addItem(String store, Item anItem) {
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while (it.hasNext()) {
            current = it.next();
            if (current.getStorename() == store) {
                current.addItem(new Item(anItem));
                return;
            }
        }
        list.add(new Receipt(store));
        addItem(store, anItem);
    }

    public Item search(String name) {
        Item stuff = null;
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while (it.hasNext()) {
            current = it.next();
            if (current.search(name) != null) {
                stuff = current.search(name);
                return stuff;
            }
        }
        return stuff;
    }

    public String toString() {
        return type + " " + cardNumber + " " + PIN + "\n";
    }

}
