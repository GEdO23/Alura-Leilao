package br.com.alura.leilao.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class LeilaoTest {

    private final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario ALEX = new Usuario("Alex");
    
    @Test
    public void deve_devolverDescricao_quandoRecebeDescricao() {
        // executar ação esperada
        String descricaoDevolvida = CONSOLE.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }
    
    //[nome do métod][Estado de teste][resultado esperado]
    //[deve][resultado esperado][estado de teste]
    
    @Test
    public void deve_devolverMaiorLance_quandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();
        
        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }
    
    @Test
    public void deve_devolverMaiorLance_quandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_devolverMaiorLance_quandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvido, DELTA);
    }
    
    @Test
    public void deve_devolverMenorLance_quandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, DELTA);
    }
    
    @Test
    public void deve_devolverMenorLance_quandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_devolverMenorLance_quandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(9000.0, menorLanceDevolvido, DELTA);
    }
    
    @Test
    public void deve_devolverTresMaioresLances_quandoRecebeExatosTresLances() {
        CONSOLE.propoe(new Lance(ALEX, 200.00));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 300));
        CONSOLE.propoe(new Lance(ALEX, 400.0));
        
        // Teste Driven Development
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        
        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }
    
    @Test
    public void deve_devolverTresMaioresLances_quandoNaoRecebeLances() {
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        
        assertEquals(0, tresMaioresLancesDevolvidos.size());
    }
    
    @Test
    public void deve_devolverTresMaioresLances_quandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.00));
        
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(1, tresMaioresLancesDevolvidos.size());
        assertEquals(200.00, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
    }
    
    @Test
    public void deve_devolverTresMaioresLances_quandoRecebeApenasDoisLances() {
        CONSOLE.propoe(new Lance(ALEX, 200.00));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 300));
        
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(2, tresMaioresLancesDevolvidos.size());
        assertEquals(300.00, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(200.00, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
    }

    @Test
    public void deve_devolverTresMaioresLances_quandoRecebeMaisDeTresLances() {
        CONSOLE.propoe(new Lance(ALEX, 300.0));
        final Usuario FRAN = new Usuario("Fran");
        CONSOLE.propoe(new Lance(FRAN, 400.0));
        CONSOLE.propoe(new Lance(ALEX, 500.00));
        CONSOLE.propoe(new Lance(FRAN, 600.0));
        CONSOLE.propoe(new Lance(ALEX, 700.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(700.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(600.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(500.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }
}