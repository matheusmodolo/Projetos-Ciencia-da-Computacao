#include <stdio.h>
#include <stdbool.h>

typedef struct {

    int x;
    int y;

}Ponto;

typedef struct {

    Ponto superiorEsquerdo;
    Ponto inferiorDireito;

} Retangulo;

Retangulo novoRetangulo(const Ponto *superiorEsquerdo, const Ponto *inferiorDireito);

bool contem(const Retangulo *r, const Ponto *p);

int main() {

    Retangulo r;
    Ponto superiorEsquerdo;
    Ponto inferiorDireito;
    Ponto pontos[5];
    int i;

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

    printf("Pontos\n");

    for (i=0; i<5; i++) {

        printf("  Ponto %d\n", i+1);
        printf("    x: ");
        scanf("%d", &pontos[i].x);

        printf("    y: ");
        scanf("%d", &pontos[i].y);
    }

    r = novoRetangulo(&superiorEsquerdo, &inferiorDireito);

    for (i=0; i<5; i++) {

        printf("(%+d, %+d):", pontos[i].x, pontos[i]. y);

        if (!contem(&r, &pontos[i])) {
            printf(" nao");
        }
        printf(" contido!\n");
    }
    return 0;
}

Retangulo novoRetangulo(const Ponto *superiorEsquerdo, const Ponto *inferiorDireito) {

    Retangulo r;

    r.superiorEsquerdo = *superiorEsquerdo;
    r.inferiorDireito = *inferiorDireito;

    return r;
}

bool contem(const Retangulo *r, const Ponto *p) {

    if ( (p->x >= r->superiorEsquerdo.x && p->x <= r->inferiorDireito.x) && (p->y <= r->superiorEsquerdo.y && p->y >= r->inferiorDireito.y) ) {

        return true;
    }
    return false;
}
