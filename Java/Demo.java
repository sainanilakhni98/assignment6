package Java;



public class Demo {
    // Declaration of variable
    private String itemName;
    private double itemPrice;
    private String itemType;
    private Double itemQuantity;

    public String getItemName(){                          // This Function return itemName
        return itemName;
    }
    public void setItemName(String itemName) {            /* This Function take input which is provided  by user*/
        this.itemName = itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getItemType()
    {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Double getItemQuantity()
    {
        return itemQuantity;
    }

    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
