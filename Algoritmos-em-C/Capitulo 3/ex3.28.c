#include <stdio.h>
#include <stdlib.h>

int main () {

    int opc;
    float saldo;
    float deposito;
    float saque;

    printf("Saldo inicial: ");
    scanf("%f", &saldo);

        printf("Opercoes:\n");
        printf("    1) Deposito;\n");
        printf("    2) Saque;\n");
        printf("    3) Fim.\n");
        printf("Operacao desejada: ");
        scanf("%d", &opc);

        while(opc!=1 && opc!=2 && opc!=3){
        printf("Operacao invalida.\n");
        printf("Operacao desejada: ");
        scanf("%d", &opc);
        }

    do{
        if(opc==1){
                printf("Valor a depositar: ");
                scanf("%f", &deposito);
            saldo = saldo + deposito;
        }

        if(opc==2){
            printf("Valor a sacar: ");
                scanf("%f", &saque);
                saldo = saldo - saque;
        }

        printf("Operacao desejada: ");
        scanf("%d", &opc);

        while(opc!=1 && opc!=2 && opc!=3){
            printf("Operacao invalida.\n");
            printf("Operacao desejada: ");
            scanf("%d", &opc);
        }

        }while (opc == 1 || opc== 2);

    if(opc==3){
        if(saldo >= 0){
            printf("Saldo final: R$%.2f\n", saldo);
        }else{
            saldo = saldo*(-1);
            printf("Saldo final: -R$%.2f\n", saldo);
            saldo = saldo*(-1);
        }

        if (saldo < 0){
            printf("Conta devedora.");
        } else if (saldo > 0){
            printf("Conta preferencial.");
        }else{
            printf("Sem saldo.");
            }
        }
return 0;
}

