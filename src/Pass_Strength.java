public class Pass_Strength {
    public int Char_type(char ch){
        int val;
        if((int)ch >= 65 && (int)ch <= 90){
            val = 1;
        }
        else if( (int)ch >= 97 && (int)ch <= 122){
            val = 2;
        }
        else if ((int) ch >= 60 && (int) ch <= 71) {
            val = 3;
        }
        else {
            val = 4;
        }
        return val;
    }

    public int PasswordStrength(String Value) {
        String s = Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = Char_type(c);

            if (type == 1) UsedUpper = true;
            if (type == 2) UsedLower = true;
            if (type == 3) UsedNum = true;
            if (type == 4) UsedSym = true;
        }

        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedNum) Score += 1;
        if (UsedSym) Score += 1;

        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        return Score;
    }
}
