Given a string s and an integer k, the task is to reduce the string by applying the following operation:
Choose a group of k consecutive identical characters and remove them.

The operation can be performed any number of times until it is no longer possible.

Example 1:

Input:
k = 2
s = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geeksforgeeks" -> "gksforgks"
Example 2:

Input:
k = 2
s = "geegsforgeeeks" 
Output:
sforgeks
Explanation:
Modified String after each step:
"geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"

  
  
  
  
  class Solution
{
    
    static class Pair{
        char c;
        int data;
        
        public Pair(char c, int data){
            this.c = c;
            this.data = data;
        }
    }
    
    public static String reduced_String(int k, String s)
    {
        Stack<Pair> stack = new Stack<>();
         String str = "";
        if(k == 1) return str;
        
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            
            if(stack.isEmpty()){
                
                stack.push(new Pair(curr, 1));
                continue;
                
            }
            if(stack.peek().c == curr){
                Pair temp = stack.peek();
                stack.pop();
                
                temp.data++;
                if(temp.data == k) continue;
                stack.push(temp);
            }else{
                stack.push(new Pair(curr, 1));
            }
        }
       
        while(!stack.isEmpty()){
            Pair temp = stack.peek();
            stack.pop();
            
            int counter = temp.data;
            char val = temp.c;
            
            while(counter-- > 0){
                str = val + str;
            }
        }
        return str;
    }
}
