import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private List<Produto> estoque;
    private Scanner scanner;

    public Principal() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        estoque = new ArrayList<>();
        scanner = new Scanner(System.in);
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
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarPet();
                    break;
                case 3:
                    cadastrarFuncionario();
                    break;
                case 4:
                    cadastrarProduto();
                    break;
                case 5:
                    buscarInformacoes();
                    break;
                case 6:
                    removerInformacoes();
                    break;
                case 7:
                    listarTodos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.println("\n=== Cadastrar Cliente ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        Cliente cliente = new Cliente(nome, endereco);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void cadastrarPet() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados. Cadastre um cliente primeiro.");
            return;
        }
        
        System.out.println("\n=== Cadastrar Pet ===");
        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Escolha o cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer
        
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Índice inválido!");
            return;
        }
        
        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        System.out.println("Tipo de pet:");
        System.out.println("1. Mamífero");
        System.out.println("2. Peixe");
        System.out.println("3. Ave");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        Pet pet;
        switch (tipo) {
            case 1:
                System.out.print("Tipo de pelagem: ");
                String pelagem = scanner.nextLine();
                pet = new Mamifero(nome, raca, idade, pelagem);
                break;
            case 2:
                System.out.print("Tipo de água (doce/salgada): ");
                String tipoAgua = scanner.nextLine();
                pet = new Peixe(nome, raca, idade, tipoAgua);
                break;
            case 3:
                System.out.print("Tamanho do bico (pequeno/médio/grande): ");
                String tamanhoBico = scanner.nextLine();
                pet = new Ave(nome, raca, idade, tamanhoBico);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        clientes.get(clienteIndex).adicionarPet(pet);
        System.out.println("Pet cadastrado com sucesso!");
    }

    private void cadastrarFuncionario() {
        System.out.println("\n=== Cadastrar Funcionário ===");
        System.out.println("Tipo de funcionário:");
        System.out.println("1. Funcionário Comum");
        System.out.println("2. Veterinário");
        System.out.println("3. Gestor");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Salário: R$");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        
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
                scanner.nextLine(); // Limpar buffer
                funcionario = new Gestor(nome, endereco, salario, departamento, bonus);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void cadastrarProduto() {
        System.out.println("\n=== Cadastrar Produto ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Valor: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        Produto produto = new Produto(nome, valor, descricao, quantidade);
        estoque.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void buscarInformacoes() {
        System.out.println("\n=== Buscar Informações ===");
        System.out.println("1. Buscar Pets por raça");
        System.out.println("2. Buscar Pets por tipo");
        System.out.println("3. Buscar endereço de cliente");
        System.out.println("4. Buscar salário de funcionário");
        System.out.println("5. Buscar produtos por nome");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        switch (opcao) {
            case 1:
                buscarPetsPorRaca();
                break;
            case 2:
                buscarPetsPorTipo();
                break;
            case 3:
                buscarEnderecoCliente();
                break;
            case 4:
                buscarSalarioFuncionario();
                break;
            case 5:
                buscarProdutosPorNome();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void buscarPetsPorRaca() {
        System.out.print("Digite a raça para buscar: ");
        String raca = scanner.nextLine();
        
        System.out.println("\nPets encontrados:");
        for (Cliente cliente : clientes) {
            for (Pet pet : cliente.getPets()) {
                if (pet.getRaca().equalsIgnoreCase(raca)) {
                    System.out.println("- " + pet + " (Dono: " + cliente.getNome() + ")");
                }
            }
        }
    }

    private void buscarPetsPorTipo() {
        System.out.println("Tipos disponíveis:");
        System.out.println("1. Mamífero");
        System.out.println("2. Peixe");
        System.out.println("3. Ave");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        String tipoStr;
        switch (tipo) {
            case 1: tipoStr = "Mamífero"; break;
            case 2: tipoStr = "Peixe"; break;
            case 3: tipoStr = "Ave"; break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        System.out.println("\nPets encontrados:");
        for (Cliente cliente : clientes) {
            for (Pet pet : cliente.getPets()) {
                if (pet.getTipo().equalsIgnoreCase(tipoStr)) {
                    System.out.println("- " + pet + " (Dono: " + cliente.getNome() + ")");
                }
            }
        }
    }

    private void buscarEnderecoCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Endereço de " + nome + ": " + cliente.getEndereco());
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    private void buscarSalarioFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        
        for (Funcionario func : funcionarios) {
            if (func.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Salário de " + nome + ": R$" + func.getSalario());
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    private void buscarProdutosPorNome() {
        System.out.print("Digite parte do nome do produto: ");
        String nome = scanner.nextLine();
        
        System.out.println("\nProdutos encontrados:");
        for (Produto produto : estoque) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println("- " + produto);
            }
        }
    }

    private void removerInformacoes() {
        System.out.println("\n=== Remover Informações ===");
        System.out.println("1. Remover Cliente");
        System.out.println("2. Remover Pet");
        System.out.println("3. Remover Funcionário");
        System.out.println("4. Remover Produto");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        switch (opcao) {
            case 1:
                removerCliente();
                break;
            case 2:
                removerPet();
                break;
            case 3:
                removerFuncionario();
                break;
            case 4:
                removerProduto();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void removerCliente() {
        System.out.println("\nClientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Escolha o cliente para remover: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer
        
        if (index >= 0 && index < clientes.size()) {
            Cliente removido = clientes.remove(index);
            System.out.println("Cliente " + removido.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private void removerPet() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }
        
        System.out.println("\nClientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Escolha o cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer
        
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Índice inválido!");
            return;
        }
        
        Cliente cliente = clientes.get(clienteIndex);
        if (cliente.getPets().isEmpty()) {
            System.out.println("Este cliente não possui pets.");
            return;
        }
        
        System.out.println("\nPets do cliente " + cliente.getNome() + ":");
        for (int i = 0; i < cliente.getPets().size(); i++) {
            System.out.println((i + 1) + ". " + cliente.getPets().get(i));
        }
        System.out.print("Escolha o pet para remover: ");
        int petIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer
        
        if (petIndex >= 0 && petIndex < cliente.getPets().size()) {
            Pet removido = cliente.getPets().remove(petIndex);
            System.out.println("Pet " + removido.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private void removerFuncionario() {
        System.out.println("\nFuncionários disponíveis:");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i + 1) + ". " + funcionarios.get(i).getNome());
        }
        System.out.print("Escolha o funcionário para remover: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer
        
        if (index >= 0 && index < funcionarios.size()) {
            Funcionario removido = funcionarios.remove(index);
            System.out.println("Funcionário " + removido.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private void removerProduto() {
        System.out.println("\nProdutos disponíveis:");
        for (int i = 0; i < estoque.size(); i++) {
            System.out.println((i + 1) + ". " + estoque.get(i));
        }
        System.out.print("Escolha o produto para remover: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer
        
        if (index >= 0 && index < estoque.size()) {
            Produto removido = estoque.remove(index);
            System.out.println("Produto " + removido.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private void listarTodos() {
        System.out.println("\n=== Listagem Completa ===");
        
        System.out.println("\nClientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        
        System.out.println("\nFuncionários:");
        for (Funcionario func : funcionarios) {
            System.out.println(func);
        }
        
        System.out.println("\nEstoque:");
        for (Produto produto : estoque) {
            System.out.println(produto);
        }
    }

    public static void main(String[] args) {
        Principal sistema = new Principal();
        sistema.executar();
    }
}