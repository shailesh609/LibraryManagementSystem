 class Parser { 
  
    
    static boolean areParanthesisBalanced(String expr) 
    { 
        
        Deque<Character> stack = new ArrayDeque<Character>(); 
  
      
        for (int i = 0; i < expr.length(); i++) { 
            char x = expr.charAt(i); 
  
            if (x == '(' || x == '[' || x == '{') { 
                // Push the element in the stack 
                stack.push(x); 
                continue; 
            } 
  
            
            if (stack.isEmpty()) 
                return false; 
  
            switch (x) { 
            case ')': 
                stack.pop(); 
                if (x == '{' || x == '[') 
                    return false; 
                break; 
  
            case '}': 
                stack.pop(); 
                if (x == '(' || x == '[') 
                    return false; 
                break; 
  
            case ']': 
                stack.pop(); 
                if (x == '(' || x == '{') 
                    return false; 
                break; 
            } 
        } 
  
       
        return (stack.isEmpty()); 
    } 
  
  
    public String isBalanced(String expr) 
    { 
        
        if (areParanthesisBalanced(expr)) 
            return "true"; 
        else
            return "false"; 
    } 
} 