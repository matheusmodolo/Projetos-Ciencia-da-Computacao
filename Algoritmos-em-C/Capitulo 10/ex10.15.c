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

bool intercepta(const Retangulo *r1, const Retangulo *r2);

int main() {

    Retangulo r1;
    Retangulo r2;
    Ponto superiorEsquerdo;
    Ponto inferiorDireito;

    printf("Retangulo 1\n");
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

    r1 = novoRetangulo(&superiorEsquerdo, &inferiorDireito);

    printf("Retangulo 2\n");
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

    r2 = novoRetangulo(&superiorEsquerdo, &inferiorDireito);

    if (intercepta(&r1, &r2)) {

       printf("Os retangulos se interceptam!");
    } else {

       printf("Os retangulos nao se interceptam!");
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

bool intercepta(const Retangulo *r1, const Retangulo *r2) {

    Ponto a1;
    Ponto a2;

    a1.x = r2->superiorEsquerdo.x;
    a1.y = r2->inferiorDireito.y;

    a2.x = r2->inferiorDireito.x;
    a2.y = r2->superiorEsquerdo.y;

    if (contem(r1, &r2->superiorEsquerdo) || contem(r1, &r2->inferiorDireito) || contem(r1, &a1) || contem(r1, &a2)) {

        return true;
    }

    a1.x = r1->superiorEsquerdo.x;
    a1.y = r1->inferiorDireito.y;

    a2.x = r1->inferiorDireito.x;
    a2.y = r1->superiorEsquerdo.y;

    if (contem(r2, &r1->superiorEsquerdo) || contem(r2, &r1->inferiorDireito) || contem(r2, &a1) || contem(r2, &a2)) {

        return true;
    }
    return false;
}
