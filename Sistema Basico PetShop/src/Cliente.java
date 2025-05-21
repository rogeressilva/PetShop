import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    private List<Pet> pets;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.pets = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    public boolean removerPet(Pet pet) {
        return pets.remove(pet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nome).append(", Endereço: ").append(endereco).append("\nPets:\n");
        for (Pet pet : pets) {
            sb.append("- ").append(pet.toString()).append("\n");
        }
        return sb.toString();
    }
}