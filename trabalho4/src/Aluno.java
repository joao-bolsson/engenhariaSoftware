/**
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @since 2017, 05 Dec.
 */
public class Aluno {

    /**
     * Nome do Aluno.
     */
    private final String nome;

    /**
     * Nota da primeira prova.
     */
    private final double notaA;

    /**
     * Nota da segunda prova.
     */
    private final double notaB;

    /**
     * Peso da primeira prova.
     */
    public static final int PESO_PROVA_1 = 4;

    /**
     * Peso da segunda prova.
     */
    public static final int PESO_PROVA_2 = 6;

    /**
     * Média mínima das duas provas que o Aluno precisa para ser aprovado.
     */
    private static final int MEDIA_MINIMA = 7;

    /**
     * Nota mínima que o Aluno precisa para ser aprovado com exame.
     */
    private static final int MEDIA_EXAME = 5;

    /**
     * Média do Aluno.
     */
    private double media;

    /**
     * Nota que o aluno tirou no exame (opcional).
     */
    private double notaExame;

    /**
     * Cria um Aluno.
     *
     * @param nome  Nome do aluno.
     * @param notaA Primeira nota da prova.
     * @param notaB Segunda nota da prova.
     */
    public Aluno(final String nome, final double notaA, final double notaB) {
        this.nome = nome;
        this.notaA = notaA;
        this.notaB = notaB;
        this.notaExame = 0;
        setMedia();
    }

    /**
     * Cria um Aluno que precisa de exame para tentar ser aprovado.
     *
     * @param nome      Nome do Aluno.
     * @param notaA     Primeira nota da prova.
     * @param notaB     Segunda nota da prova.
     * @param notaExame Nota no exame.
     */
    public Aluno(final String nome, final double notaA, final double notaB, final double notaExame) {
        this.nome = nome;
        this.notaA = notaA;
        this.notaB = notaB;
        this.notaExame = notaExame;
        setMedia();
    }

    private void setMedia() {
        media = ((notaA * PESO_PROVA_1) + (notaB * PESO_PROVA_2)) / (PESO_PROVA_1 + PESO_PROVA_2);
    }

    /**
     * @return Se o Aluno tem média superior ou igual à necessária - true, senão - false.
     */
    public boolean estaAprovado() {
        System.out.println(nome + ", média: " + media);
        return media >= MEDIA_MINIMA;
    }

    /**
     * Cálculo para decidir se o aluno passou no exame: (media + exame) / 2 > MEDIA_EXAME
     *
     * @return Se o Aluno tem nota suficiente (com o exame) para ser aprovado - true, senão - false.
     */
    public boolean estaAprovadoComExame() {
        if (!estaAprovado()) {
            double mediaExame = (media + notaExame) / 2;
            System.out.println(nome + ", média com exame: " + mediaExame);
            return mediaExame > MEDIA_EXAME;
        }
        return true;
    }

    public double getMedia() {
        return media;
    }
}
