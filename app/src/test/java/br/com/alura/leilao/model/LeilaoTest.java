package br.com.alura.leilao.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {

    @Test
    public void deve_devolverDescricao_quandoRecebeDescricao() {
        // criar cenário de teste
        Leilao console = new Leilao("Console");
        
        // executar ação esperada
        String descricaoDevolvida = console.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }
    
    //[nome do métod][Estado de teste][resultado esperado]
    //[deve][resultado esperado][estado de teste]
    
    @Test
    public void deve_devolverMaiorLance_quandoRecebeApenasUmLance() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Alex"), 200.0));

        double maiorLanceDevolvidoDoConsole = console.getMaiorLance();
        
        assertEquals(200.0, maiorLanceDevolvidoDoConsole, 0.0001);
    }
    
    @Test
    public void deve_devolverMaiorLance_quandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Alex"), 100.0));
        computador.propoe(new Lance(new Usuario("Fran"), 200.0));

        double maiorLanceDevolvidoDoComputador = computador.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvidoDoComputador, 0.0001);
    }

    @Test
    public void deve_devolverMaiorLance_quandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Alex"), 10000.0));
        carro.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double maiorLanceDevolvidoDoCarro = carro.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvidoDoCarro, 0.0001);
    }
}