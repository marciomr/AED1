class ParenMatch {

  public static boolean parenMatch(String entrada){
//    Stack<Character> S = new ArrayStack<Character>(entrada.length());
    Stack<Character> S = new NodeStack<Character>();
    for(int i = 0; i < entrada.length(); i++){
      char simbolo = entrada.charAt(i);
      if(simbolo == '(' || simbolo == '{' || simbolo == '[')
        S.push(simbolo);
      else if(simbolo == ')' || simbolo == '}' || simbolo == ']'){
        if(S.isEmpty()) return false; // fechou sem abrir
        char topo = S.pop();
        if(simbolo == ')' && topo != '(') return false;
        if(simbolo == ']' && topo != '[') return false;
        if(simbolo == '}' && topo != '{') return false;
      }
    }
    return S.isEmpty();
  }

  public static void main(String[] args) {
//    String entrada = "()(()){([()])";
    String entrada = "({)}";
    if(parenMatch(entrada))
      System.out.println(entrada + " tem os parenteses batendo");
    else
      System.out.println(entrada + " não tem os parenteses batendo");
  }
}
