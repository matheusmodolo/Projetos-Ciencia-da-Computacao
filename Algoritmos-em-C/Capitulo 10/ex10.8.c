#include <stdio.h>
#include <stdlib.h>

typedef struct{

    int red;
    int green;
    int blue;
}Cor;

Cor novaCor( int vermelho, int verde, int azul );

void setVermelho( Cor *c, int vermelho );

void setVerde( Cor *c, int verde );

void setAzul( Cor *c, int azul );

int main(){

    Cor corP;
    Cor alt;

    printf("Vermelho: ");
    scanf("%d", &corP.red);
    printf("Verde: ");
    scanf("%d", &corP.green);
    printf("Azul: ");
    scanf("%d", &corP.blue);


    printf("Novo vermelho: ");
    scanf("%d", &alt.red);
    printf("Novo verde: ");
    scanf("%d", &alt.green);
    printf("Novo azul: ");
    scanf("%d", &alt.blue);

    corP = novaCor(corP.red, corP.green, corP.blue);

    printf("Cor: rgb( %d, %d, %d )", corP.red, corP.green, corP.blue);

    setVermelho(&corP, alt.red);
    setVerde(&corP, alt.green);
    setAzul(&corP, alt.blue);

    corP = novaCor(corP.red, corP.green, corP.blue);

    printf("\nCor alterada: rgb( %d, %d, %d )", corP.red, corP.green, corP.blue);


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

void setVermelho( Cor *c, int vermelho ){

    c->red = vermelho;
}

void setVerde( Cor *c, int verde ){

    c->green = verde;
}

void setAzul( Cor *c, int azul ){

    c->blue = azul;
}
