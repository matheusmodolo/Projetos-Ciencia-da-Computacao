#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define PI acos(-1)

typedef enum {
    RETANGULO,
    CIRCULO
} TipoForma;

typedef struct {
    int x;
    int y;
} Ponto;

typedef struct {
    TipoForma tipo;
    Ponto centro;
    union {
        struct {
            int altura;
            int largura;
        } retangulo;
        struct {
            int raio;
        } circulo;
    } geo;
} Forma;

int calcularArea( const Forma *f );

void mover( Forma *f, int x, int y );

Forma redimensionar( const Forma *f, float fator );

void imprimirForma( const Forma *f );

int main(){

    Forma ret;
    Forma circ;
    ret.tipo = RETANGULO;
    circ.tipo = CIRCULO;

    Ponto point;

    //RETANGULO
    printf("Dados do Retangulo:\n   Centro:\n        x: ");
    scanf("%d", &ret.centro.x);
    printf("        y: ");
    scanf("%d", &ret.centro.y);
    printf("    Largura: ");
    scanf("%d", &ret.geo.retangulo.largura);
    printf("    Altura: ");
    scanf("%d", &ret.geo.retangulo.altura);

    //CIRCULO
    printf("Dados do Circulo:\n    Centro:\n        x: ");
    scanf("%d", &circ.centro.x);
    printf("        y: ");
    scanf("%d", &circ.centro.y);
    printf("    Raio: ");
    scanf("%d", &circ.geo.circulo.raio);

    printf("Apos a criacao, mover em:\n    x: ");
    scanf("%d", &point.x);
    printf("    y: ");
    scanf("%d", &point.y);

    int fator;

    printf("Apos mover, redimensionar pelo fator: ");
    scanf("%d", &fator);


    printf("Original:\n");
    imprimirForma(&ret);
    imprimirForma(&circ);
    printf("\n");
    printf("Apos mover:\n");
    mover(&ret, point.x, point.y);
    imprimirForma(&ret);
    mover(&circ, point.x, point.y);
    imprimirForma(&circ);
    printf("\n");
    printf("Apos redimensionar:\n");

    Forma f = redimensionar(&ret, fator);
    imprimirForma(&f);
    f = redimensionar(&circ, fator);
    imprimirForma(&f);


    return 0;
}

int calcularArea( const Forma *f ){

    switch(f->tipo){

    //caso não rode, crie uma int area, para retorna-la//
    case RETANGULO:
        return f->geo.retangulo.largura*f->geo.retangulo.altura;
        break;

    case CIRCULO:
        return pow(f->geo.circulo.raio, 2)*PI;
        break;
    }

}

void mover( Forma *f, int x, int y ){

    f->centro.x += x;
    f->centro.y += y;
}

Forma redimensionar( const Forma *f, float fator ){

    Forma form;
    Ponto spot;

    form.tipo = f->tipo;
    form.centro.x = f->centro.x;
    form.centro.y = f->centro.y;

    switch(f->tipo){

        case RETANGULO:
            form.geo.retangulo.largura = f->geo.retangulo.largura;
            form.geo.retangulo.altura = f->geo.retangulo.altura;
            spot.x = form.centro.x - (form.geo.retangulo.largura/2);
            spot.y = form.centro.y - (form.geo.retangulo.altura/2);

            form.geo.retangulo.largura *= fator;
            form.geo.retangulo.altura *= fator;

            form.centro.x = form.geo.retangulo.largura/2 + spot.x;
            form.centro.y = form.geo.retangulo.altura/2 + spot.y;
            break;

        case CIRCULO:
            form.geo.circulo.raio = f->geo.circulo.raio;
            spot.x = form.centro.x - form.geo.circulo.raio;
            spot.y = form.centro.y - form.geo.circulo.raio;

            form.geo.circulo.raio *=fator;

            form.centro.x = form.geo.circulo.raio + spot.x;
            form.centro.y = form.geo.circulo.raio + spot.y;
            break;
    }
    return form;
}

void imprimirForma( const Forma *f ){

      switch ( f->tipo ) {
          case RETANGULO:
              printf("===== Retangulo ======\n");
              printf("| Centro: (%+d, %+d) |\n",f->centro.x,f->centro.y);
              printf("| Largura: %d        |\n",f->geo.retangulo.largura);
              printf("| Altura: %d         |\n",f->geo.retangulo.altura);
              printf("======================\n");
              printf("  Area: %d\n",calcularArea( f ));
              printf("======================\n");
              break;
          case CIRCULO:
              printf("====== Circulo =======\n");
              printf("| Centro: (%+d, %+d) |\n",f->centro.x,f->centro.y);
              printf("| Raio: %d           |\n",f->geo.circulo.raio);
              printf("======================\n");
              printf("  Area: %d\n",calcularArea( f ));
              printf("======================\n");
              break;
            }

}
