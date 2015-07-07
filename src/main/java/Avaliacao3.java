
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;
import utfpr.ct.dainf.if62c.avaliacao.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Avaliacao3 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        String caminho, conta;
        List<Lancamento> lista = new ArrayList<>();
        Object lixo;
        
        System.out.println("Digite o caminho completo do arquivo: ");
        caminho = scanner.next();
        
        ProcessaLancamentos lancamentos = new ProcessaLancamentos(caminho);
        lista = lancamentos.getLancamentos();
        
        System.out.println("Digite o número da conta: ");
        
        while(!scanner.hasNextInt()) {
                lixo = scanner.next();
                System.out.print("Por favor, informe um valor numérico");
        }
        
        Integer numero = scanner.nextInt();
        
        while(numero != 0) {
            boolean achou = false;
            int indice;

            for(int i = 0; i < lista.size(); i++) {
                int um = lista.get(i).getConta();
                if(um == numero) {
                    achou = true;
                    break;
                }
            }
            
            if(!achou)
                System.out.println("Conta inexistente");
            else
                exibeLancamentosConta(lista, numero);

            System.out.println("Digite o número da conta: ");
            
            while(!scanner.hasNextInt()) {
                lixo = scanner.next();
                System.out.print("Por favor, informe um valor numérico");
                System.out.println("Digite o número da conta: ");
            }
            
            numero = scanner.nextInt();
        }
        
        
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
  
        for(int i = 0; i < lancamentos.size(); i++) {
            int um = lancamentos.get(i).getConta();
                if(um == conta) {
                System.out.println(lancamentos.get(i).toString());
            }
        }
 
    }
}