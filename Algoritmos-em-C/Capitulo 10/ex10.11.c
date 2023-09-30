#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct{

    int x;
    int y;

}Ponto;

typedef struct{

    Ponto superiorEsquerdo;
    Ponto inferiorDireito;

}Retangulo;

Retangulo novoRetangulo (const Ponto *sEsq, const Ponto *iDir);

int calcularArea(const Retangulo *r);

void imprimirRetangulo(const Retangulo *r);

int main(){

    Ponto superiorEsquerdo;
    Ponto inferiorDireito;
    Retangulo retangulo;

    printf("Ponto superior esquerdo\n");
    printf("    x: ");
    scanf("%d", &superiorEsquerdo.x);

    printf("    y: ");
    scanf("%d", &superiorEsquerdo.y);

    printf("Ponto inferior direito\n");
    printf("    x: ");
    scanf("%d", &inferiorDireito.x);

    printf("    y: ");
    scanf("%d", &inferiorDireito.y);

    retangulo = novoRetangulo(&superiorEsquerdo, &inferiorDireito);

    imprimirRetangulo(&retangulo);

    printf("\nArea: %d", calcularArea(&retangulo));

    return 0;
}

Retangulo novoRetangulo (const Ponto *sEsq, const Ponto *iDir) {

    Retangulo retangulo;

    retangulo.superiorEsquerdo = *sEsq;
    retangulo.inferiorDireito = *iDir;

    return retangulo;

}

int calcularArea(const Retangulo *r) {

    int area;

    area = abs((r->inferiorDireito.x - r->superiorEsquerdo.x) * (r->superiorEsquerdo.y - r->inferiorDireito.y));

    return area;

}

void imprimirRetangulo(const Retangulo *r) {

    printf("(%+02d, %+02d) =====|\n", r->superiorEsquerdo.x, r->superiorEsquerdo.y);
    printf("|               |\n");
    printf("|               |\n");
    printf("|===== (%+02d, %+02d)", r->inferiorDireito.x, r->inferiorDireito.y);

}
