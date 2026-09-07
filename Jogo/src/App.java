import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
        /*// JOGO DA FORCA

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

        //gerando palavra dentro do intervalo
        String palavra = words.get(aleatoria.nextInt(words.size()));

        
        //Lendo dados de entrada digitados pelo usuário
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> estado = new ArrayList<Character>();

        int erros = 0;

        // Inicializa o estado com '_'
        for (int i = 0; i < palavra.length(); i++) {
            estado.add('_'); 
        }

        System.out.println("JOGO DA FORCA");

        //7 erros (0 à 6)
        while (erros < 6) {
            
            //Exibindo arte do jogo
            System.out.print(getErrosArte(erros));


            System.out.print("PALAVRA: ");

            //para cada caractere imprime um '-'
            for(char c : estado){
                System.out.print( c + " "); //todos na mesma linha
            }
            System.out.println(); //avança para a próx linha
            
            System.out.print("DIGITE UM LETRA: ");
    
            //variável de palpite
            char guess = scanner.next().toLowerCase().charAt(0); //ler apenas o primeiro caractere e converte para minúsculo
    
            //verificando se o guess corresponde a alguma letra da palavra
            if(palavra.indexOf(guess) >= 0){
                
                System.out.println("CORRETO!\n");
                
                //percorrendo tamanho da palavra e atualizando o estado
                for(int i = 0; i < palavra.length(); i++){
                    //verificando correspondencia exatada da letra na palavra
                    if(palavra.charAt(i) == guess){
                        estado.set(i, guess);
                    }
                }
                //verifica se a palavra contém caracteres minúsculos
                if(!estado.contains('_')){
                    System.out.print(getErrosArte(erros));
                    System.out.println("VOCÊ GANHOU");
                    System.out.println("A palavra era: " + palavra);
                    break;
                }
    
            }else{
                erros++;
                System.out.println("LETRA ERRADA!\n");
            }
        
        }
        
        //SE PERDE O JOGO
        if(erros >= 6){
            System.out.print(getErrosArte(erros));
            System.out.println("GAME OVER");
            System.out.println("A PALAVRA CORRETA ERA: " + palavra);
            
        }
        
        
        scanner.close();
    }
    // Método que retorna a arte do bonequinho conforme o número de erros

    static String getErrosArte(int erros) {
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
        }*/
    }
}
