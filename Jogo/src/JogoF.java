import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JogoF{
       
    //atrbutos
    private String palavra;
    private ArrayList<Character> estado = new ArrayList<>();
    private int erros = 0;
    
    //Métodos específicos 

    //Ler arquivo e escolhe uma palavra aleatória a cada jogada
    public void lerAletatorio(){
        //importando arquivo de palavras
        String arquivo = "words-pt.txt";
        //armazenando cada palavra
        ArrayList<String> words = new ArrayList<String>();

        //LENDO ARQUIVO TRATANDO EXECEÇÕES
        try(BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
            //variável local
            String linhas;

            //ler cada linha
            while((linhas = ler.readLine()) != null){ 
                words.add(linhas.trim()); //adiciona a linha atual e para o \n

            }
        }
        catch(FileNotFoundException e){
            System.out.println("Não foi possível encontrar o arquivo!");
        }
        catch(IOException e){
            System.out.println("Algo deu errado!");
        }
        //ESCOLHENDO UMA PALAVRA ALEATÓRIA
        Random aleatoria = new Random();

        //gerando palavra dentro do intervalo e guardando na variável classe 
        this.palavra = words.get(aleatoria.nextInt(words.size()));
    }

    //Inicializa o estado inicial da palavra com '_'
    public ArrayList<Character> InicializarEstado(String palavra){
        ArrayList<Character> estado = new ArrayList<>();
        for (int i = 0; i < palavra.length(); i++) {
            estado.add('_');
        }
        return estado;
    }

    //exibe o estado da plavra a medida que vai ser acertando a letra
    public void exibirEstado(ArrayList<Character> estado) {
        for (char c : estado) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    //Arte do boneco de erros
    public String getErrosArte(int erros) {
        switch (erros) {
            case 0:
                return "";
    
            case 1:
                return "  O\n";
    
            case 2:
                return "  O\n  |\n";
    
            case 3:
                return "  O\n /|\n";
    
            case 4:
                return "  O\n /|\\\n";
    
            case 5:
                return "  O\n /|\\\n /\n";
    
            case 6:
                return "  O\n /|\\\n / \\\n";
    
            default:
                return "";
        }
    }
    
    //Função que verifica se a letra está na palavra ou não
    public boolean processarTentativa(String palavra, ArrayList<Character> estado, char letra) {
        boolean acertou = false;
        
        for (int i = 0; i < palavra.length(); i++) {
            //verifica a correspondencia exata da letra na palavra
            if (palavra.charAt(i) == letra) {
                estado.set(i, letra);
                acertou = true; //acertou a letra
            }
        }
        return acertou; //errou retorna false
    }


    public void Jogo(String palavra){
        //Lendo dados de entrada digitados pelo usuário
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> estado = new ArrayList<Character>();
        
        int erros = 0;

        System.out.println("JOGO DA FORCA");

        //7 erros(0 à 6)
        while (erros < 6) {
            System.out.print(getErrosArte(erros));
            System.out.print("PALAVRA: ");
            exibirEstado(estado);

            System.out.print("DIGITE UMA LETRA: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (processarTentativa(palavra, estado, guess)) {
                System.out.println("CORRETO!\n");
                if (!estado.contains('_')) {
                    System.out.print(getErrosArte(erros));
                    System.out.println("VOCÊ GANHOU!");
                    System.out.println("A PALAVRA CORRETA: " + palavra);
                    break;
                }
            } else {
                erros++;
                System.out.println("LETRA ERRADA!\n");
            }
        }

        if (erros >= 6) {
            System.out.print(getErrosArte(erros));
            System.out.println("GAME OVER");
            System.out.println("A PALAVRA CORRETA ERA: " + palavra);
        }

        scanner.close();
    }
}

    
    

