class Solution {
    String[] BELOW_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };
        String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };
    public String helper(int num){
            if(num==0){
                return "";
            }
            if(num<20){
                return BELOW_20[num]+" ";
            }
            if(num<100){
                return TENS[num/10]+" "+helper(num%10);
            }
            return BELOW_20[num / 100] + " Hundred " + helper(num % 100);
        }
    public String numberToWords(int num) {
        
        if(num==0){
            return "Zero";
        }
        int i=0;
        String words="";
        while(num>0){
            if(num%1000!=0){
              words=helper(num%1000)+THOUSANDS[i]+" "+words;
            }
            num=num/1000;
            i++;
        }
        return words.trim();
    }
}