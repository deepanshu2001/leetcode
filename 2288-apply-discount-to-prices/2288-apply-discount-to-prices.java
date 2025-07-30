class Solution {
    public boolean check_if_Digit(String s){
        if (s.isEmpty()) return false;
        int dotCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '.') {
                dotCount++;
                if (dotCount > 1) return false;
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public String discountPrices(String sentence, int discount) {
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (s.charAt(0) == '$' && s.length() > 1 && check_if_Digit(s.substring(1))) {
                double price = Double.parseDouble(s.substring(1));
                double discounted = price * (100 - discount) / 100;
                str[i] = "$" + String.format("%.2f", discounted);
            }
        }
        return String.join(" ", str);
    }
}
