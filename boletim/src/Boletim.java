import java.util.ArrayList;

public class Boletim {

    public static void main(String[] args) {
        int menu = 10;
        ArrayList<Materia> materias = new ArrayList<Materia>();
        Utils utils = new Utils();
        boolean first = true;

        do {

            // Precisa dar um Enter para continuar
            // Não funciona na primeira
            if(first) {
                first = false;
            } else {
                utils.sc.nextLine();
            }

            menu();

            // Não deixa o usuário colocar um valor diferente de Int
            // Se colocar vai cair no catch e entrar um valor invalido para repetir
            try {
                menu = utils.sc.nextInt();
            } catch (Exception e) {
                menu = 10;
            }
            // Limpa o buffer
            // Resolve um problema que acontece após apertar entre do nextInt
            utils.sc.nextLine();

            switch (menu) {
                case 1:
                    materias.add(utils.adicionarMateria());
                    break;

                case 2:
                    System.out.print("Matéria para excluir: ");
                    String nome = utils.sc.nextLine();
                    Materia materia = utils.achaMateriaPorNome(materias, nome);

                    if(materia != null) {
                        materias.remove(materia);
                        System.out.println("Matéria excluída.");
                    } else {
                        System.out.println("Matéria não encontrada!");
                    }
                    break;

                case 3:
                    utils.imprimirMaterias(materias);
                    break;

                case 4:
                    utils.imprimirMaiorMenor(materias);
                    break;

                case 5:
                    materias.clear();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while(menu != 0);
    }

    private static void menu() {
        System.out.println("1- Inserir uma matéria e nota.");
        System.out.println("2- Excluir uma matéria.");
        System.out.println("3- Mostrar todas as notas.");
        System.out.println("4- Mostrar maior e menor nota.");
        System.out.println("5- Limpar lista.");
        System.out.println("0- Finalizar Programa.");
        System.out.print("Opção: ");
    }
}
