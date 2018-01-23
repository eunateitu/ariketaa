package kudeatzaile;
import java.sql.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import hasiera.Lag;

import javax.swing.text.html.HTMLDocument.Iterator;

public class PertsonaKud {
	



	private static final PertsonaKud pertsonaKud = new PertsonaKud();
		
		public static PertsonaKud getInstantzia(){
			return pertsonaKud;
		}

		private PertsonaKud() {
			// Singleton patroia
		}
		
	public Vector <Object[]> getPertsona(){ // datu basean dauden izenak
			
			KudeatzaileSQLite dbkud = KudeatzaileSQLite.getInstantzia();
			ResultSet rs = dbkud.execSQL("SELECT *  FROM datuak");
			
					Vector<Object[]> emaitza = new Vector<Object[]>();
			
				try {
					while(rs.next()){
						Object[] res = new Object[6]; //zutabe kop
						res[0] = rs.getObject("firstname");
						res[1] = rs.getObject("lastname");
						res[2] = rs.getObject("sport");
						res[3] = rs.getObject("numyears");
						res[4] = rs.getObject("vegetarian");
						res[5] = rs.getObject("argazkia");
						emaitza.add(res);
						System.out.println(res[0]);
						System.out.println(res[1]);
						System.out.println(res[2]);
						System.out.println(res[3]);
						System.out.println(res[4]);
						System.out.println(res[5]);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("catch");
				}
			
				return emaitza;
		}
	
	public void DBanGorde (Vector<Lag> data){
		KudeatzaileSQLite dbkud = KudeatzaileSQLite.getInstantzia();
		for(Lag l : data){
		dbkud.execSQL("INSERT INTO datuak (firstname,lastname , sport, numyears, vegetarian) VALUES ( '"+ l.getIzena() +"','"+ l.getAbizena() +"','"+ l.getKirola() +"','"+ l.getTamaina() +"','"+ l.getBaiez()+"');" );
		}
	}
	public void DBaEzabatu(){
		KudeatzaileSQLite dbkud2 = KudeatzaileSQLite.getInstantzia();
		ResultSet rs = dbkud2.execSQL("DELETE FROM datuak");
	}
	

	
	

}
