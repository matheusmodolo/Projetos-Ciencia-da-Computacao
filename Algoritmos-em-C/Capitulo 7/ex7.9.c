#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

int ehTriangulo(int ladoA, int ladoB, int ladoC);
int tipoTriangulo(int ladoA, int ladoB, int ladoC);
int lePositivo();

int main(){
    int i;
    int ladoA [5];
    int ladoB [5];
    int ladoC [5];
    int tipo;

    for (i=0; i<5; i++){
        printf("ladoA[%d]: ", i);
        ladoA[i] = lePositivo();
        printf("ladoB[%d]: ", i);
        ladoB[i] = lePositivo();
        printf("ladoC[%d]: ", i);
        ladoC[i] = lePositivo();

    }
    for (i=0; i<5; i++){
            tipo = tipoTriangulo(ladoA[i], ladoB[i], ladoC[i]);
            printf("Valores %d, %d e %d: ", ladoA[i], ladoB[i], ladoC[i]);

            if (tipo == 0){
                printf("nao formam um triangulo");
            }else if( tipo == 1){
                printf("triangulo equilatero");
            }else if(tipo == 2){
                printf("triangulo isosceles");
            }else if (tipo == 3){
                printf("triangulo escaleno");
            }
            printf("\n");
    }

return 0;
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
int ehTriangulo (int ladoA, int ladoB, int ladoC){

    if (abs(ladoA - ladoB) < ladoC && ladoC < ladoA + ladoB ||
        abs(ladoA - ladoC) < ladoB && ladoB < ladoA + ladoC ||
        abs(ladoB - ladoC) < ladoA && ladoA < ladoB + ladoC){
            return true;
        }else{
            return false;
        }
}
int tipoTriangulo(int ladoA, int ladoB, int ladoC){

    bool triangulo = ehTriangulo(ladoA, ladoB, ladoC);

    if(!triangulo){
        return 0;
    }else if (ladoA == ladoB && ladoB == ladoC){
        return 1;
    }else if(ladoA != ladoB && ladoB != ladoC && ladoA != ladoC){
        return 3;
    }else{
        return 2;
    }
}
