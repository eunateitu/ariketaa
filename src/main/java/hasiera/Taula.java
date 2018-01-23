package hasiera;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Taula extends JFrame {

	
	public Taula() {
		super("Nire taula grafikoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final MyTableModelEzk MyTableModel = new MyTableModelEzk();
		final MyTableModelEsk MyTableModel2 = new MyTableModelEsk();
		final JTable table = new JTable(MyTableModel);
		final JTable table2 = new JTable(MyTableModel2);
		table.setRowHeight(50);
		table2.setRowHeight(50);
		JScrollPane scrollPane = new JScrollPane(table);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		JPanel behekoPanela = new JPanel();
		BoxLayout bl = new BoxLayout(behekoPanela, BoxLayout.X_AXIS);
		behekoPanela.setLayout(bl);
		add(scrollPane,BorderLayout.WEST);
		add(scrollPane2,BorderLayout.EAST);
		
		getContentPane().add(behekoPanela,BorderLayout.CENTER);
		JButton sartu = new JButton("Sartu");
		behekoPanela.add(sartu);
		JButton kendu = new JButton("Kendu");
		behekoPanela.add(kendu);
		JButton gorde = new JButton("Gorde");
		behekoPanela.add(gorde);
		pack();
		setVisible(true);
		
		sartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int errenkada= table.getSelectedRow(); //getSelectedRow() --> aukeratuta dagoen errenkadaren indizea bueltatzen du eta aukeratuta ez badago -1
				if(errenkada==-1) {					// errenkadarik aukeratuta ez badago
					errenkada = table.getRowCount()-1;		// getRowCount()--> errenkada kopurua bueltatzen du, beraz, errenkadarik aukeratuta ez badago kopurua-1 hautatuko du
				}
				try{ //--> try hay taulan errenkadarik ez badago errorerik ez ateratzeko jarrita dago baina obeto egongo litzateke if bategaz
					Lag emaitza = MyTableModel.errenkadaAtera(errenkada); //errenkada baten datu guztiak bueltatzen ditu (lag)
					MyTableModel2.addRow(emaitza); //addRow() --> taulan errenkada bat gehitzen du, sartu nahi den errenkada (lag) pasatu behar zaio
					int tamaina = table.getRowCount()-1; 
					MyTableModel.ezabatu(errenkada); //ezabatu() --> errenkada (lag) pasatuz taulatik errenkada hori borratzen du
				//	table.setRowSelectionInterval(tamaina,tamaina); // hemen ez da beharrezkoa azken errenkada hautatuta egoteko delako
				}
					catch(Exception a){
						System.out.println("Ez dago borratzeko gehiagorik");
					}
			}
		});
	
		kendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int errenkada= table2.getSelectedRow();
				if(errenkada==-1) {
					errenkada = table2.getRowCount()-1;
				}
				try{
				Lag emaitza = MyTableModel2.errenkadaAtera(errenkada);
				MyTableModel.addRow(emaitza);
				
				
				
					int tamaina = table2.getRowCount()-1;
					MyTableModel2.ezabatu(errenkada);
				//	table.setRowSelectionInterval(tamaina,tamaina);
				}
					catch(Exception a){
						System.out.println("Ez dago borratzeko gehiagorik");
					}
			}
			
		});
	gorde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			MyTableModel2.dbEguneratu(); // dbEguneratu() --> datu basea eguneratzen du (zegoena borratu eta berria sartu)
		}
	});
}
	
	
	public static void main(String[] args) {
		new Taula();
	}
}
