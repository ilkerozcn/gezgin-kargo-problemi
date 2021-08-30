package sirinler;

public class karakter {
public static int ID;
public static String Ad;
public static String Tur;

public karakter(int id2, String ad2, String tur2) {
	
	karakter.ID= id2;
	karakter.Ad= ad2;
	karakter.Tur= tur2;
	
	
	
}

public static int getID() {
	return ID;
}

public static void setID(int iD) {
	ID = iD;
}

public static String getAd() {
	return Ad;
}

public static void setAd(String ad) {
	Ad = ad;
}

public static String getTur() {
	return Tur;
}

public static void setTur(String tur) {
	Tur = tur;
}

}
