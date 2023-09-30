#include <stdio.h>
#include <stdlib.h>

int main(){

    float n1;
    float n2;
    float resultado;
    float sub;

    printf("Entre com um numero: ");
    scanf("%f", &n1);

    printf("Entre com outro numero: ");
    scanf("%f", &n2);

    resultado = n1 + n2;
    sub = n1 - n2;

    if (resultado > 10){
        printf("Os numeros fornecidos foram %.2f e %.2f", n1, n2);
    }else{
        printf("A subtracao entre %.2f e %.2f e igual a %.2f", n1, n2, sub);
    }

return 0;
}
