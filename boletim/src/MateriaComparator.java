import java.util.Comparator;

public class MateriaComparator implements Comparator<Materia> {

    // Uma função que utilizo para definir a regra de ordenação das Matérias
    // No caso eu fiz que seja ordenado por nota e decrescente.
    @Override
    public int compare(Materia m1, Materia m2) {
        return m2.getNota().compareTo(m1.getNota());
    }
}
