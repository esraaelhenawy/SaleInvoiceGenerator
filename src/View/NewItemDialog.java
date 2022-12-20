package View;

import javax.swing.*;
import java.awt.*;

public class NewItemDialog extends JDialog {
    private JLabel itemName;
    private JLabel itemPrice;
    private JLabel count;
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField countField;
    private JButton ok;
    private JButton cancel;

    public NewItemDialog(InvoicePreview invoicePreview) {
        itemName = new JLabel("Item Name: ");
        itemNameField=new JTextField(20);
        itemPrice=new JLabel("Item Price: ");
        itemPriceField=new JTextField(20);
        count=new JLabel("Item count: ");
        countField=new JTextField(" ");
        ok=new JButton("Okay");
        cancel=new JButton("Cancel");
        ok.setActionCommand("okItem");
        cancel.setActionCommand("cancelItem");
        ok.addActionListener(invoicePreview.getAction());
        cancel.addActionListener(invoicePreview.getAction());
        setLayout(new GridLayout(4,2));
        add(itemName);
        add(itemNameField);
        add(itemPrice);
        add(itemPriceField);
        add(count);
        add(countField);
        add(ok);
        add(cancel);
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }

    public JTextField getCountField() {
        return countField;
    }
}
