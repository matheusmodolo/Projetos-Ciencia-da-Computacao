#include <stdio.h>
#include <stdlib.h>

int main(){

    float n1;
    float n2;
    float resultado;
    char opcao;

    printf("N1: ");
    scanf("%f", &n1);

    printf("N2: ");
    scanf("%f", &n2);

    printf("Escolha uma operacao de acordo com o menu: \n");
    printf("\n    +) Adicao:");
    printf("\n    -) Subtracao:");
    printf("\n    *) Multiplicacao:");
    printf("\n    /) Divisao:");
    printf("\n Operacao: ");
    scanf(" %c", &opcao);

    switch ( opcao ) {

        case '+':
        resultado = n1 + n2;
        printf("%.2f + %.2f = %.2f", n1, n2, resultado);
        break;

        case '-':
        resultado = n1 - n2;
        printf("%.2f - %.2f = %.2f", n1, n2, resultado);
        break;

        case '*':
        resultado = n1 * n2;
        printf("%.2f * %.2f = %.2f", n1, n2, resultado);
        break;

        case '/':
        resultado = n1 / n2;
        printf("%.2f / %.2f = %.2f", n1, n2, resultado);
        break;

        default:
            printf("Opcao invalida!");
        break;

    }

return 0;
}
