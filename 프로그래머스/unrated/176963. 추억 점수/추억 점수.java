import java.io.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] sumArr = new int[photo.length]; //3

        for(int i=0; i < photo.length; i++)
        {
            int sum = 0;
            
            for(int j=0; j < name.length; j++)
            {                
                for(int k=0; k < photo[i].length; k++)
                {
                    if(name[j].equals(photo[i][k]))
                    {
                        sum = sum + yearning[j];
                    }
            
                }
            }
            sumArr[i] = sum;
        }
        return sumArr;
    
    
    }
}