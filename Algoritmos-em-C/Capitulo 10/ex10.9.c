#include <stdio.h>
#include <stdlib.h>

typedef struct{

    int red;
    int green;
    int blue;

}Cor;

Cor novaCor( int vermelho, int verde, int azul );

Cor escurecer( const Cor *c );

int main(){

    Cor cor;
    Cor escura;

    printf("Vermelho: ");
    scanf("%d", &cor.red);
    printf("Verde: ");
    scanf("%d", &cor.green);
    printf("Azul: ");
    scanf("%d", &cor.blue);

    cor = novaCor(cor.red, cor.green, cor.blue);

    printf("\nCor base: rgb( %d, %d, %d )\n", cor.red, cor.green, cor.blue);

    escura = escurecer(&cor);

    printf("Cor escurecida: rgb( %d, %d, %d )", escura.red, escura.green, escura.blue);

    return 0;
}

Cor novaCor( int vermelho, int verde, int azul ){

    Cor nova;

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

Cor escurecer( const Cor *c ){

    Cor novaCor;

    novaCor.red = (int)(c->red*0.7);
    novaCor.green = (int)(c->green*0.7);
    novaCor.blue = (int)(c->blue*0.7);

    return novaCor;
}
