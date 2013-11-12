package eveStone.vieuw;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class StartFrame extends javax.swing.JFrame {
	private JPanel jPanelMenu;
	private JPanel jPanelTextArea;
	private JButton jButtonStart;
	private JButton jButtonExit;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StartFrame inst = new StartFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public StartFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanelMenu = new JPanel();
				GridBagLayout jPanelMenuLayout = new GridBagLayout();
				jPanelMenuLayout.columnWidths = new int[] {81, 238, 7};
				jPanelMenuLayout.rowHeights = new int[] {59, 147, 7};
				jPanelMenuLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
				jPanelMenuLayout.rowWeights = new double[] {0.0, 0.0, 0.1};
				getContentPane().add(jPanelMenu, BorderLayout.CENTER);
				jPanelMenu.setLayout(jPanelMenuLayout);
				jPanelMenu.setBackground(new java.awt.Color(77,77,77));
				{
					jPanelTextArea = new JPanel();
					GridBagLayout jPanelTextAreaLayout = new GridBagLayout();
					jPanelMenu.add(jPanelTextArea, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jPanelTextArea.setBackground(new java.awt.Color(77,77,77));
					jPanelTextAreaLayout.rowWeights = new double[] {0.1, 0.1};
					jPanelTextAreaLayout.rowHeights = new int[] {7, 7};
					jPanelTextAreaLayout.columnWeights = new double[] {0.1};
					jPanelTextAreaLayout.columnWidths = new int[] {7};
					jPanelTextArea.setLayout(jPanelTextAreaLayout);
					{
						jButtonStart = new JButton();
						jPanelTextArea.add(jButtonStart, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonStart.setText("Commencer");
						jButtonStart.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonStartActionPerformed(evt);
							}
						});
					}
					{
						jButtonExit = new JButton();
						jPanelTextArea.add(jButtonExit, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonExit.setText("Quitter");
						jButtonExit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonExitActionPerformed(evt);
							}
						});
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButtonStartActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonStart.actionPerformed, event="+evt);
		this.dispose();
		GameArea newGame = new GameArea();
		newGame.run();
	}
	
	private void jButtonExitActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonExit.actionPerformed, event="+evt);
		this.dispose();
	}

}
