#include <stdio.h>
#include <stdlib.h>

int shakeSort (int *a, int n);
void imprimir(int *a, int n);

int main(){

    printf("Shake Sort\n");

    srand(time(NULL));
    printf("\nTamanho do Array: ");
    int n;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i<n; i++){
        a[i] = rand()%100;
    }
    imprimir(a, n);
    shakeSort(a, n);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}

int shakeSort(int *a, int n){
    int l = 0, r = n-1, k=n-1, j, aux;
    do{
        for(j = l; j<r; j++){
            if(a[j]>a[j+1]){
                aux = a[j];
                a[j] = a[j+1];
                a[j+1] = aux;
                k = j;
            }
        }
        r = k;
        for(j=r; j>l; j--){
            if(a[j-1]>a[j]){
                aux = a[j-1];
                a[j-1]=a[j];
                a[j] = aux;
                k = j;

            }
        }
        l = k;
        imprimir(a, n);
    }while(l<r);
}

void imprimir(int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
/*
int selectSort(int *a, int n){
    int i, j, k, x, aux;
    for(i = 0; i < n-1; i++){
        aux = 0;
        k = i;
        x = a[i];
        for(j = i+1; j < n; j++){
            if(a[j]<x){
                k = j;
                x = a[k];
                aux = 1;
            }
        }
        if(aux == 1){
            a[k] = a[i];
            a[i] = k;
        }
        imprimir(a, n);
    }
}
*/
