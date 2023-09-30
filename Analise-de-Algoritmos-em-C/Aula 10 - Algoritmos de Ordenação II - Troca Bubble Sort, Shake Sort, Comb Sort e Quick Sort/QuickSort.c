#include <stdio.h>
#include <stdlib.h>

int quickSort (int *a, int in, int fim);
void imprimir (int *a, int n);

int main(){

    printf("Comb Sort\n");

    srand(time(NULL));
    printf("\nTamanho do Array: ");
    int n;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i<n; i++){
        a[i] = rand()%100;
    }
    imprimir(a, n);
    quickSort(a, 0, n);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}

int quickSort (int *a, int in, int fim){
    int p, aux, i, j, meio;
    i = in;
    j = fim;
    meio = (int)((i+j)/2);
    p = a[meio];

    do{
        while (a[i]<p){
            i++;
        }
        while(a[j]>p){
            j--;
        }

        if(i<=j){
            aux = a[i];
            a[i] = a[j];
            a[j] = aux;
            i++;
            j--;
        }

    }while(j>1);

    if(in<j){
        quickSort(a, in, j);
    }
    if(i<fim){
        quickSort(a, i, fim);
    }

}

void imprimir (int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
