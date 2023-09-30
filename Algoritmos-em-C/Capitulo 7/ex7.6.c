#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int somaDivisores(int n);
int lePositivo();

int main(){

    int i;
    int n[5];
    bool amigos;

    for(i=0; i<5; i++){
        printf("n[%d]: ", i);
        n[i] = lePositivo();
    }

    system("cls");

    for (i=0; i<5; i++){
        printf("Soma dos divisores de %d: %d\n", n[i], somaDivisores(n[i]));
    }

return 0;
}

int somaDivisores(int n){
    int i;
    int soma = 0;
    for(i=1; i < n; i++){
            if (n % i == 0){
                soma += i;
            }
    }
    return soma;
}
int lePositivo(){
    int n;
        scanf("%d", &n);
	    while(n<0){
        printf("Entre com um valor positivo: ");
        scanf("%d", &n);
        }
return n;
}
