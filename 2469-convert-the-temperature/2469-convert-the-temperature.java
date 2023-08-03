class Solution {
    public double[] convertTemperature(double celsius) {
        double[] db = new double[2];
        db[0] = celsius+ 273.15;
        db[1] = celsius * 1.80 + 32.00;
        return db;
        
    }
}