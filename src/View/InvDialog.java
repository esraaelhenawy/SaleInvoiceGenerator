package View;

import javax.swing.*;
import java.awt.*;

public class InvDialog extends JDialog {
    private JLabel cstName;
    private JLabel invDate;
    private JTextField cstField;
    private JTextField dateField;
    private JButton ok;
    private JButton cancel;

    public InvDialog(InvoicePreview invoicePreview) {
        cstName = new JLabel("Customer Name: ");
        cstField=new JTextField(20);
        invDate=new JLabel("Invoice Date: ");
        dateField=new JTextField(20);
        ok=new JButton("Okay");
        cancel=new JButton("Cancel");
        ok.setActionCommand("ok");
        cancel.setActionCommand("cancel");
        ok.addActionListener(invoicePreview.getAction());
        cancel.addActionListener(invoicePreview.getAction());
        setLayout(new GridLayout(3,2));
        add(invDate);
        add(dateField);
        add(cstName);
        add(cstField);
        add(ok);
        add(cancel);
        pack();
    }

    public JTextField getCstField() {
        return cstField;
    }

    public void setCstField(JTextField cstField) {
        this.cstField = cstField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public void setDateField(JTextField dateField) {
        this.dateField = dateField;
    }
}
