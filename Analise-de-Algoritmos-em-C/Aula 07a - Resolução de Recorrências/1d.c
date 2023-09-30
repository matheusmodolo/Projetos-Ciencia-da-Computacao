#include <stdio.h>
#include <stdlib.h>

int buscaBinaria(int x, int a[], int inicio, int fim);

int x;

int main(){

    int posicao;
    int tamanho;
    printf("\nEntre com o tamanho do Array de inteiros: ");
    scanf("%d", &tamanho);
    int a[tamanho];

    printf("\nEntre com os elementos do Array:\n");
    for (int i = 0; i<tamanho; i++){
        printf("a[%d]: ", i+1);
        scanf("%d", &a[i]);
    }

    printf("Array gerado: ");
    for (int i = 0; i< tamanho; i++){
        printf("%d ", a[i]);
    }


    printf("\nEntre com o valor inteiro a ser procurado: ");
    scanf("%d", &x);

    posicao = buscaBinaria(x, a, 0, tamanho-1);

    if(posicao == -1){
        printf("\nO valor %d nao foi encontrado!\n", x);
    }else{
        printf("\nO valor %d foi encontrado na posicao %d!", x, posicao+1);
    }


	return 0;
}
int buscaBinaria(int x, int a[], int inicio, int fim){
    int meio = (inicio + fim)/2;
    if(a[meio]==x){
        return meio;
    }
    if(inicio >= fim){
        return -1;
    }
    else if(a[meio] < x){
        return buscaBinaria(x, a, meio+1, fim);
    }else{
        return buscaBinaria(x, a, inicio, meio-1);
    }

}
