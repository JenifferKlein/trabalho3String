/**
 * Trabalho 3 referente aos exercicios de Strings
 * @author (Gabriel Porto(20107910), Jeniffer Klein(20103091); 
 * @version (25/05/2020)
 */
import java.util.Scanner;
public class Principal{
    public static void main(String[] args) {
        String frase1, frase2, palavra, verbo, palindromo, texto = null, textoo; //Váriavel que recebe a frase
        int opcao = 0;
        
        Scanner leia = new Scanner(System.in); //Classe que instancia o teclado
        do{
            System.out.println(" __________________________________");
            System.out.println("|             M E N U              |");
            System.out.println("|                                  |");
            System.out.println("|       1. Continuar               |");
            System.out.println("|       2. Sair                    |");
            System.out.println("|                                  |");
            System.out.println("|__________________________________|");
        
            System.out.println("Escolha uma das opções acima:");
            opcao = leia.nextInt();
            System.out.printf("\n");
            
            if(opcao == 1){
                //Parte 1
                System.out.println("Digite uma frase:"); //Orienta o usuario o que ele tem que fazer
                leia.nextLine();
                frase1 = leia.nextLine(); //leitura do que o usuário digita
                //apresenta a frase que o usuario escreveu e o nº de vogais na frase.
                System.out.println("A frase '"+frase1+"' tem "+vogais(frase1)+" vogais!"); 
                
                System.out.printf("\n");
        
                //Parte 2
                System.out.println("Digite uma frase:");
                frase2 = leia.nextLine();
        
                System.out.println("Agora digite uma palavra:");
                palavra = leia.next();
                //apresenta a frase que o usuario escreveu e o nº de vezes que a palvra que ele escreveu se repete.
                System.out.println("Na frase '"+frase2+"' a palavra '"+palavra+"' aparece "+quantPalavra(frase2, palavra)+" vezes.");
                
                System.out.printf("\n");
        
                //Parte 3
                System.out.println("Digite um verbo terminado em AR:");
                verbo = leia.next();
                
                int cont = 1;
                
                while (verbo.endsWith("ar") == false) {            
                    System.out.println("Por favor, digite um verbo terminado em AR:");
                    verbo = leia.next();
                    cont++;
                    System.out.printf("\n");
                    //Caso o usuario seja teimoso e insista em digitar um verbo com final diferente de "AR" aparece esse aviso
                    if (cont == 3) {
                        System.out.println("Você tem mais uma chance para digitar um verbo terminado com AR. "
                         + "Caso o verbo não termine em AR, o programa irá preencher um verbo e lhe apresentará a conjugação dele."); 
                    }
                    //Se ele ignorar o aviso, o programa vai atribuir um verbo terminado em ar para sair do loop.
                    if (cont == 4) {
                        verbo = "Dançar";
                        System.out.println("O programa atribuiu o verbo 'dançar' a insistencia no erro ao digitar o verbo");
                    }
                }
                //Apresentação da conjugação do verbo
                System.out.println("Verbo "+verbo+":");
                System.out.printf("\n");
                System.out.println(formatVerbo(verbo));
                
                System.out.printf("\n");
        
                // Parte 4
                System.out.println("Digite uma palavra:");
                palindromo = leia.next();
                //Se for palindromo aparece aqui
                if (palindromo_o(palindromo).equalsIgnoreCase(palindromo)) {
                    System.out.println("A palavra "+palindromo_o(palindromo)+" é um palíndromo");
                //Senão for palindromo aparece aqui
                }else{
                    System.out.println("A palavra "+palindromo_o(palindromo)+" não é um palíndromo");
                }
                
                System.out.printf("\n");
        
                //Parte 5
                System.out.println("Digite um texto:");
                leia.nextLine();
                texto = leia.nextLine();
                
                //Apresenta o nº de caracteres que contém no texto que foi digitado pelo usuario.
                System.out.println("O texto digitado possui "+texto.length()+" caracteres");
                
                System.out.printf("\n");
        
                //Parte 6
                System.out.println("Digite (1) para imprimir uma palavra pronta ou (2) para digitar uma:");
                opcao = leia.nextInt();
                while (opcao < 1 || opcao > 2) {                    
                    System.out.println("Digite (1) para imprimir uma palavra pronta ou (2) para digitar uma:");
                    opcao = leia.nextInt();
                }
                
                if(opcao == 1){
                    usandoCharAt();
                }
                if(opcao == 2){
                    usandoCharAt2();
                }
                
                System.out.printf("\n");
                
                //Parte 7
                System.out.println("Digite algo em maiusculas para transformar em minúsculas!");
                String dado1 = leia.nextLine();
                System.out.println(dado1.toLowerCase());
     
                System.out.println("Digite algo em minúsculas para transformar em maisculas!");
                String dado2 = leia.nextLine();
                System.out.println(dado2.toUpperCase());
                
                System.out.printf("\n");
        
                //Parte 8
                String JAVA = "java";
                String j = JAVA.substring(0,1);
                String ja = JAVA.substring(0,2);
                String jav = JAVA.substring(0,3);
                String java = JAVA.substring(0,4);
   
                System.out.println("\n"+j);
                System.out.println("\n"+ja);
                System.out.println("\n"+jav);
                System.out.println("\n"+java);
                System.out.println("\n"+jav);
                System.out.println("\n"+ja);
                System.out.println("\n"+j);
            }
        }while(opcao!=2);
        System.out.println("Fim!");
    }
    //Método para capturar a quantidades de vogais existente na frase.
    //Código do método baseado nos exemplos da professora Giraffa.
    public static int vogais(String frase){
        int total = 0; //armazena o número total de vogais
        
        for(int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);
            if(letra == 'a' || letra == 'e' || letra =='i' || letra == 'o' || letra=='u'){
                total++;
            } 
        }
        return total;//retorna o total de vogais na classe main
    }
    //Método para informar a quantidades de vezes que a palavra repeti
    //código baseado no exemplo de um fórum do guj
    public static int quantPalavra(String frase, String palavra){
        int total = 0;
            String [] arrayString = frase.split(" "); //vetor que coloca cada palavra em um indice
            
            for(int i=0;i<arrayString.length;i++){
                if(arrayString[i].equals(palavra)){
                    total++;
		}
            } 		
        return total;   
    }
    //Método para conjugar verbo
    //código baseado num exemplo do site guj, que utilizava o replace (tem que mudar isso depois porque se o verbo começr com ar vai dar melda.
    public static String formatVerbo(String verbo){
        verbo = verbo.replace("ar", ""); //replace substitui a palavra do 1º parametro pelo 2º
        String conjuncao = ("Eu "+verbo+"o \n"+"Tu "+verbo+"a \n"+"Ele/Ela "+verbo+"a \n"+
               "Nós "+verbo+"amos \n"+"Vós "+verbo+"ais \n"+"Eles/Elas "+verbo+"am");
        return conjuncao;
    }    
    //Método para inverter a palavra
    public static String palindromo_o(String palindromo){
        String aux = "";
        for (int i = palindromo.length() -1; i >= 0; i--) {
            aux = aux + Character.toString(palindromo.charAt(i));
        }
        return aux;
    }
    //Método para imprimir do jeitinho que a Giraffa quer
    public static void usandoCharAt(){
        String palavra = "java";
        int n;
        
        System.out.printf("\n");
        
        //Quantidade de caracteres armazenados
        n = palavra.length();

        //Cada linha mostra 'i' caracteres
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%c", palavra.charAt(j));
            }
            System.out.printf("\n");
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                System.out.printf("%c", palavra.charAt(j));
            }
                System.out.printf("\n");
        }
    }
    //Método para imprimir do jeitinho que a Giraffa quer
    public static void usandoCharAt2(){
        String palavra = "";
        int n;
        
        Scanner leia = new Scanner(System.in);
        System.out.printf("\n");
        
        System.out.println("Digite uma palavra:");
        palavra = leia.next();
        //Quantidade de caracteres armazenados
        n = palavra.length();

        //Cada linha mostra 'i' caracteres
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%c", palavra.charAt(j));
            }
            System.out.printf("\n");
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                System.out.printf("%c", palavra.charAt(j));
            }
                System.out.printf("\n");
        }
    }  
}
