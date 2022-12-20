package Controller;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import Model.InvoicesTableController;
import Model.LineTableController;
import View.InvDialog;
import View.InvoicePreview;
import View.NewItemDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InvoiceActionListener implements ActionListener {
   // ActionEvent e;
    private InvoicePreview invoicePreview;
    InvDialog invDialog;
    NewItemDialog itemDialog;



    public InvoicePreview getInvoicePreview() {
        return invoicePreview;
    }

    public void setInvoicePreview(InvoicePreview invoicePreview) {
        this.invoicePreview = invoicePreview;
    }

    public InvoiceActionListener(InvoicePreview invoicePreview) {
            this.invoicePreview=invoicePreview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand=e.getActionCommand();

      if(actionCommand=="l"){
           loadFile();
      } else if (actionCommand=="s") {
          saveFile();
      } else if (actionCommand=="createNewInvoice") {
          createNewInv();
      } else if (actionCommand=="d") {
          deleteInv();
      } else if (actionCommand=="cr") {
          createItem();
      } else if (actionCommand=="de") {
          deleteItem();
      } else if (actionCommand=="ok") {
          createOkInv();
      } else if (actionCommand=="cancel") {
          cancelInv();
      } else if (actionCommand=="okItem") {
          createOkItem();
      } else if (actionCommand=="cancelItem") {
          cancelItem();
      } else {
          System.out.println("exception");
      }

    }

    private void createOkItem() {
        String itemName= itemDialog.getItemNameField().getText();
        String itemPrice=itemDialog.getItemPriceField().getText();
        String count=itemDialog.getCountField().getText();
        int currentInvoice=invoicePreview.getjTable1().getSelectedRow();
        double itemPriceToSt = Double.parseDouble(itemPrice);
        count=count.replaceAll("\\s", "");
        int countToSt= Integer.parseInt(count);
        if(currentInvoice!=-1) {
            InvoiceHeader invoice = invoicePreview.getInvoices().get(currentInvoice);
            InvoiceLine invoiceLine=new InvoiceLine(itemName,itemPriceToSt,countToSt,invoice);
            invoice.getInvoiceLines( ).add(invoiceLine);
            LineTableController lines=new LineTableController(invoice.getInvoiceLines());
            invoicePreview.getjTable2().setModel(lines);
            lines.fireTableDataChanged();
            invoicePreview.getInvoiceTable().fireTableDataChanged();
        }

          itemDialog.setVisible(false);
          itemDialog.dispose();
          itemDialog=null;
    }
    private void cancelItem(){
        itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog=null;
    }

    private void createOkInv() {
        String date=invDialog.getDateField().getText();
        String name=invDialog.getCstField().getText();
        int num= invoicePreview.getNextInvNum();
        InvoiceHeader invoiceHeader=new InvoiceHeader(num,date,name);
        invoicePreview.getInvoices().add(invoiceHeader);
        invoicePreview.getInvoiceTable().fireTableDataChanged();
        invDialog.setVisible(false);
        invDialog.dispose();
        invDialog=null;

    }
    private void cancelInv(){
        invDialog.setVisible(false);
        invDialog.dispose();
        invDialog=null;
    }

    private void deleteItem() {
        int invRow=invoicePreview.getjTable1().getSelectedRow();
        int lineRow=invoicePreview.getjTable2().getSelectedRow();
        if(invRow!= -1&& lineRow!=-1){
            InvoiceHeader invoice=invoicePreview.getInvoices().get(invRow);
            invoice.getInvoiceLines().remove(lineRow);
            LineTableController lines=new LineTableController(invoice.getInvoiceLines());
            invoicePreview.getjTable2().setModel(lines);
            lines.fireTableDataChanged();
            invoicePreview.getInvoiceTable().fireTableDataChanged();

        }
    }

    private void createItem() {
        itemDialog =new NewItemDialog(invoicePreview);
        itemDialog.setVisible(true);

    }

    private void saveFile() {
        ArrayList<InvoiceHeader> invoiceHeaders;
        invoiceHeaders=invoicePreview.getInvoices();
        String invoice=" ";
        String line=" ";
        for(InvoiceHeader invo:invoiceHeaders){
            String htof=invo.hToF();
            invoice+=htof+"\n";
             for(InvoiceLine lin:invo.getInvoiceLines()){
                 String ltof=lin.lToF();
                 line+=ltof +"\n";
             }
             JFileChooser fo=new JFileChooser();
             int r=fo.showSaveDialog(invoicePreview);
             if(r==JFileChooser.APPROVE_OPTION) {
                 File hFile = fo.getSelectedFile();
                 FileWriter hw;
                 try {
                     hw = new FileWriter(hFile);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
                 try {
                     hw.write(invoice);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
                 try {
                     hw.flush();
                     hw.close();
                 }catch (IOException e){
                     throw new RuntimeException(e);
                 }
                 r=fo.showSaveDialog(invoicePreview);
                 if(r==JFileChooser.APPROVE_OPTION){
                     File lf=fo.getSelectedFile();

                     try {  FileWriter lfw = new FileWriter(lf);
                           lfw.write(line);
                           lfw.flush();
                            lfw.close();
                     }catch (IOException e){
                         throw new RuntimeException(e);
                     }
                 }



             }
        }
    }

    private void loadFile()  {

        FileInputStream fio = null;
        JFileChooser fi = new JFileChooser();
        int result = fi.showOpenDialog(invoicePreview);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fi.getSelectedFile().getPath();

                //   fio = new FileInputStream(path);
                //  int size = fio.available();
                //  byte[] b = new byte[size];
            List<String> invoiceList = null;
            try {
                invoiceList = Files.readAllLines(Paths.get(path));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ArrayList<InvoiceHeader> invoiceArray = new ArrayList<>();
                for (String invoiceLines : invoiceList) {
                    String[] line = invoiceLines.split(",");
                    int invoiceNumber = Integer.parseInt(line[0]);
                    String invoiceDate = line[1];
                    String customerName = line[2];
                    InvoiceHeader invoice = new InvoiceHeader(invoiceNumber, invoiceDate, customerName);
                    invoiceArray.add(invoice);

                }
                    result = fi.showOpenDialog(invoicePreview);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String invoiceLinePath = fi.getSelectedFile().getPath();

                        List<String> invoiceLineList = null;
                        try {
                            invoiceLineList = Files.readAllLines(Paths.get(invoiceLinePath));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        ArrayList<InvoiceLine> lineArray = new ArrayList<>();
                        for (String line : invoiceLineList) {
                            String[] line1 = line.split(",");
                            int invoiceNumber = Integer.parseInt(line1[0]);
                            String itemName = line1[1];
                            double itemPrice = Double.parseDouble(line1[2]);
                            int count = Integer.parseInt(line1[3]);
                            InvoiceHeader lineInv = null;
                            for (InvoiceHeader invo : invoiceArray) {
                                if (invo.getInvoiceNumber() == invoiceNumber) {
                                    lineInv = invo;
                                    break;
                                }
                            }
                            InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, count, lineInv);
                            lineArray.add(invLine);
                            lineInv.getInvoiceLines().add(invLine);
                            invoicePreview.setInvoices(invoiceArray);
                            InvoicesTableController invoiceTable = new InvoicesTableController(invoiceArray);
                            invoicePreview.setInvoiceTable(invoiceTable);
                            invoicePreview.getjTable1().setModel(invoiceTable);


                        }
                        invoicePreview.getInvoiceTable().fireTableDataChanged();
                    }
                }

            }

        private void createNewInv () {
            invDialog=new InvDialog(invoicePreview);
            invDialog.setVisible(true);
        }

        private void deleteInv() {
              int row=invoicePreview.getjTable1().getSelectedRow();
                   if(row!= -1){
                       invoicePreview.getInvoices().remove(row);
                       invoicePreview.getInvoiceTable().fireTableDataChanged();
                   }
                }
            }
