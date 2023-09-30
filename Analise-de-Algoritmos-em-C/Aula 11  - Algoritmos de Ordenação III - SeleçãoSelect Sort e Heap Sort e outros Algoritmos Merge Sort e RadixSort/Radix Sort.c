#include <stdio.h>
#include <stdlib.h>

int radixSort (int *a, int n);
void imprimir(int *a, int n);

int main(){

    printf("Radix Sort\n");

    srand(time(NULL));
    printf("\nTamanho do Array: ");
    int n;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i<n; i++){
        a[i] = rand()%100;
    }
    imprimir(a, n);
    radixSort(a, n);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}

int radixSort(int *a, int n){
    int i, b[n], m = 0, exp = 1;
    for (i = 0; i < n; i++){
        if(a[i] > m){
            m = a[i];
        }
    }
    while(m/exp > 0){
        int bucket[10] = {0};
        for(i = 0; i < n; i++){
            bucket[a[i]/exp%10]++;
        }
        for(i = 1; i < 10; i++){
            bucket[i] += bucket[i-1];
        }
        for(i = n - 1; i >= 0; i--){
            b[--bucket[a[i]/exp%10]] = a[i];
        }
        for(i = 0; i < n; i++){
            a[i] = b[i];
        }
        exp *= 10;
        imprimir(a, n);
    }
}

void imprimir(int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
