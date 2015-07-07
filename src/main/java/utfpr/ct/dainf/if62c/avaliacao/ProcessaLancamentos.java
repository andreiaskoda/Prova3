package utfpr.ct.dainf.if62c.avaliacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class ProcessaLancamentos {
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }
    
    private String getNextLine() throws IOException {
        return reader.readLine();
    }
    
    private Lancamento processaLinha(String linha) {
        Integer conta;
        Date data;
        String descricao;
        Double valor;
        
        conta = Integer.parseInt(linha.substring(0, 6));
        data = new Date(Integer.parseInt(linha.substring(6, 10)) - 1900,
                        Integer.parseInt(linha.substring(10, 12)),
                        Integer.parseInt(linha.substring(12, 14)));
        descricao = linha.substring(14, 74);
        valor = Double.parseDouble(linha.substring(74, 84)) + 
                Double.parseDouble(linha.substring(84, 86))/100;
        
        if(descricao.length() < 60) {
            int i = 0;
            while(descricao.charAt(i) != ' ' && (descricao.charAt(i+1) != ' ' || 
                    i+1 != 59)) {
                i++;
            }
            
            descricao = descricao.substring(0, i);
        }
        
        
        Lancamento lancamento = new Lancamento(conta, data, descricao, valor);
        
        return lancamento;
    }
    
    private Lancamento getNextLancamento() throws IOException {
        String linha = this.getNextLine();
        
        if(linha == null)
            return null;
        
        return this.processaLinha(linha);
        
    }
    
    public List<Lancamento> getLancamentos() throws IOException {
        List<Lancamento> lista = new ArrayList<>();
        String linha;
        linha = this.getNextLine();
        
        do {
            lista.add(processaLinha(linha));
            linha = this.getNextLine();
        } while(linha != null);
        
        
        Collections.sort(lista, new LancamentoComparator());
        
        return lista;
    }
    
}
