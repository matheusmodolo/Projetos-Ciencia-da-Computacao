#include <stdio.h>
#include <stdlib.h>

typedef struct {

    int x;
    int y;

}Ponto;

typedef struct {

    Ponto superiorEsquerdo;
    Ponto inferiorDireito;

} Retangulo;

Retangulo novoRetangulo(const Ponto *superiorEsquerdo, const Ponto *inferiorDireito);

void mover(Retangulo *r, int x, int y);

void imprimirRetangulo(const Retangulo *r);

int main() {

    Retangulo r;
    Ponto superiorEsquerdo;
    Ponto inferiorDireito;
    int x;
    int y;

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

    printf("Mover em x: ");
    scanf("%d", &x);

    printf("Mover em y: ");
    scanf("%d", &y);

    r = novoRetangulo(&superiorEsquerdo, &inferiorDireito);

    printf("Retangulo original:\n");
    imprimirRetangulo(&r);

    mover(&r, x, y);

    printf("\nRetangulo movido:\n");
    imprimirRetangulo(&r);

    return 0;

}

Retangulo novoRetangulo(const Ponto *superiorEsquerdo, const Ponto *inferiorDireito) {

    Retangulo ret;

    ret.superiorEsquerdo = *superiorEsquerdo;
    ret.inferiorDireito = *inferiorDireito;

    return ret;

}

void mover(Retangulo *r, int x, int y) {

    r->superiorEsquerdo.x += x;
    r->superiorEsquerdo.y += y;

    r->inferiorDireito.x += x;
    r->inferiorDireito.y += y;

}

void imprimirRetangulo(const Retangulo *r) {

    printf("(%+d, %+d) =====|\n", r->superiorEsquerdo.x, r->superiorEsquerdo.y);
    printf("|               |\n");
    printf("|               |\n");
    printf("|===== (%+d, %+d)", r->inferiorDireito.x, r->inferiorDireito.y);

}
