package be.ephec.eveStone.vieuw;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class testAddCarte extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel jLabelNom;
	private JLabel jLabelDegats;
	private JLabel jLabelDescription;
	private JLabel jLabelRessources;
	private JLabel jLabelPv;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				testAddCarte inst = new testAddCarte("Drone", 5, 5, 5, "ceci est un test");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public testAddCarte(String nom, int ressource, int pv, int degats, String description) {
		super();
		initGUI(nom, ressource, pv, degats, description);
	}
	
	private void initGUI(String nom, int ressource, int pv, int degats, String description) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				jPanel1.setPreferredSize(new java.awt.Dimension(243, 330));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/CarteFaceV2.png")));
					this.setContentPane(jLabel1);
					{
						jLabelPv = new JLabel();
						jLabel1.add(jLabelPv);
						jLabelPv.setText("<html><font color=white><b>" + pv + "</b></font></html>");
						jLabelPv.setBounds(165, 236, 28, 38);
						jLabelPv.setFont(new java.awt.Font("Segoe UI",0,20));
					}
					{
						jLabelDegats = new JLabel();
						jLabel1.add(jLabelDegats);
						jLabelDegats.setText("<html><font color=white><b>" + degats + "</b></font></html>");
						jLabelDegats.setBounds(24, 239, 37, 33);
						jLabelDegats.setFont(new java.awt.Font("Segoe UI",0,20));
					}
					{
						jLabelDescription = new JLabel();
						jLabel1.add(jLabelDescription);
						jLabelDescription.setText("<html><font color=red>" + description + "</font></html>");
						jLabelDescription.setBounds(41, 173, 118, 76);
					}
					{
						jLabelRessources = new JLabel();
						jLabel1.add(jLabelRessources);
						jLabelRessources.setText("<html><font color=white><b>" + ressource + "</b></font></html>");
						jLabelRessources.setBounds(24, 12, 42, 32);
						jLabelRessources.setFont(new java.awt.Font("Segoe UI",0,20));
					}
					{
						jLabelNom = new JLabel();
						jLabel1.add(jLabelNom);
						jLabelNom.setText("<html><font color=red><b>" + nom + "</b></font></html>");
						jLabelNom.setBounds(61, 139, 94, 16);
					}
				}
			}
			pack();
			this.setSize(212, 328);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
