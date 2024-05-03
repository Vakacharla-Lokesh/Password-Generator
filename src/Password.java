public class Password {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
	
	private final StringBuilder pool;

    public Password(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncluded) {
		
		pool = new StringBuilder();
		
		if (uppercaseIncluded) pool.append(UPPERCASE_LETTERS);
		
		if (lowercaseIncluded) pool.append(LOWERCASE_LETTERS);
		
		if (numbersIncluded) pool.append(NUMBERS);
		
		if (specialCharactersIncluded) pool.append(SYMBOLS);
		
	}
	
	public String getAlphabet() {
		return pool.toString();
	}

    public String create(int len){
        StringBuilder pass = new StringBuilder("");

        final int alphabetLength = pool.length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < len; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(pool.charAt(index));
        }

        return pass.toString();
    }
}
