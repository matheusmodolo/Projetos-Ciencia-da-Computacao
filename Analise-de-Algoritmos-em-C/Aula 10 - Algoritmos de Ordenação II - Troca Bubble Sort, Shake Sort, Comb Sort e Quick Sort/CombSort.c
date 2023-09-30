#include <stdio.h>
#include <stdlib.h>

int combSort (int *a, int n);
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
    combSort(a, n);

    printf("\nArray Ordenado    [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }

	return 0;
}

int combSort (int *a, int n){
    int i, j, h, troca = 1;
	int aux;
	h = n;
	while (h > 1 || troca == 1)
	{
		h = h/1.3;
		if (h == 9 || h == 10) h = 11;
		if (h < 1) h = 1;
		troca = 0;
		for (i = 0, j = h; j < n; i++, j++)
		{
			if (a[i] > a[j])
			{
				aux = a[i];
				a[i] = a[j];
				a[j] = aux;
				troca = 1;
			}
		}
		imprimir(a, n);
	}
}

void imprimir (int *a, int n){

    printf("\nArray Desordenado [] = ");
    for(int i=0; i < n; i++){
        printf("%d ", a[i]);
    }
}
