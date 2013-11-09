package eveStone.vieuw;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
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
public class GameArea extends javax.swing.JFrame {
	private JPanel jPanelMainHaut;
	private JPanel jPanelMainBas;
	private JLabel jLabelCimetiere;
	private JLabel jLabel2;
	private JLabel jLabelCimetière;
	private JLabel jLabel1;
	private JButton jButtonFinTour;
	private JPanel jPanelBattleArea;
	private JPanel jPanelHistory;
	private JPanel jPanelDeck;
	private JLabel jLabelDeck;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameArea inst = new GameArea();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GameArea() {
		super();
		initGUI();
	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height){
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(image, 0, 0, width, height, null);
		g2d.dispose();
		return bi;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanelMainHaut = new JPanel();
				GridBagLayout jPanelMainHautLayout = new GridBagLayout();
				getContentPane().add(jPanelMainHaut, BorderLayout.NORTH);
				jPanelMainHaut.setPreferredSize(new java.awt.Dimension(806, 92));
				jPanelMainHaut.setBackground(new java.awt.Color(191,191,191));
				jPanelMainHaut.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelMainHautLayout.rowWeights = new double[] {0.1};
				jPanelMainHautLayout.rowHeights = new int[] {7};
				jPanelMainHautLayout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanelMainHautLayout.columnWidths = new int[] {85, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
				jPanelMainHaut.setLayout(jPanelMainHautLayout);
				{
					jLabel2 = new JLabel();
					jPanelMainHaut.add(jLabel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					FlowLayout jLabel2Layout = new FlowLayout();
					jLabel2.setText(" ");
					jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/trou_noir.jpg")));
					jLabel2.setPreferredSize(new java.awt.Dimension(30,40));
					jLabel2.setLayout(null);
				}
			}
			{
				jPanelMainBas = new JPanel();
				GridBagLayout jPanelMainBasLayout = new GridBagLayout();
				getContentPane().add(jPanelMainBas, BorderLayout.SOUTH);
				jPanelMainBas.setPreferredSize(new java.awt.Dimension(806, 74));
				jPanelMainBas.setBackground(new java.awt.Color(191,191,191));
				jPanelMainBas.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelMainBasLayout.rowWeights = new double[] {0.1};
				jPanelMainBasLayout.rowHeights = new int[] {7};
				jPanelMainBasLayout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanelMainBasLayout.columnWidths = new int[] {86, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
				jPanelMainBas.setLayout(jPanelMainBasLayout);
				{
					jLabelCimetiere = new JLabel();
					jPanelMainBas.add(jLabelCimetiere, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					BufferedImage image=ImageIO.read(new File("img/trou_noir.jpg"));
					BufferedImage resizedImage=resize(image, 100, 100);
				}
			}
			{
				jPanelDeck = new JPanel();
				GridBagLayout jPanelDeckLayout = new GridBagLayout();
				jPanelDeckLayout.rowWeights = new double[] {0.0, 0.0, 0.1};
				jPanelDeckLayout.rowHeights = new int[] {169, 69, 7};
				jPanelDeckLayout.columnWeights = new double[] {0.1};
				jPanelDeckLayout.columnWidths = new int[] {7};
				getContentPane().add(jPanelDeck, BorderLayout.EAST);
				jPanelDeck.setPreferredSize(new java.awt.Dimension(105, 281));
				jPanelDeck.setBackground(new java.awt.Color(77,77,77));
				jPanelDeck.setBorder(BorderFactory.createTitledBorder(""));
				jPanelDeck.setLayout(jPanelDeckLayout);
				{
					jButtonFinTour = new JButton();
					jPanelDeck.add(jButtonFinTour, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jButtonFinTour.setText("Fin Tour");
				}
				{
					jLabelDeck = new JLabel();
					jPanelDeck.add(jLabelDeck, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDeck.setText(" ");
					jLabelDeck.setPreferredSize(new java.awt.Dimension(70, 100));
					jLabelDeck.setIcon(new ImageIcon(new ImageIcon("img/CarteDosV1.jpeg").getImage().getScaledInstance(jLabelDeck.getWidth(), jLabelDeck.getHeight(), Image.SCALE_AREA_AVERAGING)));
				}
				{
					jLabel1 = new JLabel();
					AnchorLayout jLabel1Layout = new AnchorLayout();
					jLabel1.setLayout(jLabel1Layout);
					jPanelDeck.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel1.setText(" ");
					jLabel1.setIcon(new ImageIcon(new ImageIcon("img/CarteDosV1.jpeg").getImage().getScaledInstance(jLabelDeck.getWidth(),jLabelDeck.getHeight(),Image.SCALE_AREA_AVERAGING)));
					jLabel1.setPreferredSize(new java.awt.Dimension(70,100));
				}
			}
			{
				jPanelHistory = new JPanel();
				getContentPane().add(jPanelHistory, BorderLayout.WEST);
				jPanelHistory.setPreferredSize(new java.awt.Dimension(105, 281));
				jPanelHistory.setBackground(new java.awt.Color(77,77,77));
				jPanelHistory.setBorder(BorderFactory.createTitledBorder(""));
			}
			{
				jPanelBattleArea = new JPanel();
				GridBagLayout jPanelBattleAreaLayout = new GridBagLayout();
				getContentPane().add(jPanelBattleArea, BorderLayout.CENTER);
				jPanelBattleArea.setBackground(new java.awt.Color(5,2,46));
				jPanelBattleAreaLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanelBattleAreaLayout.rowHeights = new int[] {7, 7, 7, 7};
				jPanelBattleAreaLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
				jPanelBattleAreaLayout.columnWidths = new int[] {7, 7, 7, 7, 7};
				jPanelBattleArea.setLayout(jPanelBattleAreaLayout);
			}
			pack();
			this.setSize(816, 580);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
