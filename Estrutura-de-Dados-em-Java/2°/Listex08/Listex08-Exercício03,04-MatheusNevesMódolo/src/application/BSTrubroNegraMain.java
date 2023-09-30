package application;

public class BSTrubroNegraMain {

    public static void main(String[] args) {
        BSTrubroNegra arvore = new BSTrubroNegra();
        String[] chaves = {"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};

        for (int i = 0; i < chaves.length; i++) {
            System.out.print(chaves[i] + " ");
            arvore.put(chaves[i], i);
        }
        System.out.println();
        System.out.println("Procurando a Chave (M) e verificando se é VERMELHO...");
        if (arvore.get("M") != null) {
            System.out.println("Chave (M) encontrada!");
        } else {
            System.out.println("A Chave NÃO pertence a Árvore...");
        }

        System.out.println("\nMenor Chave: " + arvore.min());
        System.out.println("Maior Chave: " + arvore.max());

        System.out.println("\nPiso de G: " + arvore.floor("G"));
        System.out.println("Piso de D: " + arvore.floor("D"));

        System.out.println("\nTeto de Q: " + arvore.ceiling("Q"));
        System.out.println("Teto de W: " + arvore.ceiling("W"));
    }
}
