import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.JFileChooser;
public class Client {
	ArrayList<String>clientNames=new ArrayList();
	JFrame frame =new JFrame("Mohd's Chat Client");
	JTextArea incoming;
	JTextArea userList;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;

	public void go() {

		incoming = new JTextArea(15,50);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true) ;
		incoming.setEditable(false);
		incoming.setFont(new Font("Arial", Font.PLAIN, 12));
		incoming.setBackground(Color.WHITE);

		userList = new JTextArea(15,10);
		userList.setEditable(false);
		userList.setFont(new Font("Arial", Font.PLAIN, 12));
		userList.setBackground(Color.LIGHT_GRAY);
		userList.setText("Online Users:\n(Press List button to update)");

		JScrollPane qScroller = new JScrollPane(incoming) ;
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS) ;
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane userScroller = new JScrollPane(userList);
		userScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		outgoing = new JTextField(20);
		outgoing.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton sendButton = new JButton("Send");
		JButton listButton = new JButton("List Users");
		JButton sendFileButton = new JButton("Send File");

		sendButton.addActionListener(new SendButtonListener());
		listButton.addActionListener(new listButtonListener());
		sendFileButton.addActionListener(new SendFileButtonListener());

		JPanel chatPanel = new JPanel(new BorderLayout());
		chatPanel.add(qScroller, BorderLayout.CENTER);

		JPanel inputPanel = new JPanel(new FlowLayout());
		inputPanel.add(outgoing);
		inputPanel.add(sendButton);
		inputPanel.add(listButton);
		inputPanel.add(sendFileButton);

		JPanel userPanel = new JPanel(new BorderLayout());
		userPanel.add(userScroller, BorderLayout.CENTER);
		userPanel.setBorder(BorderFactory.createTitledBorder("Online Users"));

		frame.setLayout(new BorderLayout());
		frame.add(chatPanel, BorderLayout.CENTER);
		frame.add(inputPanel, BorderLayout.SOUTH);
		frame.add(userPanel, BorderLayout.EAST);

		frame.getContentPane().setBackground(Color.GRAY);
		chatPanel.setBackground(Color.WHITE);
		inputPanel.setBackground(Color.LIGHT_GRAY);
		userPanel.setBackground(Color.WHITE);

		setUpNetworking();
		Thread readerThread=new Thread(new IncomingReader(reader,incoming));
		readerThread.start();
		frame.setSize(800,600);
		frame.setVisible(true);
	}

	public void setUpNetworking(){
		try {
			String ip="127.0.0.1";
			ip=JOptionPane.showInputDialog(null,"Enter server ip address","127.0.0.1");
			int port=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter server port number","9000"));
			//int p=Integer.parseInt(port);
			sock = new Socket(ip,port);
			InputStreamReader streamReader = new InputStreamReader(
					sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("Networking Established..");
			String name=JOptionPane.showInputDialog("Enter your name");
			if(name.contentEquals(""))name="Anonymous";
			String password=JOptionPane.showInputDialog("Enter password (123)");
			clientNames.add(name);
			incoming.append("Welcome "+name+" to Mohd's Chat Room!!\n Press list button to verify your connection !! \n If it is not functioning, Enter QUIT and try again :( ");

			writer.println(name + ":" + password) ;
			writer.flush() ;

			incoming.append("\n Whenever you wanna quit,enter 'QUIT' \n For sending private messages to any user Enter - '@<receiver> <message>'\nTo send private message to many users,\n Enter '@<receiver1> <receiver2> ...<receiverN>#<message>'\n");

		} catch (IOException e) {

		}
	}
	class SendButtonListener implements ActionListener
	{
	public void actionPerformed(ActionEvent ev) {
		try {

			if((outgoing.getText()).contains("QUIT"))frame.setVisible(false);
				writer.println(outgoing.getText()) ;
				writer.flush() ;
		}
				catch(Exception ex) {
						ex.printStackTrace() ;
				}
		outgoing.setText("");
		outgoing.requestFocus() ;
	}


}
	class listButtonListener implements ActionListener
	{
	public void actionPerformed(ActionEvent ev) {
		try {
			outgoing.setText("list");

			writer.println(outgoing.getText()) ;
			writer.flush() ;
		}
				catch(Exception ex) {
						ex.printStackTrace() ;
				}

		outgoing.setText("");
		outgoing.requestFocus() ;
	}


}
	class SendFileButtonListener implements ActionListener
	{
	public void actionPerformed(ActionEvent ev) {
		try {
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(frame);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String line;
				while((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				writer.println("FILE:" + file.getName() + ":" + sb.toString());
				writer.flush();
			}
		}
				catch(Exception ex) {
						ex.printStackTrace() ;
				}

	}


}


}
