package Controller;

import Model.InvoiceHeader;
import Model.LineTableController;
import View.InvoicePreview;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InvoiceSelection implements ListSelectionListener {
    private InvoicePreview invoicePreview;
    public InvoiceSelection(InvoicePreview invoicePreview) {
        this.invoicePreview=invoicePreview;
    }

  
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index=invoicePreview.getjTable1().getSelectedRow();
        if(index!=-1) {
            InvoiceHeader selectedInvoice = invoicePreview.getInvoices().get(index);
            invoicePreview.getInvNumLabel().setText(" " + selectedInvoice.getInvoiceNumber());
            invoicePreview.getDateField().setText(selectedInvoice.getInvoiceDate());
            invoicePreview.getNameField().setText(selectedInvoice.getCustomerName());
            invoicePreview.getTotalLabel().setText(" " + selectedInvoice.getInvoiceTotal());
            LineTableController linesTable = new LineTableController(selectedInvoice.getInvoiceLines());
            invoicePreview.getjTable2().setModel(linesTable);
            linesTable.fireTableDataChanged();
        }
    }
}
