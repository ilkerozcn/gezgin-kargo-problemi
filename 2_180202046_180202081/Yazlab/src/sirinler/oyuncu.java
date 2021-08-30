package sirinler;

public class oyuncu extends karakter{
public static int oyuncuID;
public static String oyunucuAdi;
public static String oyuncuTur;
public static int Skor;
public oyuncu(int id ,String ad, String tur, int puan) {
	super(id,ad,tur);
	oyuncu.Skor= puan;

}
public static int PuaniGoster() {
	
	return oyuncu.getSkor();
	
}

public static int getOyuncuID() {
	return oyuncuID;
}
public static void setOyuncuID(int oyuncuID) {
	oyuncu.oyuncuID = oyuncuID;
}
public static String getOyunucuAdi() {
	return oyunucuAdi;
}
public static void setOyunucuAdi(String oyunucuAdi) {
	oyuncu.oyunucuAdi = oyunucuAdi;
}
public static String getOyuncuTur() {
	return oyuncuTur;
}
public static void setOyuncuTur(String oyuncuTur) {
	oyuncu.oyuncuTur = oyuncuTur;
}
public static int getSkor() {
	return oyuncu.Skor;
}
public static void setSkor(int skor) {
	oyuncu.Skor = skor;
}


}
