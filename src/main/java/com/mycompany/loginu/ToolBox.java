
package com.mycompany.loginu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ToolBox {
    
    public static void cleanjtxt(JTextField... fields){
        for(JTextField field : fields){
            field.setText("");
        }
    }
    
     public static boolean verPass(String password){
         
        boolean pUppercase = false;
        boolean pLowercase = false;
        boolean pNumber = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                pUppercase = true;
            } else if (Character.isLowerCase(c)) {
                pLowercase = true;
            } else if (Character.isDigit(c)) {
                pNumber = true;
            }
        }

        return pUppercase && pLowercase && pNumber;
    
    }
     
     public void loadQuery(){
        try {
            LogU.users.clear();
            
            DocumentBuilderFactory read = DocumentBuilderFactory.newInstance();
            DocumentBuilder folder = read.newDocumentBuilder();
            Document doc = folder.parse(new File("QueryCx.xml"));
            doc.getDocumentElement().normalize();
            
            NodeList lst = doc.getElementsByTagName("user");
            
            for (int i = 0; i < lst.getLength(); i++) {
                Node nod = lst.item(i);
                
                if (nod.getNodeType() == Node.ELEMENT_NODE) {
                    Element elmt = (Element)nod;
                    
                    User ur = new User();
                    
                    ur.setName(elmt.getElementsByTagName("name").item(0).getTextContent().trim());
                    ur.setUser(elmt.getElementsByTagName("usr").item(0).getTextContent().trim());
                    ur.setPassword(elmt.getElementsByTagName("password").item(0).getTextContent().trim());
                    ur.setRole(Integer.parseInt(elmt.getElementsByTagName("role").item(0).getTextContent().trim()));
                    
                    LogU.users.add(ur);
                }
            }   
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ToolBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ToolBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ToolBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void writeFiled(){
       
       FileWriter folder = null;
       PrintWriter write = null;
            try {
                folder = new FileWriter("QueryCx.xml");
                write = new PrintWriter(folder);
                
                write.println("<users>");
                
                    for(User us: LogU.users){
                        
                        write.println("<user>");
                            write.println("<name>"+us.getName()+"</name>");
                            write.println("<usr>"+us.getUser()+"</usr>");
                            write.println("<password>"+us.getPassword()+"</password>");
                            write.println("<role>"+us.getRole()+"</role>");
                        write.println("</user>");
                        
                    }
                write.println("</users>");
                
            } catch (IOException ex) {
                Logger.getLogger(ToolBox.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    folder.close();
                } catch (IOException ex) {
                    Logger.getLogger(ToolBox.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
   }
    
}
