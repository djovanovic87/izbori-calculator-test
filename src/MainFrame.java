import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JSeparator;
import javax.swing.JButton;

import org.apache.derby.iapi.util.StringUtil;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8424734531682214227L;
	private JPanel contentPane;
	private JPanel bbmPanel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblBrojBirackogMesta;
	private JTextField brojBirackogMestaTF;
	private JLabel lblBrojGlasacaSa;
	private JTextField brGlasacaSaPrGlasaTF;
	private JLabel lblBrojIzaslihGlasaca;
	private JTextField brojIzasloTF;
	private JLabel lblBrojNevazecihListica;
	private JTextField brojNevazecihTF;
	private JPanel generalPanel;
	private JPanel procenatPanel;
	private JMenuBar menuBar;
	private JMenu mnPodesavanja;
	private JMenuItem mntmIzlaz;
	private JLabel lblBrojIzaslihGlasaca_1;
	private JLabel lblBrojIzaslo;
	private JMenuItem mntmBrojDecimala;
	private int brojDecimala = 2;
	private JLabel lblBrojNevazecihListica_1;
	private JLabel lblBrojNevazecih;
	private JSeparator separator;
	private JButton btnIzracunaj;
	private JPanel panel_4;
	private JButton btnSacuvaj;
	private JLabel lblBrojVazecihListica_1;
	private JLabel lblBrojVazecih;
	private JButton btnObrisi;
	private JPanel leviPanel;
	private JPanel izborneListePanel;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_3;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JLabel lblBm;
	private JLabel lblBm_1;
	private JLabel lblBm_2;
	private JLabel lblBm_3;
	private JLabel lblBm_4;
	private JLabel lblBm_5;
	private JLabel lblBm_6;
	private JLabel lblBm_7;
	private JLabel lblBm_8;
	private JLabel lblBm_9;
	private JLabel lblBm_10;
	private JLabel lblBm_11;
	private JLabel lblBm_12;
	private JLabel lblBm_13;
	private JLabel lblBm_14;
	private JLabel lblBm_15;
	private JLabel lblBm_16;
	private JLabel lblBm_17;
	private JLabel lblBm_18;
	private JTextField tfBr1;
	private JTextField tfBr2;
	private JTextField tfBr3;
	private JTextField tfBr4;
	private JTextField tfBr5;
	private JTextField tfBr6;
	private JTextField tfBr7;
	private JTextField tfBr8;
	private JTextField tfBr9;
	private JTextField tfBr10;
	private JTextField tfBr11;
	private JTextField tfBr12;
	private JTextField tfBr13;
	private JTextField tfBr14;
	private JTextField tfBr15;
	private JTextField tfBr16;
	private JTextField tfBr17;
	private JTextField tfBr18;
	private JTextField tfBr19;
	
	Database database;
	private JPanel panel_23;
	private JButton btnUcitaj;
	private JSeparator separator_2;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void obrisiPolja() {
		brojBirackogMestaTF.setText("");
		brGlasacaSaPrGlasaTF.setText("");
		brojIzasloTF.setText("");
		brojNevazecihTF.setText("");
		lblBrojIzaslo.setText("0.00%");
		lblBrojNevazecih.setText("0.00%");
		lblBrojVazecih.setText("0.00%");
		
		tfBr1.setText("");
		tfBr2.setText("");
		tfBr3.setText("");
		tfBr4.setText("");
		tfBr5.setText("");
		tfBr6.setText("");
		tfBr7.setText("");
		tfBr8.setText("");
		tfBr9.setText("");
		tfBr10.setText("");
		tfBr11.setText("");
		tfBr12.setText("");
		tfBr13.setText("");
		tfBr14.setText("");
		tfBr15.setText("");
		tfBr16.setText("");
		tfBr17.setText("");
		tfBr18.setText("");
		tfBr19.setText("");
	}
	
	public void izracunaj() {
		int brojSaPravomGlasa = Integer.valueOf(brGlasacaSaPrGlasaTF.getText());
		int brojIzaslih = Integer.valueOf(brojIzasloTF.getText());
		int brojNevazecih = Integer.valueOf(brojNevazecihTF.getText());
		double procIzaslo = brojIzaslih * 100.0 / brojSaPravomGlasa;
		double procNevazecih = brojNevazecih * 100.0 / brojIzaslih;
		double procVazecih = 100 - procNevazecih;
		lblBrojIzaslo.setText(String.format("%." + String.valueOf(brojDecimala) + "f", procIzaslo) + "%");
		lblBrojNevazecih.setText(String.format("%." + String.valueOf(brojDecimala) + "f", procNevazecih) + "%");
		lblBrojVazecih.setText(String.format("%." + String.valueOf(brojDecimala) + "f", procVazecih) + "%");
	}
	
	public Map<String, String> createMapFromValues() {
		Map<String, String> map = new HashMap<String, String>();
		
		setZerosForEmpty();
		map.put("id", brojBirackogMestaTF.getText());
		map.put("broj_glasaca", brGlasacaSaPrGlasaTF.getText());
		map.put("broj_izaslo", brojIzasloTF.getText());
		map.put("broj_nevazecih", brojNevazecihTF.getText());
		map.put("br1", tfBr1.getText());
		map.put("br2", tfBr2.getText());
		map.put("br3", tfBr3.getText());
		map.put("br4", tfBr4.getText());
		map.put("br5", tfBr5.getText());
		map.put("br6", tfBr6.getText());
		map.put("br7", tfBr7.getText());
		map.put("br8", tfBr8.getText());
		map.put("br9", tfBr9.getText());
		map.put("br10", tfBr10.getText());
		map.put("br11", tfBr11.getText());
		map.put("br12", tfBr12.getText());
		map.put("br13", tfBr13.getText());
		map.put("br14", tfBr14.getText());
		map.put("br15", tfBr15.getText());
		map.put("br16", tfBr16.getText());
		map.put("br17", tfBr17.getText());
		map.put("br18", tfBr18.getText());
		map.put("br19", tfBr19.getText());
		return map;
	}

	private void setZerosForEmpty() {
		if(brGlasacaSaPrGlasaTF.getText().equals("")) brGlasacaSaPrGlasaTF.setText("0");
		if(brojIzasloTF.getText().equals("")) brojIzasloTF.setText("0");
		if(brojNevazecihTF.getText().equals("")) brojNevazecihTF.setText("0");
		if(tfBr1.getText().equals("")) tfBr1.setText("0");
		if(tfBr2.getText().equals("")) tfBr2.setText("0");
		if(tfBr3.getText().equals("")) tfBr3.setText("0");
		if(tfBr4.getText().equals("")) tfBr4.setText("0");
		if(tfBr5.getText().equals("")) tfBr5.setText("0");
		if(tfBr6.getText().equals("")) tfBr6.setText("0");
		if(tfBr7.getText().equals("")) tfBr7.setText("0");
		if(tfBr8.getText().equals("")) tfBr8.setText("0");
		if(tfBr9.getText().equals("")) tfBr9.setText("0");
		if(tfBr10.getText().equals("")) tfBr10.setText("0");
		if(tfBr11.getText().equals("")) tfBr11.setText("0");
		if(tfBr12.getText().equals("")) tfBr12.setText("0");
		if(tfBr13.getText().equals("")) tfBr13.setText("0");
		if(tfBr14.getText().equals("")) tfBr14.setText("0");
		if(tfBr15.getText().equals("")) tfBr15.setText("0");
		if(tfBr16.getText().equals("")) tfBr16.setText("0");
		if(tfBr17.getText().equals("")) tfBr17.setText("0");
		if(tfBr18.getText().equals("")) tfBr18.setText("0");
		if(tfBr19.getText().equals("")) tfBr19.setText("0");
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		database = new Database();
		database.init();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 685);
		setTitle("Izbori calculator");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPodesavanja = new JMenu("Podesavanja");
		menuBar.add(mnPodesavanja);
		
		mntmBrojDecimala = new JMenuItem("Broj decimala");
		mntmBrojDecimala.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String input = JOptionPane.showInputDialog(null, "Broj decimala u opsegu 0-4", "Broj decimala", 1);
				int dec = Integer.valueOf(input);
				if(dec >=0 && dec < 5) {
					brojDecimala = dec;
					izracunaj();
				}
			}
		});
		mnPodesavanja.add(mntmBrojDecimala);
		
		mntmIzlaz = new JMenuItem("Izlaz");
		mnPodesavanja.add(mntmIzlaz);
		mntmIzlaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		leviPanel = new JPanel();
		contentPane.add(leviPanel);
		
		generalPanel = new JPanel();
		leviPanel.add(generalPanel);
		
		bbmPanel = new JPanel();
		bbmPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblBrojBirackogMesta = new JLabel("Broj birackog mesta");
		bbmPanel.add(lblBrojBirackogMesta);
		
		brojBirackogMestaTF = new JTextField();
		bbmPanel.add(brojBirackogMestaTF);
		brojBirackogMestaTF.setColumns(10);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblBrojGlasacaSa = new JLabel("Broj glasaca sa pravom glasa");
		panel.add(lblBrojGlasacaSa);
		
		brGlasacaSaPrGlasaTF = new JTextField();
		panel.add(brGlasacaSaPrGlasaTF);
		brGlasacaSaPrGlasaTF.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblBrojIzaslihGlasaca = new JLabel("Broj izaslih glasaca");
		panel_1.add(lblBrojIzaslihGlasaca);
		
		brojIzasloTF = new JTextField();
		panel_1.add(brojIzasloTF);
		brojIzasloTF.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblBrojNevazecihListica = new JLabel("Broj nevazecih listica");
		panel_2.add(lblBrojNevazecihListica);
		
		brojNevazecihTF = new JTextField();
		panel_2.add(brojNevazecihTF);
		brojNevazecihTF.setColumns(10);
		generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.Y_AXIS));
		generalPanel.add(bbmPanel);
		generalPanel.add(panel);
		generalPanel.add(panel_1);
		generalPanel.add(panel_2);
		
		separator = new JSeparator();
		generalPanel.add(separator);
		
		panel_4 = new JPanel();
		generalPanel.add(panel_4);
		
		btnIzracunaj = new JButton("Izracunaj");
		panel_4.add(btnIzracunaj);
		btnIzracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izracunaj();
