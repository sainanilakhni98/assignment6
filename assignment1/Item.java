package com.nagarro.assignment1;

/* This item class have getter and setter method which set and retrun the value of item variables*/
public class Item {
    // Declaration of variable
    private String Name;
    private double Price;
    private String Type;
    private double Quantity;

    public String getName(){                           // This Function return itemName
        return Name;
    }

    public void setName(String Name) {                //This Function take Name as a input which is provided  by user
        this.Name = Name;
    }

    public double getPrice(){                         // This Function return itemPrice
        return Price;
    }

    public void setPrice(double Price) {             // This Function take Price as a input which is provided  by user
        this.Price = Price;
    }

    public String getType() {                    // This Function return itemType
        return Type;
    }

    public void setType(String Type) {           // This Function take type as a input which is provided  by user
        this.Type = Type;
    }

    public Double getQuantity() {                // This Function return itemQuantity
        return Quantity;
    }

    public void setQuantity(Double Quantity) {     // This Function take Quantity as a input which is provided  by user
        this.Quantity = Quantity;
    }
}