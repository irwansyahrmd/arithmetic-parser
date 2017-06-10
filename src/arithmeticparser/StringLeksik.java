package arithmeticparser;

/**
 *
 * @author taktik
 */

// PENAMBAHAN TIPE DATA BARU UNTUK STRING LEKSIK
public class StringLeksik {
     // PENDEFINISIAN SIMBOL UNTUK SETIAP STRING LEKSIK
    private final String SYM_EKSPONEN = "e"; 
    private final String SYM_VAR = "abcdefghijklmnopqrstuvwxyz_!@#$&";
    private final String SYM_INT  = "0123456789"; 
    private final String SYM_BUKA_KURUNG = "("; 
    private final String SYM_TUTUP_KURUNG = ")"; 
    private final String SYM_KALI = "*"; 
    private final String SYM_BAGI = "/"; 
    private final String SYM_TAMBAH = "+"; 
    private final String SYM_KURANG = "-"; 
    private final String SYM_KOMA = ",."; 
    
    public LEKSIK getStringLeksik(String character){
        character = character.toLowerCase();
        
        // EKSPONEN HARUS DICEK TERLEBIH DAHULU DARIPADA VAR
        // KARENA SEBENARNYA EKSPONEN TERMASUK KEDALAM VAR (HURUF E atau e)
        if (SYM_EKSPONEN.contains(character)){
            return LEKSIK.EKSPONEN;
        }else if (SYM_VAR.contains(character)){
            return LEKSIK.VAR;
        } else if (SYM_INT.contains(character)){
            return LEKSIK.INT;
        }else if (SYM_BUKA_KURUNG.contains(character)){
            return LEKSIK.BUKA_KURUNG;
        }else if (SYM_TUTUP_KURUNG.contains(character)){
            return LEKSIK.TUTUP_KURUNG;
        }else if (SYM_KALI.contains(character)){
            return LEKSIK.KALI;
        }else if (SYM_BAGI.contains(character)){
            return LEKSIK.BAGI;
        }else if (SYM_TAMBAH.contains(character)){
            return LEKSIK.TAMBAH;
        }else if (SYM_KURANG.contains(character)){
            return LEKSIK.KURANG;
        }else if (SYM_KOMA.contains(character)){
            return LEKSIK.KOMA;
        }else{
            return LEKSIK.NOT_DIFINED;
        }
    }
}
   
