public class Cliente {
    private String nome;
    private String endereco;
    private Pet[] pets;  // Array de pets
    private int quantidadePets;  // Contador para controlar o número de pets

    // Tamanho máximo inicial do array
    private static final int TAMANHO_INICIAL = 10;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.pets = new Pet[TAMANHO_INICIAL];
        this.quantidadePets = 0;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Pet[] getPets() {
        Pet[] petsAtuais = new Pet[quantidadePets];
        System.arraycopy(pets, 0, petsAtuais, 0, quantidadePets);
        return petsAtuais;
    }

    // Método para adicionar um pet
    public void adicionarPet(Pet pet) {
        // Verifica se é necessário aumentar o tamanho do array
        if (quantidadePets == pets.length) {
            aumentarCapacidade();
        }
        pets[quantidadePets] = pet;
        quantidadePets++;
    }

    // Método para remover um pet
    public boolean removerPet(Pet pet) {
        for (int i = 0; i < quantidadePets; i++) {
            if (pets[i].equals(pet)) {
                // Move todos os elementos à direita do pet removido uma posição para a esquerda
                System.arraycopy(pets, i + 1, pets, i, quantidadePets - i - 1);
                quantidadePets--;
                pets[quantidadePets] = null;  // Limpa a última posição
                return true;
            }
        }
        return false;
    }

    // Método para aumentar a capacidade do array
    private void aumentarCapacidade() {
        Pet[] novoArray = new Pet[pets.length * 2];
        System.arraycopy(pets, 0, novoArray, 0, pets.length);
        pets = novoArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nome).append(", Endereço: ").append(endereco).append("\nPets:\n");
        for (int i = 0; i < quantidadePets; i++) {
            sb.append("- ").append(pets[i].toString()).append("\n");
        }
        return sb.toString();
    }
}