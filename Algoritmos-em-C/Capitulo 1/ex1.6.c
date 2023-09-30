 //ex1.6
 #include <stdio.h>
 #include <stdlib.h>
 int main() {
    int n1;
    int n2;
    int adicao;
    int subtracao;
    int multiplicacao;
    int divisao; //declaração de variaveis//

    printf("Entre com o primeiro numero: ");
    scanf ("%d", &n1);

    printf("Entre com o segundo numero: ");
    scanf("%d", &n2);

    adicao = n1 + n2;
    subtracao = n1 - n2;
    multiplicacao = n1 * n2;
    divisao = n1 / n2; //processamento//

    printf("%d + %d = %d\n", n1, n2, adicao);
    printf("%d - %d = %d\n",n1, n2, subtracao);
    printf("%d * %d = %d\n",n1, n2, multiplicacao);
    printf("%d / %d = %d",n1, n2, divisao); //saida//

    return 0;

 }
