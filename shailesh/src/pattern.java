public class pattern {
    public static void main(String args[]) {
        String s[][] = {
                {"  s  ", "  s  ", "  s  ", "  h  ", "     ", "  h  ", "  i  ", "  i  ", "  i  ", "  v  ", "     ", "  v  ", "  a  ", "  a  ", "  a  ", "  n  ", "  n  ", "  n  ", "  i  ", "  i  ", "  i  "},
                {"  s  ", "     ", "     ", "  h  ", "     ", "  h  ", "     ", "  i  ", "     ", "  v  ", "     ", "  v  ", "  a  ", "     ", "  a  ", "  n  ", "     ", "  n  ", "     ", "  i  ", "     "},
                {"     ", "  s  ", "     ", "  h  ", "  h  ", "  h  ", "     ", "  i  ", "     ", "  v  ", "     ", "  v  ", "  a  ", "  a  ", "  a  ", "  n  ", "     ", "  n  ", "     ", "  i  ", "     "},
                {"     ", "     ", "  s  ", "  h  ", "     ", "  h  ", "     ", "  i  ", "     ", "  v  ", "     ", "  v  ", "  a  ", "     ", "  a  ", "  n  ", "     ", "  n  ", "     ", "  i  ", "     "},
                {"  s  ", "  s  ", "  s  ", "  h  ", "     ", "  h  ", "  i  ", "  i  ", "  i  ", "  v  ", "  v  ", "  v  ", "  a  ", "     ", "  a  ", "  n  ", "     ", "  n  ", "  i  ", "  i  ", "  i  "},
        };
          for (int k = 0; k < 5; k++) {
              for (int j = 0; j < 21; j++) {
                System.out.print(s[k][j]);
              }
              System.out.println();
        }

    }
}