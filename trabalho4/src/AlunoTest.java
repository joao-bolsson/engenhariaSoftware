import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 05 Dec.
 */
class AlunoTest {

    /**
     * Testa o método está aprovado da classe Aluno.
     */
    @Test
    void estaAprovado() {
        System.out.println("[teste estaAprovado()]");
        Aluno joao = new Aluno("João", 6, 4);
        assertFalse(joao.estaAprovado());
        double mediaEsperada = (double) ((6 * Aluno.PESO_PROVA_1) + (4 * Aluno.PESO_PROVA_2)) / (Aluno.PESO_PROVA_1 + Aluno.PESO_PROVA_2);
        assertEquals(mediaEsperada, joao.getMedia());

        Aluno maria = new Aluno("Maria", 7, 9);
        assertTrue(maria.estaAprovado());

        Aluno pedro = new Aluno("Pedro", 5, 9);
        assertTrue(pedro.estaAprovado());
    }

    /**
     * Testa o método está aprovado com exame da classe Aluno.
     */
    @Test
    void estaAprovadoComExame() {
        System.out.println("[teste estaAprovadoComExame()]");
        Aluno joao = new Aluno("João", 6, 4, 6);
        assertTrue(joao.estaAprovadoComExame()); // aprovado com exame

        Aluno maria = new Aluno("Maria", 0, 0, 9);
        assertFalse(maria.estaAprovadoComExame()); // precisava de 10

        Aluno pedro = new Aluno("Pedro", 0, 1, 9.6);
        assertTrue(pedro.estaAprovadoComExame());
    }
}