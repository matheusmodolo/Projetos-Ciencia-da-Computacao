#include <stdio.h>
#include <stdlib.h>

void mochila ();
void mochilaSolucao();
void mochilaSolucaoAux(int k, int d);
void imprimirMatriz();

int *c, *w, *x, **z, n, W;

int main() {

    printf("\n Resolucao do problema da Mochila 0-1:");
    printf("\n Forneca a capacidade maxima da moxila (W): ");
    int W;
    scanf("%d", &W);
    printf("\n Quantos itens distintos e unicos existem: ");
    int n;
    scanf("%d", &n);
    c = malloc(n*sizeof(int)+1);
    w = malloc(n*sizeof(int)+1);
    c[0] = 0;
    w[0] = 0;

    for(int i = 1; i<=n; i++) {
        printf(" Peso (w) do item %d: ", i);
        scanf("%d", &w[i]);

        printf(" Custo (c) do item %d: ", i);
        scanf("%d", &c[i]);

        printf("\n");
    }

    printf("\n Possiveis itens a serem adicionados: ");
    for(int i = 1; i<=n; i++) {
        printf("\n Item %d - w: %d / c: %d", i+1, w[i], c[i]);
    }

    z = (int**)malloc((n+1)*sizeof(int*));
    for(int i = 0; i <= n; i++) {
        z[i] = (int*)malloc((W+1)*sizeof(int));
    }
    mochila();
    imprimirMatriz();
    mochilaSolucao();

    return 0;
}
void mochila () {
    int d, k;
    for(d = 0; d <= W; d++) {
        z[0][d] = 0;
    }
    for(k = 0; k<=n; k++) {
        z[k][0] = 0;
    }
    for(k = 1; k<=n; k++) {
        for(d = 1; d<=W; d++) {
            z[k][d] = z[k-1][d];
            if((w[k] <= d)&&((c[k] + z[k-1][d-w[k]])>z[k][d])) {
                z[k][d] = c[k] + z[k-1][d-w[k]];
            }
        }
    }
}
void mochilaSolucao() {
    x = malloc(n * sizeof(int)+1);
    x[0] = 0;

    printf("\n\n Solucao do problema da Mochila 0-1: ");
    printf("\n Custo total dos itens selecionados: %d", z[n][W]);

    for(int i = 1; i<=n; i++) {
        x[i] = 0;
    }
    mochilaSolucaoAux(n, W);

    printf("\n\n Itens selecionados para a Mochila: ");
    for(int i = 1; i <= n; i++) {
        if(x[i] == 1) {
            printf("\n Item %d - w: %d / c: %d", i, w[i], c[i]);
        }
    }

}
void mochilaSolucaoAux(int k, int d) {
    if (k!=0) {
        if(z[k][d] == z[k-1][d]) {
            x[k] = 0;
            mochilaSolucaoAux(k-1, d);
        } else {
            x[k] = 1;
            mochilaSolucaoAux(k-1, d-w[k]);
        }
    }
}

void imprimirMatriz() {
    printf("\n\n Matriz - Programacao Dinamica: \n");
    for(int i = 0; i<=n; i++) {
        for(int j = 0; j<=W; j++) {
            printf(" \t%d", z[i][j]);
        }
        printf("\n");
    }
}
