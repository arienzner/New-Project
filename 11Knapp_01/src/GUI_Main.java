import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GUI_Main extends javax.swing.JFrame implements ActionListener{
	private JPanel panelBtns;
	private JLabel lblMessage;
	private JLabel lblContainer;
	private JButton btnAnnounce;
	private JButton btnRequest;
	private JScrollPane scrollList;
	private JPanel panel2;
	private JLabel lblStation;
	private JTextField txtContainer;
	private JTextField txtStationName;
	private JList ListMeldungen;
	private JTextField txtBefehl;
	private JButton btnReceive;
	private JButton btnSend;
	private JButton btnConnect;

	/**
	* Auto-generated main method to display this JFrame
	*/
	Server server = new Server();
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI_Main inst = new GUI_Main();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GUI_Main() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				panelBtns = new JPanel();
				GridLayout panelBtnsLayout = new GridLayout(5, 1);
				panelBtnsLayout.setHgap(5);
				panelBtnsLayout.setVgap(5);
				panelBtnsLayout.setColumns(1);
				panelBtns.setLayout(panelBtnsLayout);
				getContentPane().add(panelBtns);
				panelBtns.setBounds(12, 12, 92, 242);
				panelBtns.setBackground(new java.awt.Color(128,128,128));
				{
					btnConnect = new JButton();
					panelBtns.add(btnConnect);
					btnConnect.setText("Connect");
					btnConnect.addActionListener(this);
				}
				{
					btnSend = new JButton();
					panelBtns.add(btnSend);
					btnSend.setText("Send");
					btnSend.setPreferredSize(new java.awt.Dimension(91, 21));
					btnSend.addActionListener(this);
				}
				{
					btnReceive = new JButton();
					panelBtns.add(btnReceive);
					btnReceive.setText("Receive");
					btnReceive.addActionListener(this);
				}
				{
					btnAnnounce = new JButton();
					panelBtns.add(btnAnnounce);
					btnAnnounce.setText("Announce");
					btnAnnounce.addActionListener(this);
				}
				{
					btnRequest = new JButton();
					panelBtns.add(btnRequest);
					btnRequest.setText("Request");
					btnRequest.addActionListener(this);
				}
			}
			{
				txtBefehl = new JTextField();
				getContentPane().add(txtBefehl);
				txtBefehl.setBounds(154, 22, 341, 21);
			}
			{
				scrollList = new JScrollPane();
				getContentPane().add(scrollList);
				scrollList.setBounds(154, 55, 341, 152);
				{
					ListModel ListMeldungenModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					ListMeldungen = new JList();
					scrollList.setViewportView(ListMeldungen);
					ListMeldungen.setModel(ListMeldungenModel);
				}
			}
			{
				panel2 = new JPanel();
				getContentPane().add(panel2);
				panel2.setBounds(154, 219, 341, 82);
				panel2.setBackground(new java.awt.Color(128,128,128));
				panel2.setLayout(null);
				{
					txtStationName = new JTextField();
					panel2.add(txtStationName);
					txtStationName.setText("S2000");
					txtStationName.setBounds(243, 12, 86, 21);
				}
				{
					txtContainer = new JTextField();
					panel2.add(txtContainer);
					txtContainer.setBounds(243, 50, 86, 21);
				}
				{
					lblStation = new JLabel();
					panel2.add(lblStation);
					lblStation.setText("Station Name:");
					lblStation.setBounds(12, 15, 94, 14);
				}
				{
					lblContainer = new JLabel();
					panel2.add(lblContainer);
					lblContainer.setText("Container");
					lblContainer.setBounds(12, 53, 94, 14);
				}
			}
			{
				lblMessage = new JLabel();
				getContentPane().add(lblMessage);
				lblMessage.setText("...");
				lblMessage.setBounds(12, 313, 488, 19);
				lblMessage.setBackground(new java.awt.Color(255,255,128));
				lblMessage.setOpaque(true);
			}
			pack();
			this.setSize(520, 377);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnConnect){
			try {
				server.setConnection();
				lblMessage.setText("connected");
			} catch (Exception e1) {
				lblMessage.setText(e1.getMessage());
		
			}
		}
		
		if(e.getSource() == btnReceive){
			lblMessage.setText("received");
			
		}
		
	}

}
