class Problem807 {
    int[][] cityGrid;
    int[][] tallestPossibleCityGridWithoutChangingSkyline;
    int[] maxBuildingHeightForEachColumn;
    int[] maxBuildingHeightForEachRow;

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        cityGrid = grid;
        calculateCitySkylineFromNorthOrSouth();
        calculateCitySkylineFromEastOrWest();
        calculateTallestPossiableCityGridWithoutChangingSkyline();
        return getTotalHeigthDiffrenceBetweenCityGridAndTallestPossibleCity();
    }
    private int getTotalHeigthDiffrenceBetweenCityGridAndTallestPossibleCity(){
        int totalHeightDiffrence = 0;
        for(int row = 0; row < tallestPossibleCityGridWithoutChangingSkyline.length; row++) {
            for (int column = 0; column < tallestPossibleCityGridWithoutChangingSkyline[row].length; column++) {
                totalHeightDiffrence += (tallestPossibleCityGridWithoutChangingSkyline[row][column] - cityGrid[row][column]);
            }
        }
        return totalHeightDiffrence;
    }
    private void calculateTallestPossiableCityGridWithoutChangingSkyline(){
        tallestPossibleCityGridWithoutChangingSkyline = new int[cityGrid.length][cityGrid[0].length];
        for(int row = 0; row < tallestPossibleCityGridWithoutChangingSkyline.length; row++){
            for(int column = 0; column < tallestPossibleCityGridWithoutChangingSkyline[row].length; column++){
                int tallestPossibleBuildingHeight =
                        (maxBuildingHeightForEachColumn[column] < maxBuildingHeightForEachRow[row] ?//pick the smaller of the skyline angles
                        maxBuildingHeightForEachColumn[column]:maxBuildingHeightForEachRow[row]);
                tallestPossibleCityGridWithoutChangingSkyline[row][column] = tallestPossibleBuildingHeight;
            }
        }
    }
    private void calculateCitySkylineFromNorthOrSouth() {
        maxBuildingHeightForEachColumn = new int[cityGrid.length];
        for (int row = 0; row < cityGrid.length; row++) {
            for (int column = 0; column < cityGrid[row].length; column++) {
                int currentBuildingHeight = this.cityGrid[row][column];
                if (currentBuildingHeight > maxBuildingHeightForEachColumn[column]) {
                    maxBuildingHeightForEachColumn[column] = currentBuildingHeight;
                }
            }
        }
    }

    private void calculateCitySkylineFromEastOrWest(){
        maxBuildingHeightForEachRow = new int[cityGrid.length];
        for (int row = 0; row < cityGrid.length; row++) {
            for (int column = 0; column < cityGrid[row].length; column++) {
                int currentBuildingHeight = this.cityGrid[row][column];
                if (currentBuildingHeight > maxBuildingHeightForEachRow[row]) {
                    maxBuildingHeightForEachRow[row] = currentBuildingHeight;
                }
            }
        }
    }
   public static void main(String[] args) {
       Problem807 mySol = new Problem807();
       int[][] city = {
               {3, 0, 8, 4},
               {2, 4, 5, 7},
               {9, 2, 6, 3},
               {0, 3, 1, 0}};
       System.out.println(mySol.maxIncreaseKeepingSkyline(city));


   }
}
