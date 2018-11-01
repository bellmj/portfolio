class Problem461 {
     public int hammingDistance(int x, int y) {
        String xBinaryString = Integer.toBinaryString(x);
        String yBinaryString = Integer.toBinaryString(y);
        int maxBitsOfXorY = (xBinaryString.length() > yBinaryString.length() ? xBinaryString.length() :
                yBinaryString.length());
        xBinaryString = getZeroPaddedBinaryString(xBinaryString,maxBitsOfXorY);
        yBinaryString = getZeroPaddedBinaryString(yBinaryString,maxBitsOfXorY);
        char[] xBitsCharArray = xBinaryString.toCharArray();
        char[] yBitsCharArray = yBinaryString.toCharArray();
        int diffrentBitCount = 0;
        for(int i = 0; i < xBitsCharArray.length; i++) {
            if (xBitsCharArray[i] != yBitsCharArray[i]) diffrentBitCount++;
        }
        return diffrentBitCount;
    }
    private String getZeroPaddedBinaryString(String binaryString,int desiredNumberOfBits){
        return String.format("%" + desiredNumberOfBits +"s",binaryString).replace(' ', '0');
    }
}
