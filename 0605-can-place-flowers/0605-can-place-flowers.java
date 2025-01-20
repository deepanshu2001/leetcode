class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        int i=0;
        if(flowerbed.length==1 && flowerbed[i]==0){
            n--;
            return n==0;
        }
        if(flowerbed[i]==0 && flowerbed[i+1]==0){
            flowerbed[i]=1;
            n--;
            if(n==0){
                return true;
            }
            i+=2;
        }
        else{
            i++;
        }
        while(i<flowerbed.length-1){
            if(flowerbed[i]==0){
                if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                    i+=2;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
            if(n==0){
                return true;
            }
        }
        if(i==flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]==0){
            n--;
        }
        return n==0;

    }
}