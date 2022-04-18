package biblioteca.n1final.model;

public enum GeneroLivros {

    romance("Genero Romance"),
    terror("Genero Terror"),
    aventura("Genero Aventura"),
    suspense("Genero Suspense"),
    conto("Genero Conto");

    private String nome;

    GeneroLivros(String nome){
        this.nome = nome;
    }
}
