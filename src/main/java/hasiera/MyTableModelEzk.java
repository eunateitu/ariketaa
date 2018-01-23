package hasiera;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import kudeatzaile.PertsonaKud;

public class MyTableModelEzk extends AbstractTableModel {
	
	private Vector<Lag> data = new Vector<Lag>();
	private Vector<String> columnNames = new Vector<String>();

	
	public MyTableModelEzk() {
		kargatu();
	}
	
	public boolean isCellEditable(int row, int col){ //editatu ahal izateko
		return true;
	}
	
	public void setValueAt(Object value, int row, int col){ //taulan balioak editatu ahal izateko (editable)
		Lag lerroa = data.get(row);
		lerroa.insertElementAt(value, col);
		fireTableCellUpdated(row,col);
	}
	
	public void kargatu(){
		
//		data.add(new Lag("Kathy", "Smith", "Snowboarding", 5, false));
//		data.add(new Lag("John", "Doe", "Rowing", 3, true));
//		data.add(new Lag("Sue", "Black", "Knitting", 2, true));
//		data.add(new Lag("Jane", "White", "Speed reading", 20, true));
		
		hasieratuZutabeIzenak();
		Vector <Object[]> pertsonaLista = PertsonaKud.getInstantzia().getPertsona();
		for(Object [] s : pertsonaLista ){
			System.out.println(s[0]);
			String i = s[0].toString();
			String a = s[1].toString();
			String k = s[2].toString();
			String inte = s[3].toString();
			Integer t = Integer.parseInt(inte);
			String integ = s[4].toString();
			Boolean bz = Boolean.parseBoolean(integ);
			
			data.add(new Lag(i,a,k,t,bz));
		}
	}
	
	public void addRow(Lag lag){
		data.add(lag);
		fireTableStructureChanged();
	}
	
	public void ezabatu(int hautatutakoa){
		data.remove(hautatutakoa);
		fireTableStructureChanged();
		}
	
	public int getRowCount() {
		return data.size();
	}
	
	public void hasieratuZutabeIzenak(){
		columnNames.add("izena");
		columnNames.add("abizena");
		columnNames.add("kirola");
		columnNames.add("tamaina");
		columnNames.add("baiez");
		columnNames.addElement("argazkia");
	}

	public int getColumnCount() {
		return columnNames.size();
	}
	
	public String getColumnName(int i){
		return columnNames.get(i);
	}
	
	public Class<?> getColumnClass(int col){
		Class<?> klasea = null;
		switch (col){	
		case 0:
			klasea = String.class;
		break;
		case 1:
			klasea = String.class;
			break;
		case 2:
			klasea = String.class;
			break;
		case 3:
			klasea = Integer.class;
			break;
		case 4:
			klasea = Boolean.class;
			break;
				
		case 5:
			klasea = ImageIcon.class;
		}
		return klasea;
		
	}

	public Lag errenkadaAtera(int errenkada){
		
		Lag emaitza = data.get(errenkada);
		return emaitza;
	}
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return data.get(rowIndex).getBalioa(columnIndex);
		}
	public void dbEguneratu (){
		kudeatzaile.PertsonaKud.getInstantzia().DBaEzabatu();
		kudeatzaile.PertsonaKud.getInstantzia().DBanGorde(data);
	}
	
	public static void main(String[] args) {
		MyTableModelEsk taula = new MyTableModelEsk();
		System.out.println("Lerroak:" + taula.getRowCount());
		System.out.println("Zutabeak:" + taula.getColumnCount());
		System.out.println("(2,2) elementuaren balioa:" + taula.getValueAt(2, 2));
		System.out.println("Lehenengo zutabearen izena:" + taula.getColumnName(0));
		
		}
}