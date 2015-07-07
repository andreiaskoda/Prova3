
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
        
        while(Integer.parseInt(scanner.toString()) != 0) {
            Integer numero = scanner.nextInt();
            boolean achou = false;
            int indice;
            
            for(int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getConta() == numero) {
                    achou = true;
                    break;
                }
            }
            
            if(!achou)
                System.out.print("Conta inexistente");
            else
                exibeLancamentosConta(lista, numero);

            
            while(!scanner.hasNextInt()) {
                lixo = scanner.next();
                System.out.print("Por favor, informe um valor numérico");
                System.out.println("Digite o número da conta: ");
            }
        }
        
        while(!scanner.hasNextInt()) {
            lixo = scanner.next();
            System.out.print("Por favor, informe um valor numérico");
        }
        
        
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
  
        for(int i = 0; i < lancamentos.size(); i++) {
            if(lancamentos.get(i).getConta() == conta) {
                System.out.println(lancamentos.get(i).toString());
            }
        }
 
    }
}