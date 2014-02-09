/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.project1;


import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Taylor
 */
public class Client extends JPanel
{
    JLabel userL = new JLabel("User Name");
    JLabel hostL = new JLabel("Hostname");
    JLabel portL = new JLabel("Port Number");
    JTextField user = new JTextField(5);
    JTextField host = new JTextField(5);
    JTextField port = new JTextField(5);
    JTextField cmdLine = new JTextField();
    JScrollPane scroll;
    JTextArea display = new JTextArea();
    
    JButton login = new JButton("Login");
    JButton enterKey = new JButton(">>");
    String username;
    String hostname;
    String portNum;
    String cmd;
    
    
    
    
    public Client()
    {
        this.scroll = new JScrollPane(display);
        setLayout(new MigLayout("","[grow]15",""));
        guiFunc();
        login.addActionListener(new LoginListener());
        display.setEditable(false);
        enterKey.addActionListener(new EnterListener());
        user.setToolTipText("Type your Name");
        host.setToolTipText("Type in Server Address");
        port.setToolTipText("Type in the port #");
        cmdLine.setToolTipText("Type your Command Arguments");
        enterKey.setToolTipText("Enter Key");
//        scroll.addMouseWheelListener(new MouseWhListener());
        
    }//end Client Contructor
    
    public void guiFunc()
    {
        add(userL,"span 1, growx");
        add(hostL,"span 1, growx");
        add(portL,"span 2, wrap");
        add(user,"span 1, growx");
        add(host,"span 1, growx");
        add(port,"span 1, growx");
        add(login,"span 1, w 80!, wrap");
        add(scroll,"span 4, growx, growy, push, wrap");
        add(cmdLine, "span 3, growx, growy 50");
        add(enterKey, "span 1, w 80!, wrap");
    }

//    private static class MouseWhListener implements MouseWheelListener {
//
//        public void actionPerformed(ActionEvent event)
//        {
//            scroll.
//        }
//    }

    private class EnterListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            cmd = cmdLine.getText();
            display.setLineWrap(true);
            display.setWrapStyleWord(true);
            display.append("\n" + cmd + " " + username + " " + hostname + " " + portNum);
            
        }//end actionPerformed
        
    }//end subclass

    private class LoginListener implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            username = user.getText();
            hostname = host.getText();
            portNum = port.getText();
        }//end actionPerformed
    }//end subclass
    
    
}//end Client
