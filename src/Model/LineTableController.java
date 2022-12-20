package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class LineTableController extends AbstractTableModel {
    private ArrayList<InvoiceLine> lines;
    private String[] columns = {"No.", "Item Name","Item Price", "Count", "item Total"};

    public LineTableController(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    @Override
    public int getRowCount() {
        return lines.size();
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
        InvoiceLine line = lines.get(rowIndex);

        if (columnIndex == 0) {
            return line.getInvoice().getInvoiceNumber();
        } else if (columnIndex == 1) {
            return line.getItemName();
        } else if (columnIndex == 2) {
            return line.getItemPrice();
        } else if (columnIndex == 3) {
            return line.getCount();
        } else if (columnIndex==4) {
            return line.getTotal();
        }
         return null;
    }
}