//				int brojSaPravomGlasa = Integer.valueOf(brGlasacaSaPrGlasaTF.getText());
//				int brojIzaslih = Integer.valueOf(brojIzasloTF.getText());
//				int brojNevazecih = Integer.valueOf(brojNevazecihTF.getText());
//				double procIzaslo = brojIzaslih * 100.0 / brojSaPravomGlasa;
//				double procNevazecih = brojNevazecih * 100.0 / brojIzaslih;
//				double procVazecih = 100 - procNevazecih;
//				lblBrojIzaslo.setText(String.format("%." + String.valueOf(brojDecimala) + "f", procIzaslo) + "%");
//				lblBrojNevazecih.setText(String.format("%." + String.valueOf(brojDecimala) + "f", procNevazecih) + "%");
//				lblBrojVazecih.setText(String.format("%." + String.valueOf(brojDecimala) + "f", procVazecih) + "%");
			}
		});
		btnIzracunaj.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnObrisi = new JButton("Obrisi");
		panel_4.add(btnObrisi);
		btnObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				obrisiPolja();
			}
		});
		
		panel_23 = new JPanel();
		generalPanel.add(panel_23);
		
		btnSacuvaj = new JButton("Sacuvaj");
		panel_23.add(btnSacuvaj);
		btnSacuvaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Sacuvaj", JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
					Map<String, String> map = createMapFromValues();
					if(!database.insert(map)) {
						int confirmUpdate = JOptionPane.showConfirmDialog(null, "Unos za izborno mesto " + map.get("id") + " vec postoji. Ukoliko nastavite, podaci ce biti snimljeni preko postojecih.", "Sacuvaj", JOptionPane.YES_NO_OPTION);
						if(confirmUpdate == 0) {
							if(!database.update(map)){
								JOptionPane.showMessageDialog(null, "Greska!");
							} else {
								JOptionPane.showMessageDialog(null, "Uspesno azurirano!");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Uspesno sacuvano!");
						obrisiPolja();
					}
				}
				
			}
		});
		
		btnUcitaj = new JButton("Ucitaj");
		panel_23.add(btnUcitaj);
		btnUcitaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Da li ste sigurni? Trenutni unosi ce biti obrisani.", "Ucitaj", JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0) {
					String input = JOptionPane.showInputDialog(null, "Unesite broj izbornog mesta", "Ucitaj", 1);
					try {
						ResultSet resultSet = database.select(input);
						resultSet.next();
						brojBirackogMestaTF.setText(String.valueOf(resultSet.getInt("id")));
						brGlasacaSaPrGlasaTF.setText(String.valueOf(resultSet.getInt("broj_glasaca")));
						brojIzasloTF.setText(String.valueOf(resultSet.getInt("broj_izaslo")));
						brojNevazecihTF.setText(String.valueOf(resultSet.getInt("broj_nevazecih")));
						tfBr1.setText(String.valueOf(resultSet.getInt("br1")));
						tfBr2.setText(String.valueOf(resultSet.getInt("br2")));
						tfBr3.setText(String.valueOf(resultSet.getInt("br3")));
						tfBr4.setText(String.valueOf(resultSet.getInt("br4")));
						tfBr5.setText(String.valueOf(resultSet.getInt("br5")));
						tfBr6.setText(String.valueOf(resultSet.getInt("br6")));
						tfBr7.setText(String.valueOf(resultSet.getInt("br7")));
						tfBr8.setText(String.valueOf(resultSet.getInt("br8")));
						tfBr9.setText(String.valueOf(resultSet.getInt("br9")));
						tfBr10.setText(String.valueOf(resultSet.getInt("br10")));
						tfBr11.setText(String.valueOf(resultSet.getInt("br11")));
						tfBr12.setText(String.valueOf(resultSet.getInt("br12")));
						tfBr13.setText(String.valueOf(resultSet.getInt("br13")));
						tfBr14.setText(String.valueOf(resultSet.getInt("br14")));
						tfBr15.setText(String.valueOf(resultSet.getInt("br15")));
						tfBr16.setText(String.valueOf(resultSet.getInt("br16")));
						tfBr17.setText(String.valueOf(resultSet.getInt("br17")));
						tfBr18.setText(String.valueOf(resultSet.getInt("br18")));
						tfBr19.setText(String.valueOf(resultSet.getInt("br19")));
						
						izracunaj();
					} catch(SQLException e) {
						
					}
					
				}
			}
		});
		
		separator_2 = new JSeparator();
		generalPanel.add(separator_2);
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		procenatPanel = new JPanel();
		leviPanel.add(procenatPanel);
		procenatPanel.setLayout(new BoxLayout(procenatPanel, BoxLayout.Y_AXIS));
		
		separator_1 = new JSeparator();
		procenatPanel.add(separator_1);
		
		lblBrojIzaslihGlasaca_1 = new JLabel("Procenat izaslo");
		lblBrojIzaslihGlasaca_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		procenatPanel.add(lblBrojIzaslihGlasaca_1);
		
		lblBrojIzaslo = new JLabel("0.00%");
		lblBrojIzaslo.setForeground(Color.red);
		lblBrojIzaslo.setAlignmentX(Component.CENTER_ALIGNMENT);
		procenatPanel.add(lblBrojIzaslo);
		
		lblBrojNevazecihListica_1 = new JLabel("Procenat nevazecih listica");
		lblBrojNevazecihListica_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		procenatPanel.add(lblBrojNevazecihListica_1);
		
		lblBrojNevazecih = new JLabel("0.00%");
		lblBrojNevazecih.setForeground(Color.red);
		lblBrojNevazecih.setAlignmentX(Component.CENTER_ALIGNMENT);
		procenatPanel.add(lblBrojNevazecih);
		
		lblBrojVazecihListica_1 = new JLabel("Procenat vazecih listica");
		lblBrojVazecihListica_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		procenatPanel.add(lblBrojVazecihListica_1);
		
		lblBrojVazecih = new JLabel("0.00%");
		lblBrojVazecih.setForeground(Color.red);
		lblBrojVazecih.setAlignmentX(Component.CENTER_ALIGNMENT);
		procenatPanel.add(lblBrojVazecih);
		
		izborneListePanel = new JPanel();
		contentPane.add(izborneListePanel);
		izborneListePanel.setLayout(new BoxLayout(izborneListePanel, BoxLayout.Y_AXIS));
		
		panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_5);
		
		lblBm = new JLabel("bm1");
		panel_5.add(lblBm);
		
		tfBr1 = new JTextField();
		panel_5.add(tfBr1);
		tfBr1.setColumns(10);
		
		panel_6 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_6);
		
		lblBm_1 = new JLabel("bm2");
		panel_6.add(lblBm_1);
		
		tfBr2 = new JTextField();
		panel_6.add(tfBr2);
		tfBr2.setColumns(10);
		
		panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_7);
		
		lblBm_2 = new JLabel("bm3");
		panel_7.add(lblBm_2);
		
		tfBr3 = new JTextField();
		panel_7.add(tfBr3);
		tfBr3.setColumns(10);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_3);
		
		lblBm_3 = new JLabel("bm4");
		panel_3.add(lblBm_3);
		
		tfBr4 = new JTextField();
		panel_3.add(tfBr4);
		tfBr4.setColumns(10);
		
		panel_8 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_8);
		
		lblBm_4 = new JLabel("bm5");
		panel_8.add(lblBm_4);
		
		tfBr5 = new JTextField();
		panel_8.add(tfBr5);
		tfBr5.setColumns(10);
		
		panel_9 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_9.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_9);
		
		lblBm_5 = new JLabel("bm6");
		panel_9.add(lblBm_5);
		
		tfBr6 = new JTextField();
		panel_9.add(tfBr6);
		tfBr6.setColumns(10);
		
		panel_10 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_10.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_10);
		
		lblBm_6 = new JLabel("bm7");
		panel_10.add(lblBm_6);
		
		tfBr7 = new JTextField();
		panel_10.add(tfBr7);
		tfBr7.setColumns(10);
		
		panel_11 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_11.getLayout();
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_11);
		
		lblBm_7 = new JLabel("bm8");
		panel_11.add(lblBm_7);
		
		tfBr8 = new JTextField();
		panel_11.add(tfBr8);
		tfBr8.setColumns(10);
		
		panel_12 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_12.getLayout();
		flowLayout_8.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_12);
		
		lblBm_8 = new JLabel("bm9");
		panel_12.add(lblBm_8);
		
		tfBr9 = new JTextField();
		panel_12.add(tfBr9);
		tfBr9.setColumns(10);
		
		panel_13 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_13.getLayout();
		flowLayout_9.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_13);
		
		lblBm_9 = new JLabel("bm10");
		panel_13.add(lblBm_9);
		
		tfBr10 = new JTextField();
		panel_13.add(tfBr10);
		tfBr10.setColumns(10);
		
		panel_14 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_14.getLayout();
		flowLayout_10.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_14);
		
		lblBm_10 = new JLabel("bm11");
		panel_14.add(lblBm_10);
		
		tfBr11 = new JTextField();
		panel_14.add(tfBr11);
		tfBr11.setColumns(10);
		
		panel_15 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_15.getLayout();
		flowLayout_11.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_15);
		
		lblBm_11 = new JLabel("bm12");
		panel_15.add(lblBm_11);
		
		tfBr12 = new JTextField();
		panel_15.add(tfBr12);
		tfBr12.setColumns(10);
		
		panel_16 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_16.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_16);
		
		lblBm_12 = new JLabel("bm13");
		panel_16.add(lblBm_12);
		
		tfBr13 = new JTextField();
		panel_16.add(tfBr13);
		tfBr13.setColumns(10);
		
		panel_17 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_17.getLayout();
		flowLayout_13.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_17);
		
		lblBm_13 = new JLabel("bm14");
		panel_17.add(lblBm_13);
		
		tfBr14 = new JTextField();
		panel_17.add(tfBr14);
		tfBr14.setColumns(10);
		
		panel_18 = new JPanel();
		FlowLayout flowLayout_14 = (FlowLayout) panel_18.getLayout();
		flowLayout_14.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_18);
		
		lblBm_14 = new JLabel("bm15");
		panel_18.add(lblBm_14);
		
		tfBr15 = new JTextField();
		panel_18.add(tfBr15);
		tfBr15.setColumns(10);
		
		panel_19 = new JPanel();
		FlowLayout flowLayout_15 = (FlowLayout) panel_19.getLayout();
		flowLayout_15.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_19);
		
		lblBm_15 = new JLabel("bm16");
		panel_19.add(lblBm_15);
		
		tfBr16 = new JTextField();
		panel_19.add(tfBr16);
		tfBr16.setColumns(10);
		
		panel_20 = new JPanel();
		FlowLayout flowLayout_16 = (FlowLayout) panel_20.getLayout();
		flowLayout_16.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_20);
		
		lblBm_16 = new JLabel("bm17");
		panel_20.add(lblBm_16);
		
		tfBr17 = new JTextField();
		panel_20.add(tfBr17);
		tfBr17.setColumns(10);
		
		panel_21 = new JPanel();
		FlowLayout flowLayout_17 = (FlowLayout) panel_21.getLayout();
		flowLayout_17.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_21);
		
		lblBm_17 = new JLabel("bm18");
		panel_21.add(lblBm_17);
		
		tfBr18 = new JTextField();
		panel_21.add(tfBr18);
		tfBr18.setColumns(10);
		
		panel_22 = new JPanel();
		FlowLayout flowLayout_18 = (FlowLayout) panel_22.getLayout();
		flowLayout_18.setAlignment(FlowLayout.RIGHT);
		izborneListePanel.add(panel_22);
		
		lblBm_18 = new JLabel("bm19");
		panel_22.add(lblBm_18);
		
		tfBr19 = new JTextField();
		panel_22.add(tfBr19);
		tfBr19.setColumns(10);
	}
	
	

}
