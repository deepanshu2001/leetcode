class ParkingSystem {
    int size_big;
    int size_mid;
    int size_sm;
    public ParkingSystem(int big, int medium, int small) {
        this.size_big=big;
        this.size_mid=medium;
        this.size_sm=small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
          if(size_big==0){
            return false;
          }
          size_big--;
        }
        if(carType==2){
            if(size_mid==0){
                return false;
            }
            size_mid--;
        }
        if(carType==3){
            if(size_sm==0){
                return false;
            }
            size_sm--;
        }
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */