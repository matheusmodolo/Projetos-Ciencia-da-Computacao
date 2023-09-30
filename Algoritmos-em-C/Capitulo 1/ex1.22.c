#include <stdio.h>
#include <stdlib.h>

int main(){

    float preco;
    float precoVenda;

    printf("Valor do produto:");
    scanf("%f", &preco);

    precoVenda = preco * 0.91;
    printf("Preco de venda com 9%% de desconto: %.2f", precoVenda);

    return 0;
}
