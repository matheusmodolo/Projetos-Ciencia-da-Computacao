#include <stdio.h>
#include <stdlib.h>

int buscar( const int *a, int n, int chave );

int main(){
    int a[10];
    int *pa = a;
    int chave;
    int i;

    for(i=0; i<10; i++){
        printf("n[%d]: ", i);
        scanf("%d", &a[i]);
    }

    printf("Buscar por: ");
    scanf("%d", &chave);

    printf("O valor %d ", chave);

    if(buscar(pa, 10, chave)!=-1){
        printf("foi encontrado na posicao %d.", buscar(pa, 10, chave));
    }else{
        printf("nao foi encontrado.");
    }

    return 0;
}

int buscar( const int *a, int n, int chave ){

    int cont = -1;

    for (int i = 0; i<n; i++){
        if (chave == a[i]){
            return i;
        }
    }

    return -1;
}
