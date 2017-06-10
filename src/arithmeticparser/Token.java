package arithmeticparser;

/**
 *
 * @author taktik
 */
public class Token {

    public static String getToken(String stateLabel) {
        switch (stateLabel) {
            case "Q0":
                return "0";
            case "Q1":
                return "3";
            case "Q2":
                return "4";
            case "Q3":
                return "5";
            case "Q4":
                return "6";
            case "Q5":
                return "7";
            case "Q6":
                return "8";
            case "Q7":
                return "9";
            case "Q8":
                return "1";
            case "Q11":
                return "2";
            case "Q13":
                return "2";
            default:
                return "0";
        }
    }

    public static String getBesaranLexic(String token) {
        switch (token) {
            case "1":
                return "OPERAND";
            case "2":
                return "OPERAND";
            case "3":
                return "OPERAND";
            case "4":
                return "GROUPING SYMBOL";
            case "5":
                return "GROUPING SYMBOL";
            case "6":
                return "OPERATOR";
            case "7":
                return "OPERATOR";
            case "8":
                return "OPERATOR";
            case "9":
                return "OPERATOR";
            default:
                return "Not Registered";
        }
    }
    
    public static String getKeterangan(String token) {
        switch (token) {
            case "1":
                return "VARIABLE";
            case "2":
                return "REAL";
            case "3":
                return "INTEGER";
            case "4":
                return "BUKA KURUNG";
            case "5":
                return "TUTUP KURUNG";
            case "6":
                return "OPERATOR TAMBAH";
            case "7":
                return "OPERATOR KURANG";
            case "8":
                return "OPERATOR KALI";
            case "9":
                return "OPERATOR BAGI";
            default:
                return "Not Registered";
        }
    }
}
