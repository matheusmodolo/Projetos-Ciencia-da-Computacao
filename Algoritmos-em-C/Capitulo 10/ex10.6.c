#include <stdio.h>
#include <stdlib.h>

typedef struct{

    int red;
    int green;
    int blue;
}RGB;

RGB novaCor( int vermelho, int verde, int azul );

void imprimirCor( const RGB *c );

int main(){

    RGB cor;
    RGB teste;

    printf("Vermelho: ");
    scanf("%d", &cor.red);
    printf("Verde: ");
    scanf("%d", &cor.green);
    printf("Azul: ");
    scanf("%d", &cor.blue);

    teste = novaCor(cor.red, cor.green, cor.blue);

    imprimirCor(&teste);

    return 0;
}

RGB novaCor( int vermelho, int verde, int azul ){

    RGB nova;

    nova.red = vermelho;
    nova.green = verde;
    nova.blue = azul;

    if(vermelho<0){
        nova.red = 0;
    }else if(vermelho>255){
        nova.red = 255;
    }
    if(verde<0){
        nova.green = 0;
    }else if(verde>255){
        nova.green = 255;
    }
    if(azul<0){
        nova.blue = 0;
    }else if(azul>255){
        nova.blue = 255;
    }

    return nova;
}

void imprimirCor( const RGB *c ){

    printf("Cor: rgb( %d, %d, %d )", c->red, c->green, c->blue);

}
