#include <stdio.h>
#include <stdlib.h>

int main() {

    int i;
    float nota;
    float soma = 0;
    float somatorio;

    printf("Forneca a nota de 10 alunos:\n");

    for(i = 1; i <= 10; i++){
        printf("Nota %02d: ", i);
        scanf("%f", &nota);

        soma = soma + nota;
    }

    somatorio = soma/10;

    printf("A media aritmetica das dez notas e: %.2f", somatorio);


    return 0;
}
