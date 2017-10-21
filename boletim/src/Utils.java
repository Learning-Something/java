import java.util.*;

public class Utils {

    public static Scanner sc = null;

    public Utils() {
        if(sc == null) {
            sc = new Scanner(System.in);
        }
    }

    public Materia adicionarMateria() {
        Materia materia = new Materia();
        Boolean sucessRead = false;
        Double nota = null;
        String nome = null;

        do {
            // Não deixa o usuário colocar valores vazios ou inválido
            // Se colocar, vai pro catch e repete a operação
            // O atributo successRead me diz que devo sair do while
            try {
                System.out.print("Nome: ");
                nome = sc.nextLine();
                if(!nome.isEmpty())
                    sucessRead = true;
                else
                    throw new NoSuchElementException();
            } catch (NoSuchElementException e) {
                System.out.println("Insira um nome.");
                sucessRead = false;            }
        } while(sucessRead == false);

        sucessRead = false;
        do {
            // Não deixa o usuário inserir um valor inválido ou vazio.
            // Também utilizo o mesmo successRead para saber se leu certo ou não.
            try {
                System.out.print("Nota: ");
                nota = sc.nextDouble();
                sucessRead = true;
            } catch (Exception e) {
                System.out.println("Insira um valor válido.");
                sucessRead = false;
                sc.nextLine();
            }
        } while (sucessRead == false);



        materia.setNome(nome);
        materia.setNota(nota);

        return materia;
    }

    public Materia achaMateriaPorNome(ArrayList<Materia> materias, String nome) {
        // Procura matéria, se achar retorna ela.
        for(Materia materia : materias) {
            if(materia.getNome().equals(nome)) {
                return materia;
            }
        }

        // Se não achar, retorna null
        return null;
    }

    public void imprimirMaterias(ArrayList<Materia> materias) {
        // Atributo que será utilizado para ordenar as matérias por nota
        ArrayList<Materia> materias_ordenadas = materias;

        // Função do próprio Java para ordenar
        // Enviei como segundo parâmetro, a classe de comparação que diz como ele deve ordenar.
        Collections.sort(materias_ordenadas, new MateriaComparator());

        System.out.println("\nMatéria\t\t-\t\tNota");
        for(Materia materia: materias_ordenadas) {
            System.out.println(materia.getNome() + "\t\t-\t\t" + materia.getNota());
        }
        System.out.println("\n");
    }

    public void imprimirMaiorMenor(ArrayList<Materia> materias) {
        // Variável irá guardar a maior nota encontrada
        Double notaMaior = 0.0;

        // Variável que irá encontrar a menor nota encontrada
        // Para achar a menor nota, utilizei um recuso que insere o maior número possível.
        Double notaMenor = Double.POSITIVE_INFINITY;

        // Atributos que irão guardar as matérias com maior e menor nota.
        Materia materiaMaior = null;
        Materia materiaMenor = null;

        for(Materia materia: materias) {

            // Verifico se a nota da matéria atual é maior do que a notaMaior já encontrada.
            if(materia.getNota() > notaMaior) {
                notaMaior = materia.getNota();
                materiaMaior = materia;
            }

            // Verifico se a nota da materia atual é menor do que a notaMenor já encontrada.
            if(materia.getNota() < notaMenor) {
                notaMenor = materia.getNota();
                materiaMenor = materia;
            }
        }

        if(materiaMaior != null) {
            System.out.println("\nMaior nota: " + materiaMaior.getNome() + "\t\t-\t\t" + materiaMaior.getNota());
        }

        if(materiaMenor != null) {
            System.out.println("Menor nota: " + materiaMenor.getNome() + "\t\t-\t\t" + materiaMenor.getNota() + "\n");
        }
    }
}
