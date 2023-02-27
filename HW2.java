//Jennifer Puzey purpose of the class...


public class HW2 {
  
  //method to check if parentheses are matching
  public static boolean matchingParentheses (String string){
    
    int open = 0;
    int closed = 0;
    int counter = 0;
    
    //runs through all string and count the number of open and closed parentheses
    for (int i = 0; i < string.length(); i = i +1){
      char c = string.charAt(i);
      if(c == '(')
        open = open +1;
      else if (c == ')')
        closed = closed + 1;
      else
        ;
    
      //when it reaches an opening parentheses it adds to the counter variable
      if (c == '('){
        counter ++;
      }
      
      //when it reaches a closing parentheses it subtracts from counter, this prevents cases that start with a closing parentheses from returning true
      else if (c == ')'){
        counter --;
        if (counter < 0)
          return false;
      }
    }
    //gets rid of cases where the number of open and closed parentheses is not equal and cases with no parentheses
    if ((open != closed) || (open == 0 && closed == 0))
      return false;
    return true;
  }
  
  
  //method to return every character of a string that is a multiple of an inputted number, also starts at a specific inputted index
  public static String everyNthExcept (String string, int start, int skip, int except){
    
    StringBuilder newString = new StringBuilder();
    
    newString.append(string.charAt(start -1));
    
    //runs through the string and if the index is divisible by the skip it adds that character to a new string
    for (int index = start; index< string.length();index ++){
      if ((((index - start + 1) % skip == 0) && ((index - start + 1) % except != 0))){
        newString.append(string.charAt(index)); 
      }
    }
    //returns the new string
    return newString.toString();
    
   }
   
  //this method splits 
   public static String flipEachK (String string, int k){
     
     StringBuilder newString = new StringBuilder();
     int forward = 1;
     int reverse = 2;
     int direction = forward;
     
     for (int index = 0; index < string.length(); index += k){
        
       
       for (int innerIndex = 0; innerIndex < k; innerIndex ++){
         int position = 0;
         
         if (direction == forward) 
           position = innerIndex + index;
           
         else 
           position = index + (k - 1) - innerIndex;
         
         if (position < string.length())
           newString.append(string.charAt(position));
         
       }
       if (direction == forward)
         direction = reverse;
       else 
         direction = forward;
     }
     return newString.toString();
     
  }
     
  //string to reverse the digits in a string but keep the letters the same 
  public static String reverseDigits (String string){
    
    
    StringBuilder digString = new StringBuilder();
    StringBuilder rDigString = new StringBuilder();
    StringBuilder finalString = new StringBuilder();
    
    for (int index = 0; index < string.length(); index++){
      char c = string.charAt(index);
      
      if (Character.isDigit(c) == true){
        digString.append(string.charAt(index));
      } 
    }
    for (int i = digString.length()-1; i >= 0; i--){
      
      rDigString.append(digString.charAt(i));
    }
    
  int digit = 0;
  
  for (int index = 0; index < string.length(); index ++){
    char c = string.charAt(index);
    if (Character.isDigit(c) == true){
      finalString.append(rDigString.charAt(digit));
      digit ++;
    }
    else
      finalString.append(string.charAt(index));
    
  }
   return finalString.toString();
}
   
 //method to edit out certain things in a string 
  public static String editOut (String string){
    int retain = 1;
    StringBuilder newString = new StringBuilder();
    
    for (int i = 0; i < string.length(); i = i +1){
      char c = string.charAt(i);
      if(c == '('){
        if (retain == 1)
          retain = 0;
        else
          retain = 1;
      }
      
      else if (c == ')'){
        if (retain == 1)
          retain = 0;
        else
          retain = 1;
      }
      
      else if (retain == 1)
        newString.append(string.charAt(i));
    }
    return newString.toString();
  }
  
  //method to replace text from one string with text in another string
  public static String replaceText (String string1, String string2){
    
    StringBuilder newString = new StringBuilder();
    int replace = 0; 
    int counter = 0;
    int position = 0;
    
    
    for (int index = 0; index < string1.length(); index ++){
        char c = string1.charAt(index);
        if(c == '('){
            counter ++;
            
            if (counter == 1){
                replace = 1;
            }
        }
        
        else if (c == ')'){
            counter --;
            if (counter == 0){
                replace = 0;
          
                int retain = 0;
                int counter2 = 0;
                boolean satisfied = false;
                

                for (int i = position; i < string2.length() && !satisfied; i ++){
                    char a = string2.charAt(i);
                    boolean skip = false;
                    if(a == '('){
                        counter2 ++;
                        if (counter2 == 1){
                            retain = 1;
                            //erkbjv erkjbn
                            skip = true;
                            //erkj vkjevegt 
                            //lorem ipsum
                        }
                    }
                    else if (a == ')'){
                        counter2 --;
                        if (counter2 == 0){
                            retain = 0;
                            position = i +1;
                            satisfied = true;
                        }
                    }
                    if (retain == 1 && !satisfied && !skip)
                        newString.append(string2.charAt(i));
                }
            
            }
        }
        else {
            if (replace == 1){
            ;
            }
            else 
                newString.append(string1.charAt(index));
        }
    }
    
    return newString.toString();
  }


}
