package arithmeticparser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author taktik
 */
public final class FiniteAutomata {

    private final ArrayList<HashMap> RefTable;
    private ArrayList<String> inputStringList;
    private final HashMap STATE_Q0 = new HashMap();
    private final HashMap STATE_Q1 = new HashMap();
    private final HashMap STATE_Q2 = new HashMap();
    private final HashMap STATE_Q3 = new HashMap();
    private final HashMap STATE_Q4 = new HashMap();
    private final HashMap STATE_Q5 = new HashMap();
    private final HashMap STATE_Q6 = new HashMap();
    private final HashMap STATE_Q7 = new HashMap();
    private final HashMap STATE_Q8 = new HashMap();
//    private HashMap STATE_Q9 = new HashMap(); // Q9 di hapus karena FA nya salah, diganti Q1
    private final HashMap STATE_Q10 = new HashMap();
    private final HashMap STATE_Q11 = new HashMap();
    private final HashMap STATE_Q12 = new HashMap();
    private final HashMap STATE_Q13 = new HashMap();
//    private HashMap STATE_Q14 = new HashMap(); // Bisa disatuin dengan Q13

    public FiniteAutomata() {
        this.RefTable = new ArrayList();
        createReferenceTable();
    }

    // Membuat Table Finite Automata sesuai dengan Rancangan FA
    public void createReferenceTable() {
        // Menginisiasi hashmap/table dengan string leksis 
        // sesuai dengan rancacngan FA
        STATE_Q0.put("Q0", "ID");
        STATE_Q1.put("Q1", "ID");
        STATE_Q2.put("Q2", "ID");
        STATE_Q3.put("Q3", "ID");
        STATE_Q4.put("Q4", "ID");
        STATE_Q5.put("Q5", "ID");
        STATE_Q6.put("Q6", "ID");
        STATE_Q7.put("Q7", "ID");
        STATE_Q8.put("Q8", "ID");
        STATE_Q10.put("Q10", "ID");
        STATE_Q11.put("Q11", "ID");
        STATE_Q12.put("Q12", "ID");
        STATE_Q13.put("Q13", "ID");

        // Inisiasi State Q0
        STATE_Q0.put(LEKSIK.EKSPONEN, STATE_Q8);
        STATE_Q0.put(LEKSIK.VAR, STATE_Q8);
        STATE_Q0.put(LEKSIK.INT, STATE_Q1);
        STATE_Q0.put(LEKSIK.BUKA_KURUNG, STATE_Q2);
        STATE_Q0.put(LEKSIK.TUTUP_KURUNG, STATE_Q3);
        STATE_Q0.put(LEKSIK.KALI, STATE_Q6);
        STATE_Q0.put(LEKSIK.BAGI, STATE_Q7);
        STATE_Q0.put(LEKSIK.TAMBAH, STATE_Q4);
        STATE_Q0.put(LEKSIK.KURANG, STATE_Q5);

        // Inisiasi State Q1
        STATE_Q1.put(LEKSIK.INT, STATE_Q1);
        STATE_Q1.put(LEKSIK.KOMA, STATE_Q10);
        STATE_Q1.put(LEKSIK.EKSPONEN, STATE_Q12);

        // Inisiasi State Q8
        STATE_Q8.put(LEKSIK.VAR, STATE_Q8);
        STATE_Q8.put(LEKSIK.INT, STATE_Q8);

        // Inisiasi State Q10
        STATE_Q10.put(LEKSIK.INT, STATE_Q11);

        // Inisiasi State Q11
        STATE_Q11.put(LEKSIK.INT, STATE_Q11);
        STATE_Q11.put(LEKSIK.EKSPONEN, STATE_Q12);

        // Inisiasi State Q12
        // tidak bisa seltelah E diikuti dengan angka harus + atau -
        // STATE_Q12.put(LEKSIK.INT, STATE_Q13); 
        STATE_Q12.put(LEKSIK.TAMBAH, STATE_Q13);
        STATE_Q12.put(LEKSIK.KURANG, STATE_Q13);

        // Inisiasi State Q13
        STATE_Q13.put(LEKSIK.INT, STATE_Q13);

        // State dimasukkan kedalam ArrayList/Tabel
        RefTable.add(STATE_Q0);
        RefTable.add(STATE_Q1);
        RefTable.add(STATE_Q2);
        RefTable.add(STATE_Q3);
        RefTable.add(STATE_Q4);
        RefTable.add(STATE_Q5);
        RefTable.add(STATE_Q6);
        RefTable.add(STATE_Q7);
        RefTable.add(STATE_Q8);
        RefTable.add(STATE_Q10);
        RefTable.add(STATE_Q11);
        RefTable.add(STATE_Q12);
        RefTable.add(STATE_Q13);
    }

