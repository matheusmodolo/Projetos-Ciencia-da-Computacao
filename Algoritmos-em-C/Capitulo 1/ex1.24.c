#include <stdio.h>
#include <stdlib.h>

int main(){
    float n1;
    float n2;
    float n3;
    float n4;
    float salario;

    printf ("Valor da aula/hora: ");
    scanf ("%f", &n1);

    printf("Quantidade de aulas: ");
    scanf ("%f", &n2);

    printf("Porcentagem de desconto do INSS: ");
    scanf ("%f", &n3);

    n4 = n1*n2*n3/100;

    salario = n1*n2 - n4;

    printf("Salario Liquido: %.2f", salario);


return 0;
}
