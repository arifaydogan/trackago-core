package tr.com.trackago.tautil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MathUtil {
    /*
     * Finansal işlevlerden biri olan DEVRESEL_ÖDEME, sabit ödemeler ve sabit bir faiz oranı temelinde bir borcun ödemesini hesaplar.
     */
    public static BigDecimal devreselOdeme(BigDecimal krediMiktari, Long aylikSure, BigDecimal faizOrani)
    {
        double sonuc;
        double faiz = (faizOrani.doubleValue() / 100);
        sonuc = (krediMiktari.doubleValue() * (Math.pow(1 + faiz, aylikSure.doubleValue()) * faizOrani.doubleValue())) / (Math.pow((1 + faiz), aylikSure.doubleValue()) - 1);
        return new BigDecimal((sonuc / 100));
    }


    public static BigDecimal modaGoreYuvarla(BigDecimal yuvarlanacak, BigDecimal mod) {
        BigDecimal sonuc = BigDecimal.ZERO;
        BigDecimal remainder = yuvarlanacak.remainder(mod);
        sonuc = yuvarlanacak.subtract(remainder).setScale(0, RoundingMode.HALF_EVEN);
        return sonuc;
    }


    public static BigDecimal faizHesaplamaFormulu(BigDecimal gunSayisi,BigDecimal anapara, Double faizOrani){
        BigDecimal faiz = new BigDecimal(0);
        BigDecimal anaparaCarpiGun = anapara.multiply(gunSayisi);
        BigDecimal anaparaGunCarpiFaiz = anaparaCarpiGun.multiply(new BigDecimal(new Double(faizOrani)));
        faiz = anaparaGunCarpiFaiz.divide(new BigDecimal(36000) ,4, BigDecimal.ROUND_HALF_UP);//burya dikkat
        //	System.out.print(" Gün Sayısı : "+ gunSayisi + " Faiz Oranı : "+faizOrani+" Faiz : "+faiz);
        return faiz;

    }

    public static Double faizOraniniBul(BigDecimal gunSayisi,BigDecimal anapara, BigDecimal faizTutari){
        Double faizOrani = new Double(0);
        if(gunSayisi.compareTo(BigDecimal.ZERO) != 0){
            BigDecimal faizTutariCarpiOran = faizTutari.multiply(new BigDecimal(36000));
            BigDecimal anaparaCarpiGunSayisi = anapara.multiply(gunSayisi);
            faizOrani = faizTutariCarpiOran.divide(anaparaCarpiGunSayisi,4,BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return faizOrani;
    }

    public static BigDecimal odenenParadanGecikmeFaiziniBul(BigDecimal gecikmeZammi, BigDecimal anaPara){
        BigDecimal odeneninGecikmeZammi = BigDecimal.ZERO;
        BigDecimal gecikmeZammiBoluAnapara = gecikmeZammi.divide(anaPara, MathContext.DECIMAL128);
        BigDecimal gecikmeZammiBoluAnaparaArtiBir = gecikmeZammiBoluAnapara.add(BigDecimal.ONE);
        odeneninGecikmeZammi = anaPara.divide(gecikmeZammiBoluAnaparaArtiBir,2,RoundingMode.HALF_EVEN);

        return anaPara.subtract(odeneninGecikmeZammi);
    }

    //Format #0.00 gibi olmalı
    public static Double doubleFormatla(Double sayi, String format){
        NumberFormat formatter = new DecimalFormat(format);
        if(sayi !=null)
            return Double.parseDouble(formatter.format(sayi).replace(",","."));

        return null;
    }

    public static BigDecimal bindelikOlarakYuvarla(BigDecimal sayi){
        BigDecimal sonuc = BigDecimal.ZERO;
        sonuc = new BigDecimal(sayi.subtract(new BigDecimal(sayi.intValue()%1000)).intValue());
        return sonuc;
    }

    public static  BigDecimal bigDecimalTopla(BigDecimal sayi, BigDecimal toplanan) {

        if (sayi == null)
            sayi = new BigDecimal(0);

        if (toplanan == null)
            toplanan = new BigDecimal(0);

        return sayi.add(toplanan);

    }

    public static  BigDecimal bigDecimalCikart(BigDecimal sayi, BigDecimal cikarilan) {

        if (sayi == null)
            sayi = new BigDecimal(0);

        if (cikarilan == null)
            cikarilan = new BigDecimal(0);

        return sayi.subtract(cikarilan);

    }

    public static  BigDecimal bigDecimalBol(BigDecimal bolunen, BigDecimal bolen,
                                            int scale) {
        if (bolunen == null)
            bolunen = new BigDecimal(0);

        if (bolen == null)
            return null;

        if (bolen.compareTo(BigDecimal.ZERO) == 0)
            return null;

        return bolunen.divide(bolen, scale, RoundingMode.HALF_UP);

    }

    public static  BigDecimal bigDecimalCarp(BigDecimal carpilan, int carpilanScale,
                                             BigDecimal carpan, int carpanScale) {

        if (carpilan == null)
            carpilan = new BigDecimal(0);

        if (carpan == null)
            carpan = new BigDecimal(0);

        return carpilan.setScale(carpilanScale, RoundingMode.HALF_UP).multiply(carpan.setScale(carpanScale, RoundingMode.HALF_UP)).divide(new BigDecimal(1), 2, RoundingMode.HALF_UP);
    }

    public static  BigDecimal bigDecimalCarp(BigDecimal carpilan,
                                             BigDecimal carpan, int scale) {

        if (carpilan == null)
            carpilan = new BigDecimal(0);

        if (carpan == null)
            carpan = new BigDecimal(0);

        return carpilan.setScale(scale, RoundingMode.HALF_UP).multiply(carpan.setScale(scale, RoundingMode.HALF_UP)).divide(new BigDecimal(1), scale, RoundingMode.HALF_UP);
    }

}
