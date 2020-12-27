package Practice;

public class Duplicate {
	 public static void main(String[] args) {
		 String input="abbcdbda";
		 String result="";

		    for (int i = 0; i < input.length(); i++) {
		    	if (i + 1 < input.length() && input.charAt(i) != input.charAt(i+1)){
		            result = result + input.charAt(i);
		        }
		        if (i + 1 == input.length()){
		            result = result + input.charAt(i);
		        }
		    }
		    System.out.println(result);  
}
}