#include <stdio.h>
#include <stdlib.h>

void hanoi(int n, int origem, int destino, int aux);

int main(){

    printf("Insira o numero de discos: ");
    int n;
    scanf("%d", &n);
    hanoi (n, 1, 3, 2);
    printf("\n");

	return 0;
}

void hanoi(int n, int origem, int destino, int aux){

    if(n==1){
        printf("\nMova o disco 1 da base %d para a base %d", origem, destino);
    }else{
        hanoi (n-1, origem, aux, destino);
        printf("\nMova o disco %d da base %d para a base %d", n, origem, destino);
        hanoi (n-1, aux, destino, origem);
    }
}
