package be.ephec.eveStone.vieuw;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.ephec.eveStone.controller.Controller;

// TODO: Auto-generated Javadoc
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
* 
* @author Dasseler Nicolas & Vanbutsele Andy
*/
public class ConnectionFrame extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2984643889204700111L;
	
	/** The j text field ip. */
	private JTextField jTextFieldIP;
	
	/** The j text field port. */
	private JTextField jTextFieldPort;
	
	/** The j label port. */
	private JLabel jLabelPort;
	
	/** The j button make server. */
	private JButton jButtonMakeServer;
	
	/** The j label ip ex. */
	private JLabel jLabelIPEx;
	
	/** The j label2. */
	private JLabel jLabel2;
	
	/** The j button annuler. */
	private JButton jButtonAnnuler;
	
	/** The j button commencer. */
	private JButton jButtonCommencer;
	
	/** The j label1. */
	private JLabel jLabel1;
	
	/** The j panel menu. */
	private JPanel jPanelMenu;
	
	/** The j panel1. */
	private JPanel jPanel1;
	
	/** The j label exemple. */
	private JLabel jLabelExemple;

	/**
	 * Instantiates a new connection frame.
	 *
	 * @param controller the controller
	 */
	public ConnectionFrame(final Controller controller){
		super("Connexion");
		this.setResizable(false);
		initGUI();
	}
	
	/**
	 * Inits the gui.
	 */
	private void initGUI(){
		this.setSize(373, 571);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(new java.awt.Color(0,0,0));
		{
			jPanelMenu = new JPanel();
			GridBagLayout jPanelMenuLayout = new GridBagLayout();
			getContentPane().add(jPanelMenu, BorderLayout.SOUTH);
			jPanelMenu.setLayout(jPanelMenuLayout);
			jPanelMenu.setPreferredSize(new java.awt.Dimension(363, 378));
			jPanelMenu.setBackground(new java.awt.Color(0,0,0));
			{
				jButtonCommencer = new JButton();
				jPanelMenu.add(jButtonCommencer, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButtonCommencer.setLayout(null);
				jButtonCommencer.setText("<html><font color=white>Commencer</font></html>");
				jButtonCommencer.setBackground(new java.awt.Color(0,0,0));
			}
			{
				jButtonAnnuler = new JButton();
				jPanelMenu.add(jButtonAnnuler, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButtonAnnuler.setLayout(null);
				jButtonAnnuler.setText("<html><font color=white>Annuler</font></html>");
				jButtonAnnuler.setBackground(new java.awt.Color(0,0,0));
			}
			{
				jLabel2 = new JLabel();
				jPanelMenu.add(jLabel2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabel2.setText("<html><font color=white>Connexion :</font></html>");
				jLabel2.setLayout(null);
			}
			{
				jTextFieldIP = new JTextField();
				jPanelMenu.add(jTextFieldIP, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jLabelExemple = new JLabel();
				jPanelMenu.add(jLabelExemple, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabelExemple.setText("<html><font color=white>Exemple :</font></html>");
				jLabelExemple.setLayout(null);
			}
			{
				jLabelIPEx = new JLabel();
				jPanelMenu.add(jLabelIPEx, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabelIPEx.setText("<html><font color=white>192.168.x.x</html></font>");
				jLabelIPEx.setLayout(null);
			}
			{
				jButtonMakeServer = new JButton();
				jPanelMenu.add(jButtonMakeServer, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButtonMakeServer.setText("<html><font color=white>Démarrer le serveur</font></html>");
				jButtonMakeServer.setBackground(new java.awt.Color(0,0,0));
			}
			{
				jLabelPort = new JLabel();
				jPanelMenu.add(jLabelPort, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabelPort.setText("<html><font color=white>Port :</font></html>");
			}
			{
				jTextFieldPort = new JTextField();
				jPanelMenu.add(jTextFieldPort, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			jPanelMenuLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
			jPanelMenuLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7};
			jPanelMenuLayout.columnWeights = new double[] {0.1, 0.1, 0.0, 0.0, 0.1};
			jPanelMenuLayout.columnWidths = new int[] {7, 7, 25, 110, 7};
		}
		{
			jPanel1 = new JPanel();
			getContentPane().add(jPanel1, BorderLayout.NORTH);
			jPanel1.setPreferredSize(new java.awt.Dimension(290, 166));
			jPanel1.setBackground(new java.awt.Color(0,0,0));
			{
				jLabel1 = new JLabel();
				jPanel1.add(jLabel1);
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/logoConnexion.png")));
				jLabel1.setLayout(null);
				jLabel1.setBounds(47, 29, 200, 150);
			}
		}
	}
	
	/**
	 * Display.
	 */
	public void display(){
		this.setVisible(true);
	}
	
	
	/**
	 * Gets the j button annuler.
	 *
	 * @return the j button annuler
	 */
	public JButton getjButtonAnnuler() {
		return jButtonAnnuler;
	}

	/**
	 * Gets the j button commencer.
	 *
	 * @return the j button commencer
	 */
	public JButton getjButtonCommencer() {
		return jButtonCommencer;
	}

	/**
	 * Gets the j text field ip.
	 *
	 * @return the j text field ip
	 */
	public JTextField getjTextFieldIP() {
		return jTextFieldIP;
	}
	
	/**
	 * Gets the j button make server.
	 *
	 * @return the j button make server
	 */
	public JButton getjButtonMakeServer() {
		return jButtonMakeServer;
	}
	
	/**
	 * Gets the text field port.
	 *
	 * @return the text field port
	 */
	public JTextField getTextFieldPort(){
		return jTextFieldPort;
	}
	
}
