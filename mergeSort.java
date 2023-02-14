public class mergeSort {

    public static int[] sort(int array[])
    {
        if(array.length <= 1) {return array;}
        array = breakdown(array);
        return array;
    }

    private static int[] breakdown(int array[])
    {
        if(array.length <= 1){return array;}
        int size = array.length;
        int leftSideSize = size / 2;
        int rightSideSize = size - leftSideSize;

        System.out.println("size: " +size+ " leftSize: " +leftSideSize+ " rightSize: " +rightSideSize);

        int[] leftArray = loopCopy(array, leftSideSize, true);
        int[] rightArray = loopCopy(array, rightSideSize, false);
        return merge(breakdown(leftArray), breakdown(rightArray));

    }

    private static int[] merge(int[] leftArray, int[] rightArray)
    {
        int[] summedArr = new int[leftArray.length + rightArray.length];
        System.out.println("Entering for loop>> Rightarray: " + rightArray.length + " Leftarray: " + leftArray.length + " SummedArray: " + summedArr.length);
        for(int i=0, j=0, x=0 ;  x <= summedArr.length - 1;)
        {
            System.out.println("START >> i:" + i + " >> x: " + x + " >> j:" + j);
            if(leftArray[i] < rightArray[j] && i < leftArray.length)
            {
                System.out.println("IF:LEFT >> i:" + i + " >> x: " + x);
                summedArr[x] = leftArray[i];
                if(i<leftArray.length - 1) {i++;}
                if(x<leftArray.length - 1){x++;}
                System.out.println("IF:LEFT >> i:" + i + " >> x: " + x);
            }
            System.out.println("NEXT IF j:" + j + " X: " + x);
            if(leftArray[i] > rightArray[j] && j < rightArray.length)
            {
                System.out.println("IF:LEFT >> j:" + j + " >> x: " + x);
                summedArr[x] = rightArray[j];
                if(j<leftArray.length - 1) {j++;}
                if(x<leftArray.length - 1){x++;}
                System.out.println("IF:LEFT >> j:" + j + " >> x: " + x);
            }
            System.out.println("PASSED LOOP>> NEXT");
        }
        return summedArr;
    }

    private static int[] loopCopy(int array[], int size, boolean isLeftSide)
    {
        int returnArr[] = new int[size];
        if(isLeftSide)
        {
            for(int i=0; i < size; i++)
            {
                returnArr[i] = array[i];
            }
            return returnArr;
        }
        else
        {

            for(int i=array.length - 1, j = 0; j < size; j++, i--)
            {
                returnArr[j] = array[i];
            }
            return returnArr;
        }
    }
    
}
