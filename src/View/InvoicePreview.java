package View;

import Controller.InvoiceActionListener;
import Controller.InvoiceSelection;
import Model.InvoiceHeader;
import Model.InvoicesTableController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public  class InvoicePreview extends JFrame {

    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JButton createItem;
    private JButton deleteItem;
    private JLabel jLabel1;
    private JLabel invNumLabel;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel totalInv;
    private JLabel totalLabel;
    private JMenu file;
    private JMenuBar jMenuBar1;
    private JMenuItem loadFile;
    private JMenuItem saveFile;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTable jTable1;
    private JTable jTable2;
    private JTextField dateField;
    private JTextField nameField;
    private JToolBar jToolBar2;
    private JLabel label1;
    private JPanel panel1;
    private JPanel panel2;

    private InvoiceActionListener action=new InvoiceActionListener(this);
    private InvoiceSelection selection=new InvoiceSelection(this);

    public InvoiceSelection getSelection() {
        return selection;
    }

    public void setSelection(InvoiceSelection selection) {
        this.selection = selection;
    }

    private ArrayList<InvoiceHeader> invoices;
    private InvoicesTableController invoiceTable=new InvoicesTableController(invoices);

    public InvoicesTableController getInvoiceTable() {
        return invoiceTable;
    }
    private InvoiceActionListener invoiceActions;

    public ArrayList<InvoiceHeader> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public InvoicePreview() {
        frame = new JFrame();
        jMenuBar1 = new JMenuBar();
        file = new JMenu();
        panel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jTable1.getSelectionModel().addListSelectionListener(selection);
        label1 = new JLabel();
        button1 = new JButton();
        button1.addActionListener(action);
        button1.setActionCommand("createNewInvoice");


        button2 = new JButton();
        button2.addActionListener(action);
        button2.setActionCommand("d");

        panel2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        jTable2 = new JTable();
        jLabel1 = new JLabel();
        invNumLabel = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        dateField = new JTextField();
        nameField = new JTextField();
        jLabel5 = new JLabel();
        totalInv=new JLabel();
        totalLabel =new JLabel();

        createItem = new JButton();
        createItem.addActionListener(action);
        createItem.setActionCommand("cr");

        deleteItem = new JButton();
        deleteItem.addActionListener(action);
        deleteItem.setActionCommand("de");

        jMenuBar1 = new JMenuBar();
        file = new JMenu();

        saveFile = new JMenuItem();
        saveFile.addActionListener(action);
        saveFile.setActionCommand("s");

        loadFile = new JMenuItem();
        loadFile.addActionListener(action);
        loadFile.setActionCommand("l");

        file.setText("File");
        jMenuBar1.add(file);


        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");
        label1.setText("InvoicesTable");

        button1.setLabel("Create Invoice");


        button2.setLabel("Delete Invoice");


        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0,
                                                Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 152,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 239, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)));
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 381,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));



        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "No.", "Item Name", "Item Price", "Count","Item Total"
                }));
        jScrollPane3.setViewportView(jTable2);

        jLabel1.setText("InvoiceNumber");

        invNumLabel.setText(" ");

        jLabel3.setText("InvoiceDate");

        jLabel4.setText("CustomerName");

        dateField.setText("  ");

        nameField.setText(" ");

        totalInv.setText("Total Invoice");
        totalLabel.setText(" ");
        jLabel5.setText("InvoiceItems");

        button1.getAccessibleContext().setAccessibleName("CreateNewInvoice");
        createItem.setLabel("Create Item");



        deleteItem.setLabel("Delete Item");


        GroupLayout panel2Layout = new GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(panel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel4)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(dateField))
                                                                .addGroup(panel2Layout.createSequentialGroup()
                                                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel3))
                                                                        .addGap(12, 12, 12)
                                                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(invNumLabel)
                                                                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(panel2Layout.createSequentialGroup()
                                                                .addComponent(totalInv, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(24, 24, 24)
                                                                .addComponent(totalLabel)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(createItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(deleteItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(invNumLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalInv)
                                        .addComponent(totalLabel))
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(createItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        file.setText("File");

        saveFile.setText("SaveFile");

        file.add(saveFile);

        loadFile.setText("LoadFile");


        file.add(loadFile);

        jMenuBar1.add(file);

        frame.setJMenuBar(jMenuBar1);

        GroupLayout jFrame1Layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, GroupLayout.Alignment.TRAILING,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.Alignment.TRAILING,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));


        getContentPane().setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//////////////setters&getters//////////////////////
    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getCreateItem() {
        return createItem;
    }

    public JButton getDeleteItem() {
        return deleteItem;
    }

    public JFrame getFrame() {
       return frame;

    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getInvNumLabel() {
        return invNumLabel;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JMenu getFile() {
        return file;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public JMenuItem getLoadFile() {
        return loadFile;
    }

    public JMenuItem getSaveFile() {
        return saveFile;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JToolBar getjToolBar2() {
        return jToolBar2;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public void setCreateItem(JButton createItem) {
        this.createItem = createItem;
    }

    public void setDeleteItem(JButton deleteItem) {
        this.deleteItem = deleteItem;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public void setInvNumLabel(JLabel invNumLabel) {
        this.invNumLabel = invNumLabel;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public void setFile(JMenu file) {
        this.file = file;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public void setLoadFile(JMenuItem loadFile) {
        this.loadFile = loadFile;
    }

    public void setSaveFile(JMenuItem saveFile) {
        this.saveFile = saveFile;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public void setDateField(JTextField dateField) {
        this.dateField = dateField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public void setjToolBar2(JToolBar jToolBar2) {
        this.jToolBar2 = jToolBar2;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getTotalInv() {
        return totalInv;
    }

    public JLabel getTotalLabel() {
        return totalLabel;
    }

    public void setTotalLabel(JLabel totalLabel) {
        this.totalLabel = totalLabel;
    }

    public void setTotalInv(JLabel totalInv) {
        this.totalInv = totalInv;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }



    public InvoiceActionListener getAction() {
        return action;
    }

    public InvoiceActionListener getInvoiceActions() {
        return invoiceActions;
    }

    public void setInvoiceTable(InvoicesTableController invoiceTable) {
        this.invoiceTable = invoiceTable;
    }
    public int getNextInvNum(){
        int nextNum=0;
         for(InvoiceHeader invoiceHeader:invoices){
              if(invoiceHeader.getInvoiceNumber()>nextNum){
                  nextNum=invoiceHeader.getInvoiceNumber();
              }
         }

        return nextNum+1;
    }
}