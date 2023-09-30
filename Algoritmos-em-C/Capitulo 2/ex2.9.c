#include <stdio.h>
#include <stdlib.h>

int main (){

    float q;
    float m;
    float perimetroT;
    float areaQ;

    printf("Entre com a quantidade de lados: ");
    scanf("%f", &q);

    printf("Entre com a medida do lado: ");
    scanf("%f", &m);

    perimetroT = m*3;
    areaQ = m*m;

    if (q == 3){
        printf("TRIANGULO de perimetro %.2f", perimetroT);

    }else if(q == 4){
        printf("QUADRADO de area %.2f", areaQ);

    }else if (q == 5){
        printf("PENTAGONO");
    }else{
        printf("Poligono nao identificado");
    }




return 0;
}
