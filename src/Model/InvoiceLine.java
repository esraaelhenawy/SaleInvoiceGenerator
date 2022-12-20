package Model;
import java.util.Date;
public class InvoiceLine {
    private String itemName;
    private double itemPrice;
    private  int  count;
    private InvoiceHeader invoice;

    public InvoiceLine() {

    }

    public InvoiceLine( String itemName, double itemPrice, int count) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    public InvoiceLine( String itemName, double itemPrice, int count, InvoiceHeader invoice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count=count;
        this.invoice=invoice;

    }


    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }
    public double getTotal(){
        double itemTotal ;
        itemTotal  = itemPrice * count;
        return itemTotal;
    }
    public String lToF (){
        return invoice.getInvoiceNumber() + "," + itemName + "," + itemPrice+ "," + count;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                ",invoiceNumber"+invoice.getInvoiceNumber()+"/"+
                ", itemPrice=" + itemPrice +
                ", count=" + count +

                '}';
    }
}
