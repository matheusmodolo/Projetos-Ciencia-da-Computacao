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

Ponto obterCentro(const Retangulo *r);

void imprimirRetangulo(const Retangulo *r);

int main() {

    Ponto superiorEsquerdo;
    Ponto inferiorDireito;
    Ponto centro;
    Retangulo r;

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

    r = novoRetangulo(&superiorEsquerdo, &inferiorDireito);

    imprimirRetangulo(&r);

    centro = obterCentro(&r);

    printf("\nCentro: (%+d, %+d)", centro.x, centro.y);

    return 0;

}

Retangulo novoRetangulo(const Ponto *superiorEsquerdo, const Ponto *inferiorDireito) {

    Retangulo r;

    r.superiorEsquerdo = *superiorEsquerdo;
    r.inferiorDireito = *inferiorDireito;

    return r;

}

Ponto obterCentro(const Retangulo *r) {

    Ponto c;

    c.x = r->inferiorDireito.x - ((r->inferiorDireito.x - r->superiorEsquerdo.x) / 2);
    c.y = r->superiorEsquerdo.y - ((r->superiorEsquerdo.y - r->inferiorDireito.y) / 2);

    return c;

}

void imprimirRetangulo(const Retangulo *r) {

    printf("(%+d, %+d) =====|\n", r->superiorEsquerdo.x, r->superiorEsquerdo.y);
    printf("|               |\n");
    printf("|               |\n");
    printf("|===== (%+d, %+d)", r->inferiorDireito.x, r->inferiorDireito.y);

}
