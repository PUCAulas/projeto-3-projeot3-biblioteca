import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // menu
        Scanner entrada = new Scanner(System.in);
        int escolha;
        Biblioteca bib = new Biblioteca();
        // teste APAGAR DEPOIS
        Livro l1 = new Livro("Pedro", "titulo", 2021, 4);
        CD l2 = new CD("Alex", "titulo", 2021, 4);
        Livro l3 = new Livro("Alex", "titulo", 2021, 4);
        bib.addItem(l1);
        bib.addItem(l2);
        bib.addItem(l3);

        bib.addUsuario("jorge");
        bib.addUsuario("felipe");
        //////////////
        System.out.println("Bem vindo a biblioteca!");
        do {
            System.out.print("\n");
            System.out.println("Escolha o numero do que deseja fazer: ");
            System.out.println("1. SubMenu Usuarios");// menu de CRUD para usuario
            System.out.println("2. SubMeunu Itens");// menu de CRUD para itens e opção de pesquisar por item conforme
                                                    // requisito C
            System.out.println("3. SubMenu Relatiorios");// menu para relatorios do requisito D
            System.out.println("0. Sair Do Sistema");

            escolha = entrada.nextInt();

            switch (escolha) {
                case 0:
                    System.out.println("Saindo do programa. Adeus!");
                    break;
                case 1:
                    subUsuario(entrada, bib);
                    break;
                case 2:

                    subItens(entrada, bib);
                    break;
                case 3:
                    System.out.println("Saindo do programa. Adeus!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (escolha != 0);
    }

    public static void subItens(Scanner entrada, Biblioteca bib) {
        int subChoice = 110;

        do {// falta crud dos itens
            System.out.print("\n");
            System.out.println("Submenu da Opção 2, Itens:");
            System.out.println("1. Pesquisar Por Titulo");
            System.out.println("2. Pesquisar Por Autor");
            System.out.println("3. Pesquisar Por Ano");
            System.out.println("4. Pesquisar Por Tipo");
            System.out.println("0. Sair");

            subChoice = entrada.nextInt();

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando para o Menu Principal!");
                    break;
                case 1:
                    entrada.nextLine();
                    System.out.println("Digite O Titulo Para Pesquisa: ");
                    bib.pesquisarPorTitulo(entrada.nextLine());
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Digite O Autor Para Pesquisa: ");
                    bib.pesquisarPorAutor(entrada.nextLine());
                    break;
                case 3:
                    System.out.println("Digite O Ano Para Pesquisa: ");
                    bib.pesquisarPorAno(entrada.nextInt());
                    break;
                case 4:
                    System.out.println("Escolha O Tipo Para Pesquisa: ");
                    System.out.println("1. Livros");
                    System.out.println("2. Teses");
                    System.out.println("3. CDs");
                    System.out.println("4. DVDs");
                    System.out.println("5. Revistas");
                    int tipo = entrada.nextInt();
                    switch (tipo) {
                        case 1:
                            bib.pesquisarPorTipo("Livro");
                            break;
                        case 2:
                            bib.pesquisarPorTipo("Tese");
                            break;
                        case 3:
                            bib.pesquisarPorTipo("CD");
                            break;
                        case 4:
                            bib.pesquisarPorTipo("DVD");
                            break;
                        case 5:
                            bib.pesquisarPorTipo("Revista");
                            break;

                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }

    public static void subUsuario(Scanner entrada, Biblioteca bib) {
        int subChoice;

        do {
            System.out.print("\n");
            System.out.println("Submenu da Opção 1, Usuario:");
            System.out.println("1. Ver todos usuários");
            System.out.println("2. Adicionar novo usuário");
            System.out.println("3. Itens emprestados de um usuario");
            System.out.println("4. Pegar um item emprestado");
            
            System.out.println("0. Sair");

            subChoice = entrada.nextInt();

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando para o Menu Principal!");
                    break;
                case 1:
                    bib.imprimirUsuarios();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Digite o nome do usuario: ");
                    bib.addUsuario(entrada.nextLine());
                    break;
                case 3:
                    bib.imprimirUsuarios();
                    entrada.nextLine();
                    System.out.println("Digite o id do usuário: ");
                    bib.pesquisarPorAno(entrada.nextInt());
                    break;
                case 4:
                    bib.imprimirUsuarios();
                    entrada.nextLine();
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }
}
