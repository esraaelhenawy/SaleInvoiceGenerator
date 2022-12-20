package Model;

import java.util.ArrayList;

public class InvoiceHeader {
    private int invoiceNumber;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> invoiceLines;
    private double total;

    public InvoiceHeader(int invoiceNumber, String invoiceDate, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public InvoiceHeader(int invoiceNumber, String invoiceDate, String customerName,
            ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.invoiceLines = invoiceLines;
    }

    public int getInvoiceNumber() {
        if (invoiceLines == null) {
            invoiceLines = new ArrayList<>();
        }
        return invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getInvoiceTotal() {
        total =0.0;
        for (InvoiceLine line : invoiceLines) {
            total += line.getTotal();
        }
        return total;
    }

 

    public String hToF() {
        return invoiceNumber + "," + invoiceDate + "," + customerName;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "invoiceNumber=" + invoiceNumber +
                ", invoiceLines=" + invoiceLines +
                ",invoicetotal" + total +
                '}';
    }
}
