/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle.eye.clientmain;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tomek
 */
public class CustomerTableModel extends AbstractTableModel{
    private int rowCount;
    private Customer cust;
    
    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cust.getProductList().get(rowIndex).getProduct()[columnIndex];
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
        rowCount++;
        System.out.println("Data changed");
    }
    public void setCustomer(Customer c){
        cust = c;
    }
    
    
    
}
