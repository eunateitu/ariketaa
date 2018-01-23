package hasiera;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;


import kudeatzaile.KudeatzaileSQLite;
import kudeatzaile.PertsonaKud;
public class Lag {
	String izena;
	String abizena;
	String kirola;
	Integer tamaina;
	Boolean baiez;
	ImageIcon argazkia;

	
	public Lag(String izena, String abizena, String kirola, Integer tamaina, boolean baiez){
		this(izena, abizena, kirola, tamaina, baiez, "/pics/person.png");
	}
	public Lag(String izena, String abizena, String kirola, Integer tamaina, Boolean baiez, String argazkia) {
		super();
		this.izena = izena;
		this.abizena = abizena;
		this.kirola = kirola;
		this.tamaina = tamaina;
		this.baiez = baiez;
		//this.argazkia = new ImageIcon("person.png");
		String path = "";
		try {
			path = this.getClass().getResource(argazkia).getPath();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(argazkia+"  not found");
		}
		Image irudia = new ImageIcon(path).getImage();
		ImageIcon irudiaIcon = new ImageIcon(irudia.getScaledInstance(-5, 50, java.awt.Image.SCALE_SMOOTH));
		this.argazkia = irudiaIcon;
	}


	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	public String getKirola() {
		return kirola;
	}
	public void setKirola(String kirola) {
		this.kirola = kirola;
	}
	public Integer getTamaina() {
		return tamaina;
	}
	public void setTamaina(Integer tamaina) {
		this.tamaina = tamaina;
	}
	public Boolean getBaiez() {
		return baiez;
	}
	public void setBaiez(Boolean baiez) {
		this.baiez = baiez;
	}
	public ImageIcon getArgazkia() {
		return argazkia;
	}
	public void setArgazkia(ImageIcon argazkia) {
		this.argazkia = argazkia;
	}
	public Object getBalioa(int i) {
		Object emaitza = null;
		switch (i){	
		case 0:
			emaitza = izena;
		break;
		case 1:
			emaitza = abizena;
			break;
		case 2:
			emaitza = kirola;
			break;
		case 3:
			emaitza = tamaina;
			break;
		case 4:
			emaitza = baiez;
			break;
		case 5:
			emaitza = argazkia;
		}
		return emaitza;
	}

	public void insertElementAt(Object value, int i) {
		
		switch (i){	
		case 0:
			this.izena = (String)value;
		break;
		case 1:
			this.abizena = (String)value;
			break;
		case 2:
			this.kirola = (String)value;
			break;
		case 3:
			this.tamaina = (Integer)value;
			break;
		case 4:
			this.baiez = (Boolean)value;
			break;
		case 5:
			this.argazkia = (ImageIcon)value;
				
		}
	
	}
	

	public static void main(String[] args) {
//		Vector<Object[]> data = new Vector<Object[]>();
//		data = PertsonaKud.getInstantzia().getPertsona();
		
//		data.add(new Lag("Kathy", "Smith", "Snowboarding", 5, false));
//		data.add(new Lag("John", "Doe", "Rowing", 3, true));
//		data.add(new Lag("Sue", "Black", "Knitting", 2, true));
//		data.add(new Lag("Jane", "White", "Speed reading", 20, true));
		
		
//		Object [] lerroa = data.get(0);
//		System.out.println("Emaitza 'Smith' izan beharko luke:");
//		System.out.println("Lehenengo lerroko bigarren atributuaren balioa (0,1):" + lerroa.getBalioa(1));
//		
//		lerroa = data.get(3);
//		System.out.println("Azken lerroko hirugarren atributuaren balioa (3,2):" + lerroa.getBalioa(2));
//		
//		Lag lerro0 = data.get(0);
//		lerro0.insertElementAt("Sierra", 1);
//		System.out.println("Lehenengo lerroko bigarren atributuaren balioa (0,1):" + lerro0.getBalioa(1));
//
//		Lag lerro3 = data.get(3);
//		lerro3.insertElementAt(new Integer(4), 3);
//		System.out.println("Azken lerroko laugarren atributuaren balioa (3,3):" + lerro3.getBalioa(3));
//
//
//		
//		System.out.println(data);
//		
		Vector<Lag> datuak = new Vector<Lag>();
		KudeatzaileSQLite dbk = KudeatzaileSQLite.getInstantzia();
		System.out.println(datuak);
	}

	public String toQuery() {
		return "'" + izena + "', '" + abizena + "', '" + kirola + "', '" + tamaina + "','" + baiez + "','" + argazkia + "'"; 
	}


	
	


//	@Override
//	public String toString() {
//		return "Lag [izena=" + izena + ", abizena=" + abizena + ", kirola=" + kirola + ", tamaina=" + tamaina
//				+ ", baiez=" + baiez + "]";
//	}
	
}
