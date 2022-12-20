package Model;

import View.InvoicePreview;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import javax.swing.*;


public class InvoicesTableController extends AbstractTableModel {
    private ArrayList<InvoiceHeader> invoices;
    private InvoicePreview frame;


    private String[] columns = {"No.", "Date", "Customer", "Total"};
    private InvoiceHeader invo;

    public InvoicesTableController(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        invo = invoices.get(rowIndex);

        if (columnIndex == 0) {
            return invo.getInvoiceNumber();
        } else if (columnIndex == 1) {
            return invo.getInvoiceDate();
        } else if (columnIndex == 2) {
            return invo.getCustomerName();
        } else if (columnIndex == 3) {
            return invo.getInvoiceTotal();
        }
        return null;
    }

    public ArrayList<InvoiceHeader> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public InvoiceHeader getInvo() {
        return invo;
    }

    public void setInvo(InvoiceHeader invoice) {
        this.invo = invoice;
    }



}
