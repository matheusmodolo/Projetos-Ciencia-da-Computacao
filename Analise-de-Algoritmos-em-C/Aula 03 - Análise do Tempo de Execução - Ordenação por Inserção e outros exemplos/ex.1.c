#include <stdio.h>
#include <stdlib.h>

int cont = 0;

void ordenar (int *a, int n);

void printar (int *a, int n);

int main(){

    srand(time(NULL));

    int n;

    printf("Entre com um tamanho do Array de inteiros: ");
    scanf("%d", &n);

    int i;
    int r;
    int a[n];

    for (i=0; i<n; i++){
        r = rand()%100;
        a[i] = r;
        printf("%d ", a[i]);
    }

    ordenar(a, n);


    return 0;
}

void ordenar (int *a, int n){
        int c;
        int j;
        int i;
        for(j=1; j<=n; j++){
            c = a[j];
            i = j - 1;
            printf("\nArray Desord.[] = ");
            printar(a, n);
            if(j!=n){
                printf(" - %d", c);
            }
            while(i>=0 && a[i]< c){
                a[i+1] = a[i];
                i = i - 1;
                cont++;
            }
            a[i+1] = c;


        }
            printf("\nArray Ord.   [] = ");
            printar(a, n);
            printf("\nNumeros de operacoes de Ordenacao: %d", cont);

}

void printar (int *a, int n){
    for(int i = 0; i < n; i++){
        printf("%d ", a[i]);
    }

}


