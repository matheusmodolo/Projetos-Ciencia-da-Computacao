package BST;

public class BST_main {

    public static void main(String[] args) {
        BST_classes arvore = new BST_classes();
        String[] chaves = {"S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E"};

        for (int i = 0; i < chaves.length; i++) {
            System.out.print(chaves[i] + " ");
            arvore.put(chaves[i], i);
        }

        System.out.println("\n\nProcurando a Chave R...");
        if (arvore.get("R") != null) {
            System.out.println("Chave R encontrada no valor: " + arvore.get("R"));
        }

        System.out.println("Procurando a Chave T...");
        if (arvore.get("T") != null) {
            System.out.println("Chave T encontrada no valor: " + arvore.get("T"));
        } else {
            System.out.println("A Chave nao pertence a arvore!");
        }

        System.out.println("\nMenor Chave: " + arvore.min());
        System.out.println("Maior Chave: " + arvore.max());

        System.out.println("\nPiso de G: " + arvore.floor("G"));
        System.out.println("Piso de D: " + arvore.floor("D"));

        System.out.println("\nTeto de Q: " + arvore.ceiling("Q"));
        System.out.println("Teto de W: " + arvore.ceiling("W"));

        System.out.println("\nTamanho da arvore: " + arvore.size());
        System.out.println("Ranque de C: " + arvore.rank("C"));

        System.out.println("\nRemovendo a menor Chave (" + arvore.min() + ")...");
        arvore.removeMin();
        System.out.println("Menor Chave removida!");
        System.out.println("Tamanho da arvore: " + arvore.size());

        System.out.println("\nProcurando a Chave A...");
        if (arvore.get("A") != null) {
            System.out.println("Chave A encontrada no valor:" + arvore.get("A"));
        } else {
            System.out.println("A Chave nao pertence a arvore!");
        }

        System.out.println("\nRemovendo a maior Chave (" + arvore.max() + ")...");
        arvore.deleteMax();
        System.out.println("Maior Chave removida!");
        System.out.println("Tamanho da arvore: " + arvore.size());

        System.out.println("\nProcurando a Chave X...");
        if (arvore.get("X") != null) {
            System.out.println("Chave X encontrada no valor: " + arvore.get("X"));
        } else {
            System.out.println("A Chave nao pertence a arvore!");
        }

        System.out.println("\nRemovendo a Chave C...");
        arvore.remove("C");
        System.out.println("Chave Removida!");

        System.out.println("\nProcurando a Chave C...");
        if (arvore.get("C") != null) {
            System.out.println("Chave C encontrada no valor: " + arvore.get("C"));
        } else {
            System.out.println("A Chave nao pertence a arvore!");
        }
    }
}
