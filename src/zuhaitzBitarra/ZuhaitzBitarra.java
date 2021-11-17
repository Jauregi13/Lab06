package zuhaitzBitarra;

import java.util.Scanner;
import java.util.LinkedList;

public class ZuhaitzBitarra {

	private Adabegia erroa;

	/**
	 * ZuhaitzBitarra klasearen eraikitzailea: zuhaitz hutsa sortzen du.
	 * 
	 */
	public ZuhaitzBitarra() {
		this.erroa = null;
	}

	/**
	 * ZuhaitzBitarra klasearen eraikitzailea: fitxategiko edukietatik zuhaitza
	 * sortzen du.
	 * 
	 */
	public ZuhaitzBitarra(Scanner source) throws Exception {
		String token = source.next();
		if (token.equals("*"))
			this.erroa = null;
		else if (token.equals("["))
			this.erroa = new Adabegia(source);
		else
			throw new Exception(String.format("Unexpected token when reading " + "binary tree: %s", token));
	}

	/**
	 * Zuhaitz bitarra hutsa den ala ez itzultzen du.
	 * 
	 * @return true, zuhaitz bitarra hutsa bada; false, bestela.
	 */
	public boolean hutsaDa() {
		return (erroa == null);
	}

	/**
	 * Erroa izeneko adabegia zuhaitz bitarraren erroan jartzen du.
	 * 
	 * @param erroa zuhaitz bitarraren erroan jarriko den adabegia.
	 * @return eguneratutako zuhaitza itzultzen du.
	 */
	public ZuhaitzBitarra errotu(Adabegia erroa) {
		this.erroa = erroa;
		return this;
	}

	/**
	 * Zuhaitz bitarraren adabegi kopurua itzultzen.
	 * 
	 * @return zuhaitz bitarraren adabegi kopurua.
	 */
	public int adabegiKopurua() {
		if (this.hutsaDa())
			return 0;
		else
			return this.erroa.adabegiKopurua();
	}

	/**
	 * Zuhaitz bitarraren hosto kopurua itzultzen.
	 * 
	 * @return zuhaitz bitarraren adabegi kopurua.
	 */
	public int hostoKopurua() {
		if (this.hutsaDa())
			return 0;
		else
			return this.erroa.hostoKopurua();
	}

	/**
	 * Zuhaitz bitarrean elem elementua aurkitu den ala ez itzultzen du.
	 * 
	 * @param elem zuhaitz bitarrean bilatuko den elementua.
	 * @return true, elem zuhaitz bitarrean badago; false, bestela.
	 */
	public boolean baDauka(int elem) {
		if (this.hutsaDa())
			return false;
		else
			return this.erroa.baDauka(elem);
	}

	/**
	 * Zuhaitz bitarraren altuera itzultzen du.
	 * 
	 * @return zuhaitz bitarraren altuera.
	 */
	public int altuera() {
		if (this.hutsaDa())
			return 0;
		else
			return this.erroa.altuera();
	}

	
	
	public int mailakoakBatu(int n) {

		if (this.hutsaDa())
			return 0;
		else
			return this.erroa.mailakoakBatu(n);
		
	}

	
	
	public ZuhaitzBitarra hostoBerritu() {

		if (this.hutsaDa())
			return null;
		else {
			this.erroa = this.erroa.hostoBerritu();
			return this;
		}
			
	}

	
	

	public ZuhaitzBitarra kimatu() {

		if (this.hutsaDa())
			return null;
		else {
			this.erroa = this.erroa.kimatu();
			return this;
		}
			
		
	}
	
	
	
	public LinkedList<Integer> ezkerrekoBideaLortu() {

		if (this.hutsaDa())
			return null;
		else
			return this.erroa.ezkerrekoBideaLortu();
		
	}
	
	/**
	 * java.lang.Object-etik heredatutako metodoaren gainidazketa.
	 * 
	 * @return zuhaitzaren edukia String formatuan.
	 */
	@Override
	public String toString() {
		if (this.hutsaDa())
			return " * ";
		return this.erroa.toString();
	}
}