    public HashMap getNextState(HashMap currentState, LEKSIK leksik) {
        HashMap state = (HashMap) currentState.get(leksik);

        // Jika Next State Sudah tidak ada lagi kembali ke State Q0
        if (state == null) {
            return STATE_Q0;
        } else {
            return state;
        }
    }

    public String getTokens(String input) {
        System.out.println("==================================================");
        this.inputStringList = new ArrayList<>();
        String tempInputString = "";
        String token = "";
        StringLeksik stringLeksik = new StringLeksik();
        HashMap currentState = STATE_Q0;

        for (int i = 0; i < input.length(); i++) {
            String sym = input.charAt(i) + "";
            tempInputString += sym;
            LEKSIK leksik = stringLeksik.getStringLeksik(sym);
            HashMap prevState = currentState;
            currentState = getNextState(currentState, leksik);

            // Ketika next simbol sudah tidak ada maka harus kembali ke Q0
            // Dan melakukan pengecekan next simbol terlebih dahulu
            // sebelum berpindah ke karakter input selanjutnya
            if (currentState == STATE_Q0) {
                System.out.println(getStateLabel(prevState) + " -> "
                        + sym + " -> " + leksik + " -> "
                        + getStateLabel(currentState));
                String label = getStateLabel(prevState);
                String currentToken = Token.getToken(label);
                token += currentToken;
                currentState = getNextState(currentState, leksik);
                String inputString = tempInputString.substring(0,
                        tempInputString.length() - 1);
                tempInputString = tempInputString.substring(
                        tempInputString.length() - 1,
                        tempInputString.length());
                inputStringList.add(inputString);
                System.out.println("###############################");
                System.out.println("STRING : " + inputString);
                System.out.println("TOKEN  : " + currentToken);
                System.out.println("###############################");
            }
            System.out.println(getStateLabel(prevState) + " -> "
                    + sym + " -> " + leksik + " -> "
                    + getStateLabel(currentState));
        }
        String label = getStateLabel(currentState);
        String currentToken = Token.getToken(label);
        token += currentToken;
        inputStringList.add(tempInputString);
        System.out.println("###############################");
        System.out.println("STRING : " + tempInputString);
        System.out.println("TOKEN  : " + currentToken);
        System.out.println("###############################");

        System.out.println("###############################");
        System.out.println("STRING : " + input);
        System.out.println("TOKEN  : " + token);
        return token;
    }

    public String getStateLabel(HashMap state) {
        if (state.equals(STATE_Q0)) {
            return "Q0";
        } else if (state.equals(STATE_Q1)) {
            return "Q1";
        } else if (state.equals(STATE_Q2)) {
            return "Q2";
        } else if (state.equals(STATE_Q3)) {
            return "Q3";
        } else if (state.equals(STATE_Q4)) {
            return "Q4";
        } else if (state.equals(STATE_Q5)) {
            return "Q5";
        } else if (state.equals(STATE_Q6)) {
            return "Q6";
        } else if (state.equals(STATE_Q7)) {
            return "Q7";
        } else if (state.equals(STATE_Q8)) {
            return "Q8";
        } else if (state.equals(STATE_Q10)) {
            return "Q10";
        } else if (state.equals(STATE_Q11)) {
            return "Q11";
        } else if (state.equals(STATE_Q12)) {
            return "Q12";
        } else if (state.equals(STATE_Q13)) {
            return "Q13";
        } else {
            return "null";
        }
    }

    public ArrayList<String> getInputStringList() {
        return inputStringList;
    }

}
