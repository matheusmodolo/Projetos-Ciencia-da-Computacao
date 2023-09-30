#include <stdio.h>
#include <stdlib.h>

int bubbleSort (int *a, int n);
void imprimir(int *a, int n);

int main(){

    printf("Bubble Sort\n");

    srand(time(NULL));
    printf("\nTamanho do Array: ");
    int n;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i<n; i++){
        a[i] = rand()%100;
    }
    imprimir(a, n);
    bubbleSort(a, n);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}
int bubbleSort (int *a, int n){
    int aux, i, j;
    for(j=n-1; j>=1; j--){
        for(i=0; i<j; i++){
            if(a[i]>a[i+1]){
                aux = a[i];
                a[i] = a[i+1];
                a[i+1] = aux;
            }
        }
        imprimir(a, n);
    }

}

void imprimir(int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
