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
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Tomek
 */
public class CustomerTreeModel extends DefaultMutableTreeNode{
// TODO Node editor
    public CustomerTreeModel(String s){
        try{createTree(s);} 
        catch(Exception e){System.out.println(e+" :zły format pliku tree.txt");
        }
    }

    private void createTree(String s) throws FileNotFoundException, IOException {
        //Format danych w pliku: "Node"/"Up"/Regon <TAB> Nazwa węzła/firmy
        BufferedReader br = new BufferedReader(new FileReader(s));
        DefaultMutableTreeNode tempNode;
        DefaultMutableTreeNode parentNode = this;
        for(String node ; (node = br.readLine())!=null;){
            String[] temp = node.split("\u0009");
            switch (temp[0]) {
                case "Node":
                    tempNode = new DefaultMutableTreeNode(temp[1]);
                    parentNode.add(tempNode);
                    parentNode = tempNode;
                    break;
                case "Up":
                    parentNode = (DefaultMutableTreeNode) parentNode.getParent();
                    break;
                default:
                    parentNode.add(new DefaultMutableTreeNode(new Customer(temp[0], temp[1])));
                    System.out.println("Customer "+temp[1]+" node created");
                    break;
            }
        }
    }
    
    
}

