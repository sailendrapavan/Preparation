package misc;

public class countSetBits 
{ 
    /* Function to get no of set  
    bits in binary representation  
    of positive integer n */
    static int countSetBits(int n) 
    { 
        int count = 0; 
        while (n > 0) 
        { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
  
    // driver program 
    public static void main(String args[]) 
    { 
        int i = 9;
        String s="df d";
        System.out.println(s.toCharArray());
        char[] a=s.toCharArray();
        while(i<s.length()) {
        	if(a[i]==' ') {
        		a[i]='%'+'2'+'0';
        	}
        	i++;
        }
       
        System.out.println(a);
       // System.out.println(countSetBits(i)); 
    } 
} 
