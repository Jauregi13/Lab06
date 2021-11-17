package zuhaitzBitarra;

import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;


public class Probak {
	
	public static void main(String[] args) throws Exception {
		int elem;
		Scanner input = new Scanner(new File("datuak/sarrera0.txt"));
		Scanner input2 = new Scanner(new File("datuak/sarrera0.txt"));
		
		ZuhaitzBitarra zuhaitza = new ZuhaitzBitarra(input);


		System.out.println("ZUHAITZ BITARRA: " + zuhaitza);
		
		System.out.println("HUTSA DA?: " + 
				(zuhaitza.hutsaDa() ? ("HUTSA DA") : ("EZ DA HUTSA")));
		
		System.out.println("ADABEGI KOPURUA: " + zuhaitza.adabegiKopurua());
		
		System.out.println("HOSTO KOPURUA: " + zuhaitza.hostoKopurua());
		
		System.out.println("ALTUERA: " + zuhaitza.altuera());
		
		System.out.println("MAILAKOEN BATUKETA: ");
		System.out.println("Zein da maila?");
		Scanner sarrera = new Scanner(System.in);
		elem = sarrera.nextInt();
		sarrera.close();;
		System.out.println(elem + " mailan honakoa da batura: " + zuhaitza.mailakoakBatu(elem));	
		
		System.out.println("EZKERREKO BIDEA LORTU: ");
		LinkedList<Integer> bidea = zuhaitza.ezkerrekoBideaLortu();
		System.out.println("Ezkerreko bidea: " + bidea.toString());	
		
		System.out.println("ZUHAITZA HOSTOBERRITU: ");
		ZuhaitzBitarra hostoBerritua = zuhaitza.hostoBerritu();
		System.out.println("Jatorrizko zuhaitza hostoberritua: " + hostoBerritua);	

		zuhaitza = new ZuhaitzBitarra(input2);
		System.out.println("ZUHAITZA KIMATU: ");
		ZuhaitzBitarra zuhaitzKimatua = zuhaitza.kimatu();
		System.out.println("Jatorrizko zuhaitza KIMATUA: " + zuhaitzKimatua);

		input.close();
		input2.close();
	}
}