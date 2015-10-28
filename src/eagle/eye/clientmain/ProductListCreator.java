/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle.eye.clientmain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Tomek
 */
public class ProductListCreator implements Runnable {
    //private String path;
    private ArrayList<String> path;
    private Thread thread;
    private Customer cust;
    private CustomerTableModel table;
    public ProductListCreator(CustomerTableModel table) {
        this.table = table;
    }

    
    @Override
    public void run() {
        BufferedReader br;
        HashMap<String, Product> map = new HashMap<>();
        for(String p : path){
            System.out.println(p);
        try {
            br = new BufferedReader(new FileReader(p));
        } catch (FileNotFoundException ex) {
            continue;
        }
        try {
            for(String temp;(temp = br.readLine()) != null;){
                String[] tempArray = temp.split("\u0009");
                if(map.containsKey(tempArray[1])){
                    map.get(tempArray[1]).setQuantity(Integer.parseInt(tempArray[2]));
                }
                else
                {
                    map.put(tempArray[1], new Product(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2])));
                    getCust().getProductList().add(map.get(tempArray[1]));
                    System.out.println(getCust().getProductList().get(0).getProduct()[0]);
                    getTable().fireTableDataChanged();
                    getTable().getValueAt(0, 0);
                }
                
            }
                 br.close(); 
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Niepoprawny format pliku z listą produktów");
        }
      
        }
        
        
        
    }
    public void find(JXDatePicker dp1, JXDatePicker dp2){
        thread = new Thread(this);
        path = calculatePaths(formatDate(dp1, dp2));
        getThread().start();
    }

    /**
     * @return the path
     */

    /**
     * @return the thread
     */
    public Thread getThread() {
        return thread;
    }

    /**
     * @return the cust
     */
    public Customer getCust() {
        return cust;
    }

    /**
     * @return the table
     */
    public CustomerTableModel getTable() {
        return table;
    }

    public ArrayList<String> formatDate(JXDatePicker dp1, JXDatePicker dp2){
        //Variable declarations
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        ArrayList<String> formattedDate = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        boolean finishedParsing = false;
        Date fromDate, toDate;
        
        //Date assigments
        if(dp1.getDate().before(dp2.getDate())){
            fromDate = dp1.getDate();
            toDate = dp2.getDate();
        } else if(dp1.getDate().after(dp2.getDate())){
            fromDate = dp2.getDate();
            toDate = dp1.getDate();
        } else {
            formattedDate.add(formatter.format(dp1.getDate()));
            return formattedDate;
        }
        cal.setLenient(false);
        cal.setTime(fromDate);
        
        //Actual parsing to string
        while(!finishedParsing){
           formattedDate.add(formatter.format(cal.getTime()));
           cal.add(Calendar.DATE, 1);
           System.out.println(cal.getTime());
           if(cal.getTime().compareTo(toDate) == 0){
               finishedParsing = true;
               formattedDate.add(formatter.format(cal.getTime()));
           }
        }

        return formattedDate;
    }
    public void setCustomer(Customer cust){
        this.cust = cust;
        table.setCustomer(cust);
    }

    public ArrayList<String> calculatePaths(ArrayList<String> dates){
        ArrayList<String> paths = new ArrayList<>();
        dates.forEach((e)-> paths.add(e+"/"+getCust().getRegon()));
        return paths;
    }
}
