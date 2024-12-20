package br.com.alura.leilao.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {

    private Leilao console = new Leilao("Console");
    private Usuario alex = new Usuario("Alex");
    private Usuario fran = new Usuario("Fran");
    
    @Test
    public void deve_devolverDescricao_quandoRecebeDescricao() {
        // executar ação esperada
        String descricaoDevolvida = console.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }
    
    //[nome do métod][Estado de teste][resultado esperado]
    //[deve][resultado esperado][estado de teste]
    
    @Test
    public void deve_devolverMaiorLance_quandoRecebeApenasUmLance() {
        console.propoe(new Lance(alex, 200.0));

        double maiorLanceDevolvido = console.getMaiorLance();
        
        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }
    
    @Test
    public void deve_devolverMaiorLance_quandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(fran, 200.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_devolverMaiorLance_quandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(new Lance(alex, 10000.0));
        console.propoe(new Lance(fran, 9000.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvido, 0.0001);
    }
    
    @Test
    public void deve_devolverMenorLance_quandoRecebeApenasUmLance() {
        console.propoe(new Lance(alex, 200.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }
    
    @Test
    public void deve_devolverMenorLance_quandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(fran, 200.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_devolverMenorLance_quandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(new Lance(alex, 10000.0));
        console.propoe(new Lance(fran, 9000.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(9000.0, menorLanceDevolvido, 0.0001);
    }
}