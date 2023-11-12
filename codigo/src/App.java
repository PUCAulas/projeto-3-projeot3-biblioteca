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

    //menu geral de itens
    public static void subItens(Scanner entrada, Biblioteca bib){
        int subChoice = 110;

        do {//falta crud dos itens
            System.out.print("\n");
            System.out.println("Submenu da Opção 2, Itens:");
            System.out.println("1. Pesquisar");
            System.out.println("2. Cadastrar Novo Item");
            System.out.println("3. Listar");
            System.out.println("4. Editar");//Falta
            System.out.println("5. Deletar");//Falta
            System.out.println("0. Sair");
            
            
            subChoice = entrada.nextInt();
           

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando para o Menu Principal!");
                    break;
                case 1:
                    subPesquisaItem(entrada, bib);
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Que Tipo De Item Deseja Cadastrar:");
                    System.out.println("1. Livros");
                    System.out.println("2. Teses");
                    System.out.println("3. CDs");
                    System.out.println("4. DVDs");
                    System.out.println("5. Revistas");
                    int tipo = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Qual O Autor Do Item?");
                    String autor = entrada.nextLine();
                    System.out.println("Qual O Titulo Do Item?");
                    String titulo = entrada.nextLine();
                    System.out.println("Qual O Ano De Publicacao Do Item?");
                    int ano = entrada.nextInt();
                    System.out.println("Quantos Exemplares Serao Registrados Do Item?");
                    int exemplares = entrada.nextInt();
                    switch (tipo) {
                        case 1:
                            Livro novoLivro = new Livro(autor, titulo, ano, exemplares);
                            bib.addItem(novoLivro);
                            break;
                        case 2:
                            Tese novoTese = new Tese(autor, titulo, ano, exemplares);
                            bib.addItem(novoTese);
                            break;
                        case 3:
                            CD novoCD = new CD(autor, titulo, ano, exemplares);
                            bib.addItem(novoCD);
                            break;
                        case 4:
                            DVD novoDVD = new DVD(autor, titulo, ano, exemplares);
                            bib.addItem(novoDVD);
                            break;
                        case 5:
                            Revista novoRevista = new Revista(autor, titulo, ano, exemplares);
                            bib.addItem(novoRevista);
                            break;
                        default:
                            System.out.println("Tipo Invalido!");
                            break;
                    }
                    break;
                case 3:
                    subListarItem(entrada, bib);
                    break;
                case 4:
                    System.out.println("Houve Um Problema");
                    
                    break;
                case 5:
                    System.out.println("Houve Um Problema");
                    
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }
    //menu de listar de itens
    public static void subListarItem(Scanner entrada, Biblioteca bib){
        int subChoice = 110;

        do {//falta crud dos itens
            System.out.print("\n");
            System.out.println("Escolha A Lista Desejada:");
            System.out.println("1. Listar Por Titulo");
            System.out.println("2. Listar Por Autor");
            System.out.println("3. Listar Por Ano");
            System.out.println("4. Listar Por Tipo");
            System.out.println("0. Sair");
            
            
            subChoice = entrada.nextInt();
           

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando!");
                    break;
                case 1:
                    bib.listarPorTitulo();
                    break;
                case 2:
                    bib.listarPorAutor();
                    break;
                case 3:
                    bib.listarPorAno();
                    break;
                case 4:
                    bib.listarPorTipo();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }
    //menu de pesquisa de itens
    public static void subPesquisaItem(Scanner entrada, Biblioteca bib){
        int subChoice = 110;

        do {//falta crud dos itens
            System.out.print("\n");
            System.out.println("Escolha A Pesquisa Desejada:");
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
    //Fim de itens
    ///////////////////////////////////////

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
