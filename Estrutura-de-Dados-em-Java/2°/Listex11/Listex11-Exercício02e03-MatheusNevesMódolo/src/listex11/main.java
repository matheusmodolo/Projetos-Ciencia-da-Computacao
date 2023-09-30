package listex11;

import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author nmmat
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TrieST a = new TrieST();
        String[] s = {"SHE", "SELLS", "SEA", "SHELLS", "BY", "THE", "SEA", "SHORE"};

        for (int i = 0; i < s.length; i++) {
            a.put(s[i], i);
        }

        StdOut.println("Procurando pela chave \"SHE\"...");
        if (a.get("SHE") != null) {
            StdOut.println("Chave ENCONTRADA!\n");
        } else {
            StdOut.println("Chave NAO encontrada!\n");
        }
        StdOut.println("Procurando pela chave \"SHELL\"...");
        if (a.get("SHELL") != null) {
            StdOut.println("Chave ENCONTRADA!\n");
        } else {
            StdOut.println("Chave NAO encontrada!\n");
        }

        StdOut.println("Tamanho da Trie (numero de CHAVES): " + a.size()
                + "\n");

        StdOut.println("Removendo a chave \"SEAS\"...");
        if (a.contains("SEAS") == false) {
            StdOut.println("A chave NAO EXISTE!\n");
        } else {
            a.delete("SEAS");
            StdOut.println("Chave REMOVIDA com Sucesso!\n");
        }

        StdOut.println("Removendo a chave \"SEA\"...");
        if (a.contains("SEA") == false) {
            StdOut.println("A chave NAO EXISTE!\n");
        } else {
            a.delete("SEA");
            StdOut.println("Chave REMOVIDA com Sucesso!\n");
        }

        StdOut.println("Procurando por \"SEA\":\n");
        if (a.get("SEA") != null) {
            StdOut.println("Chave ENCONTRADA!\n");
        } else {
            StdOut.println("Chave NAO encontrada!\n");
        }

        StdOut.println("Tamanho da Trie (numero de CHAVES): " + a.size());
    }
}
