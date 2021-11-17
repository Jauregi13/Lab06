package zuhaitzBitarra;


import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class Adabegia {

	int info;
	Adabegia ezkerra;
	Adabegia eskuina;

	/**
	 * Adabegia klasearen eraikitzailea.
	 * 
	 * @param elem adabegiko elementua, int motakoa.
	 */
	public Adabegia(int elem) {
		info = elem;
		ezkerra = null;
		eskuina = null;
	}

	public Adabegia(Scanner source) throws Exception {
		this.info = source.nextInt();
		String token = source.next();
		if (token.equals("]")) {
			this.ezkerra = null;
			this.eskuina = null;
		} else {
			if (token.equals("["))
				this.ezkerra = new Adabegia(source);
			else if (token.equals("*"))
				this.ezkerra = null;
			else
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
			token = source.next();
			if (token.equals("["))
				this.eskuina = new Adabegia(source);
			else if (token.equals("*"))
				this.eskuina = null;
			else
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
			token = source.next();
			if (!token.equals("]"))
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
		}
	}

	/**
	 * Adabegiak ezkerreko umea baduen ala ez itzultzen du.
	 * 
	 * @return true, ezkerreko umea baldin badu; false, bestela.
	 */
	public boolean baduEzkerra() {
		return this.ezkerra != null;
	}

	/**
	 * Adabegiak eskuineko umea baduen ala ez itzultzen du.
	 * 
	 * @return true, eskuineko umea baldin badu; false, bestela.
	 */
	public boolean baduEskuina() {
		return this.eskuina != null;
	}

	/**
	 * Adabegia hostoa den ala ez itzultzen du.
	 * 
	 * @return true, hostoa bada; false, bestela.
	 */
	public boolean hostoaDa() {
		return !this.baduEzkerra() && !this.baduEskuina();
	}

	@Override
	public String toString() {
		String emaitza = "[ " + this.info + " ";
		if (!this.hostoaDa()) {
			if (this.baduEzkerra())
				emaitza += this.ezkerra.toString();
			else
				emaitza += "* ";
			if (this.baduEskuina())
				emaitza += this.eskuina.toString();
			else
				emaitza += "* ";
		}
		emaitza += "] ";
		return emaitza;
	}

	public int adabegiKopurua() {
		int Kopurua = 1;
		if (this.baduEzkerra())
			Kopurua += this.ezkerra.adabegiKopurua();
		if (this.baduEskuina())
			Kopurua += this.eskuina.adabegiKopurua();
		return Kopurua;
	}

	public int hostoKopurua() {
		int Kopurua = 0;
		if (this.hostoaDa())
			return 1;
		else {
			if (this.baduEzkerra()) {
				Kopurua += this.ezkerra.hostoKopurua();
			}
			if (this.baduEskuina()) {
				Kopurua += this.eskuina.hostoKopurua();
			}
			return Kopurua;
		}
	}

	public boolean baDauka(int elem) {
		if (this.info == elem)
			return true;
		else if (this.baduEzkerra() && this.ezkerra.baDauka(elem)) {
			return true;
		} else if (this.baduEskuina() && this.eskuina.baDauka(elem)) {
			return true;
		}
		return false;
	}

	
	
	public int altuera() {

		int kont1, kont2;
		kont1=0;
		kont2=0;
		
		if(this.hostoaDa()) {
			return 1;
		}
		else {
			if (this.baduEzkerra()) {
				kont1= this.ezkerra.altuera();
			}
			if (this.baduEskuina()) {
				kont2= this.eskuina.altuera();
			}
		}
		return 1+ Math.max(kont1, kont2);
	}

	
	
	public int mailakoakBatu(int n) {

		int batura1, batura2;
		batura1=0;
		batura2=0;
		
		if(n==0) {
			return this.info;
		}
		else {
			if (this.baduEzkerra()) {
				batura1= this.ezkerra.mailakoakBatu(n-1);
			}
			if (this.baduEskuina()) {
				batura2= this.eskuina.mailakoakBatu(n-1);
			}
			return batura1 +batura2;
		}
	}
	
	
	
	public Adabegia hostoBerritu() {
		
		Adabegia t = this;
		if(this.hostoaDa()) {
			t.eskuina = null;
			t.ezkerra = null;
			
		}
		else {

			if(this.baduEskuina()) {
				t = this.eskuina;
				this.eskuina.hostoBerritu();
				
			}
			if(this.baduEzkerra()) {
				t= this.ezkerra;
				this.ezkerra.hostoBerritu();
				
			}
		}
		return this;
		
	}

	public Adabegia kimatu() {

		
		if(this.baduEzkerra() && this.baduEskuina()) {
				this.eskuina.kimatu();
				this.ezkerra.kimatu();
		}
		else {
			if(this.baduEzkerra() && !this.baduEskuina()) {
				this.ezkerra = null;
			}
			else if(!this.baduEzkerra() && this.baduEskuina()) {
				this.eskuina = null;
			}
		}
		
		return this;
		
	}
	
	public LinkedList<Integer> ezkerrekoBideaLortu() {

		return new LinkedList<Integer>();
		
	}
}
