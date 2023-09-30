#include <stdio.h>
#include <stdlib.h>

int lePositivo();
int somatorio (int n);

int main(){
    int i;
    int n[5];

    for (i=0; i<5; i++){
        printf ("n[%d]: ", i);
        n[i] = lePositivo();
    }

    for(i=0; i<5; i++){
        printf("Somatorio de 1 a %d: %d\n", n[i], somatorio(n[i]));
    }

return 0;
}

int somatorio(int n){
    int soma = 0;
    int j;
    for (int j=0; j<= n; j++){
        soma += j;
    }
return soma;
}

int lePositivo(){
    int n;
    do{
        scanf ("%d", &n);
        if (n<= 0){
        printf ("Entre com um valor positivo: ");
        }
    } while (n<=0);
return n;
}
