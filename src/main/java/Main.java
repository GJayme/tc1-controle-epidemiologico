import dao.LocalDAO;
import dao.PragaDAO;
import domain.Local;
import domain.Praga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static LocalDAO localDAO;
    private static PragaDAO pragaDAO;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        localDAO = new LocalDAO();
        pragaDAO = new PragaDAO();

        int opcaoMenu = -1;
        int opcaoSubmenu = -1;

        while (true) {
            opcaoMenu = exibirMenu();
            opcaoSubmenu = exibirSubmenu(opcaoMenu);

            if (opcaoMenu == 1) {
                switch (opcaoSubmenu) {
                    case 1:
                        inserirLocal();
                        break;
                    case 2:
                        alterarLocal();
                        break;
                    case 3:
                        excluirLocal();
                        break;
                    case 4:
                        listarUmLocal();
                        break;
                    case 5:
                        listarTodosLocais();
                        break;
                }
            } else if (opcaoMenu == 2) {
                switch (opcaoSubmenu) {
                    case 1:
                        inserirPraga();
                        break;
                    case 2:
                        alterarPraga();
                        break;
                    case 3:
                        excluirPraga();
                        break;
                    case 4:
                        listarUmaPraga();
                        break;
                    case 5:
                        listarTodasPragas();
                        break;
                }
            }
        }
    }

    private static void inserirPraga(){
        Boolean maisDoencas = true;
        Boolean maisModos = true;
        Praga praga = new Praga();

        System.out.println("\nINSERIR PRAGA\n");

        System.out.println("Código: ");
        praga.setCodigo(scanner.next());

        System.out.println("Nome: ");
        praga.setNome(scanner.next());

        System.out.println("Lista de doenças transmitidas: ");
        while (maisDoencas) {
            List<String> doencasTransmitidas = new ArrayList<>();
            switch (exibirAddMais()){
                case(1):
                    System.out.println("Nova doenças transmitidas: ");
                    String doenca;
                    doenca = scanner.next();
                    doencasTransmitidas.add(doenca);
                    break;
                case (2):
                    maisDoencas = false;
                    break;
            }
            praga.setDoencasTransmitidas(doencasTransmitidas);
        }

        System.out.println("Tempo de vida: ");
        praga.setTempoDeVida(Integer.parseInt(scanner.next()));

        System.out.println("Lista de modos de combate: ");
        while (maisModos) {
            List<String> modosDeCombate = new ArrayList<>();
            switch (exibirAddMais()){
                case(1):
                    System.out.println("Novo modo de combate: ");
                    String modo;
                    modo = scanner.next();
                    modosDeCombate.add(modo);
                    break;
                case (2):
                    maisModos = false;
                    break;
            }
            praga.setModosCombate(modosDeCombate);
        }

        pragaDAO.inserirPraga(praga);
    }

    private static void alterarPraga(){
        
    }

    private static void excluirPraga(){
        System.out.println("Código da praga que deseja excluir: ");
        String codigo = scanner.next();
        pragaDAO.excluirPraga(codigo);
    }

    private static void listarUmaPraga(){
        System.out.println("Código do praga que deseja listar: ");
        String codigo = scanner.next();
        Praga praga = pragaDAO.getPraga(codigo);

        if (praga == null) {
            return;
        }
        exibirInformacoesPraga(praga);
    }

    private static void listarTodasPragas(){
        List<Praga> pragaList = pragaDAO.getPragas();
        System.out.println("_________ Lista de pragas _________");
        for(Praga praga : pragaList){
            exibirInformacoesPraga(praga);
            System.out.println("\n");
        }
        System.out.println("_________ Fim da Lista de pragas _________");
    }

    public static void exibirInformacoesPraga(Praga praga) {
        System.out.println("Código: " + praga.getCodigo());
        System.out.println("Nome: " + praga.getNome());
        System.out.println("Doenças transmitidas: " + praga.getDoencasTransmitidas());
        System.out.println("Tempo de vida: " + praga.getTempoDeVida());
        System.out.println("Modos de combate: " + praga.getModosCombate());
    }

    public static void exibirInformacoesLocal(Local local){
        System.out.println("CEP Ponto Central: "+ local.getCepPontoCentral());
        System.out.println("Raio: " + local.getRaio());
        System.out.println("População: " + local.getPopulacao());
        System.out.println("Caracteristicas: " + local.getCaracteristicas());
        System.out.println("Telefone defesa civil: " + local.getTelefoneDefesaCivil());
    }

    private static void listarTodosLocais() {
        List<Local> locais = localDAO.getLocais();
        System.out.println("_________ Lista de locais _________");
        for (Local local : locais) {
            exibirInformacoesLocal(local);
            System.out.println("\n");
        }
        System.out.println("_________ Fim da Lista de locais _________");
    }

    private static void listarUmLocal() {
        System.out.println("CEP do ponto central que deseja listar: ");
        String cep = scanner.next();
        Local local = localDAO.getLocal(cep);
        if (local == null) {
            return;
        }
        exibirInformacoesLocal(local);
    }

    private static void excluirLocal() {
        System.out.println("CEP de um local que deseja excluir:");
        String cep = scanner.next();
        localDAO.excluirLocal(cep);
    }

    private static void alterarLocal() {
        System.out.println("CEP de um local que deseja alterar: ");
        String cep = scanner.next();
        Local local = localDAO.getLocal(cep);
        if (local == null) {
            return;
        }
        exibirInformacoesLocal(local);

        Local local2 = new Local();
        local2.setCepPontoCentral(local.getCepPontoCentral());

        System.out.println("Raio: ");
        local2.setRaio(Integer.parseInt(scanner.next()));

        System.out.println("População: ");
        local2.setPopulacao(Integer.parseInt(scanner.next()));

        System.out.println("Caracteristicas: ");
        local2.setCaracteristicas(scanner.next());

        System.out.println("Telefone Defesa Civil: ");
        local2.setTelefoneDefesaCivil(scanner.next());

        localDAO.alterarLocal(local2);
    }

    private static void inserirLocal() {
        Local local = new Local();
        System.out.println("INSERIR LOCAL");

        System.out.println("CEP Ponto Central: ");
        local.setCepPontoCentral(scanner.next());

        System.out.println("Raio: ");
        local.setRaio(Integer.parseInt(scanner.next()));

        System.out.println("População: ");
        local.setPopulacao(Integer.parseInt(scanner.next()));

        System.out.println("Caracteristicas: ");
        local.setCaracteristicas(scanner.next());

        System.out.println("Telefone Defesa Civil: ");
        local.setTelefoneDefesaCivil(scanner.next());

        localDAO.inserirLocal(local);
    }

    private static int exibirMenu() {
        System.out.println();
        System.out.println("+++++++++++++ MENU PRINCIPAL +++++++++++++");
        System.out.println("1. Submenu de Local");
        System.out.println("2. Submenu de Praga");
        System.out.println("3. Sair");
        return scanner.nextInt();
    }

    private static int exibirSubmenu(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                return exibirSubmenuLocal();
            case 2:
                return exibirSubmenuPragas();
            case 3:
                System.exit(1);
            default:
                return -1;
        }
    }

    private static int exibirSubmenuLocal() {
        System.out.println("------ Submenu de Locais -------");
        System.out.println("1. Inserir local");
        System.out.println("2. Alterar local");
        System.out.println("3. Excluir local");
        System.out.println("4. Listar um local");
        System.out.println("5. Listar todos os locais");
        return scanner.nextInt();
    }

    private static int exibirSubmenuPragas() {
        System.out.println("------ Submenu de Pragas -------");
        System.out.println("1. Inserir praga");
        System.out.println("2. Alterar praga");
        System.out.println("3. Excluir praga");
        System.out.println("4. Listar um praga");
        System.out.println("5. Listar todos os pragas");
        return scanner.nextInt();
    }

    private static int exibirAddMais() {
        System.out.println("------ Incluir mais ? -------");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        return scanner.nextInt();
    }

}
