class ParenMatch {

  public static boolean parenMatch(String entrada){
    Stack<Character> S = new ArrayStack<Character>(entrada.length());

    for(int i = 0; i < entrada.length(); i++){
      char simbolo = entrada.charAt(i);
      if(simbolo == '(' || simbolo == '{' || simbolo == '[')
        S.push(simbolo);
      else if(simbolo == ')' || simbolo == '}' || simbolo == ']'){
        if(S.isEmpty()) return false; // abriu sem fechar
        char topo = S.pop();
        if(simbolo == ')' && topo != '(') return false;
        if(simbolo == ']' && topo != '[') return false;
        if(simbolo == '}' && topo != '{') return false;
      }
    }
    if(S.isEmpty()) return true;
    return false;
  }

  public static void main(String[] args) {
    String entrada = "()(()){([()])}";
    if(parenMatch(entrada))
      System.out.println(entrada + " tem os parenteses batendo");
    else
      System.out.println(entrada + " não tem os parenteses batendo");
  }
}
