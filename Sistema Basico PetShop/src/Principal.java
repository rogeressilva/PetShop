import java.util.Scanner;

public class Principal {
    private Cliente[] clientes;
    private Funcionario[] funcionarios;
    private Produto[] estoque;
    private Scanner scanner;
    
    private int numClientes;
    private int numFuncionarios;
    private int numProdutos;
    private static final int TAMANHO_INICIAL = 10;

    public Principal() {
        clientes = new Cliente[TAMANHO_INICIAL];
        funcionarios = new Funcionario[TAMANHO_INICIAL];
        estoque = new Produto[TAMANHO_INICIAL];
        scanner = new Scanner(System.in);
        numClientes = 0;
        numFuncionarios = 0;
        numProdutos = 0;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n=== Sistema PetShop ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Pet");
            System.out.println("3. Cadastrar Funcionário");
            System.out.println("4. Cadastrar Produto");
            System.out.println("5. Buscar Informações");
            System.out.println("6. Remover Informações");
            System.out.println("7. Listar Todos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: cadastrarPet(); break;
                case 3: cadastrarFuncionario(); break;
                case 4: cadastrarProduto(); break;
                case 5: buscarInformacoes(); break;
                case 6: removerInformacoes(); break;
                case 7: listarTodos(); break;
                case 0: System.out.println("Saindo do sistema..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        if (numClientes == clientes.length) {
            aumentarArrayClientes();
        }
        
        System.out.println("\n=== Cadastrar Cliente ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        clientes[numClientes++] = new Cliente(nome, endereco);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void aumentarArrayClientes() {
        Cliente[] novoArray = new Cliente[clientes.length * 2];
        System.arraycopy(clientes, 0, novoArray, 0, clientes.length);
        clientes = novoArray;
    }

    private void cadastrarPet() {
        if (numClientes == 0) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }
        
        System.out.println("\n=== Cadastrar Pet ===");
        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < numClientes; i++) {
            System.out.println((i + 1) + ". " + clientes[i].getNome());
        }
        System.out.print("Escolha o cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (clienteIndex < 0 || clienteIndex >= numClientes) {
            System.out.println("Índice inválido!");
            return;
        }
        
        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Tipo de pet:");
        System.out.println("1. Mamífero");
        System.out.println("2. Peixe");
        System.out.println("3. Ave");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        Pet pet;
        switch (tipo) {
            case 1:
                System.out.print("Tipo de pelagem: ");
                String pelagem = scanner.nextLine();
                pet = new Mamifero(nome, raca, idade, pelagem);
                break;
            case 2:
                System.out.print("Tipo de água: ");
                String tipoAgua = scanner.nextLine();
                pet = new Peixe(nome, raca, idade, tipoAgua);
                break;
            case 3:
                System.out.print("Tamanho do bico: ");
                String tamanhoBico = scanner.nextLine();
                pet = new Ave(nome, raca, idade, tamanhoBico);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        clientes[clienteIndex].adicionarPet(pet);
        System.out.println("Pet cadastrado com sucesso!");
    }

    private void cadastrarFuncionario() {
        if (numFuncionarios == funcionarios.length) {
            aumentarArrayFuncionarios();
        }
        
        System.out.println("\n=== Cadastrar Funcionário ===");
        System.out.println("Tipo de funcionário:");
        System.out.println("1. Funcionário Comum");
        System.out.println("2. Veterinário");
        System.out.println("3. Gestor");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Salário: R$");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        
        Funcionario funcionario;
        switch (tipo) {
            case 1:
                funcionario = new Funcionario(nome, endereco, salario);
                break;
            case 2:
                System.out.print("Especialidade: ");
                String especialidade = scanner.nextLine();
                System.out.print("CRMV: ");
                String crmv = scanner.nextLine();
                funcionario = new Veterinario(nome, endereco, salario, especialidade, crmv);
                break;
            case 3:
                System.out.print("Departamento: ");
                String departamento = scanner.nextLine();
                System.out.print("Bônus: R$");
                double bonus = scanner.nextDouble();
                scanner.nextLine();
                funcionario = new Gestor(nome, endereco, salario, departamento, bonus);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        funcionarios[numFuncionarios++] = funcionario;
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void aumentarArrayFuncionarios() {
        Funcionario[] novoArray = new Funcionario[funcionarios.length * 2];
        System.arraycopy(funcionarios, 0, novoArray, 0, funcionarios.length);
        funcionarios = novoArray;
    }

    private void cadastrarProduto() {
        if (numProdutos == estoque.length) {
            aumentarArrayEstoque();
        }
        
        System.out.println("\n=== Cadastrar Produto ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Valor: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        
        estoque[numProdutos++] = new Produto(nome, valor, descricao, quantidade);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void aumentarArrayEstoque() {
        Produto[] novoArray = new Produto[estoque.length * 2];
        System.arraycopy(estoque, 0, novoArray, 0, estoque.length);
        estoque = novoArray;
    }

    // ... (other methods like buscarInformacoes, removerInformacoes, listarTodos would follow the same pattern)

    public static void main(String[] args) {
        Principal sistema = new Principal();
        sistema.executar();
    }
}

class Cliente {
    private String nome;
    private String endereco;
    private Pet[] pets;
    private int numPets;
    private static final int TAMANHO_INICIAL_PETS = 5;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.pets = new Pet[TAMANHO_INICIAL_PETS];
        this.numPets = 0;
    }

    public void adicionarPet(Pet pet) {
        if (numPets == pets.length) {
            aumentarArrayPets();
        }
        pets[numPets++] = pet;
    }

    private void aumentarArrayPets() {
        Pet[] novoArray = new Pet[pets.length * 2];
        System.arraycopy(pets, 0, novoArray, 0, pets.length);
        pets = novoArray;
    }

    // ... (other methods)
}