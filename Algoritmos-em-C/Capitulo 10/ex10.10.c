#include <stdio.h>
#include <stdlib.h>

typedef struct{

    int red;
    int green;
    int blue;

}Cor;

Cor novaCor( int vermelho, int verde, int azul );

Cor clarear( const Cor *c );

int main(){

    Cor cor;
    Cor clara;

    printf("Vermelho: ");
    scanf("%d", &cor.red);
    printf("Verde: ");
    scanf("%d", &cor.green);
    printf("Azul: ");
    scanf("%d", &cor.blue);

    cor = novaCor(cor.red, cor.green, cor.blue);

    printf("\nCor base: rgb( %d, %d, %d )\n", cor.red, cor.green, cor.blue);

    clara = clarear(&cor);

    printf("Cor clareada: rgb( %d, %d, %d )", clara.red, clara.green, clara.blue);

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

Cor clarear( const Cor *c ){

    Cor novaCor;

    if(c->red == 0 && c->green==0 && c->blue == 0){
        novaCor.red = 3;
        novaCor.green = 3;
        novaCor.blue = 3;
    }else{
        if(c->red > 0 && c->red < 3){
            novaCor.red =(int) (3 / 0.7);
        }else if(c->red / 0.7 > 255){
            novaCor.red = 255;
        }else{
            novaCor.red = (int) (c->red / 0.7);
        }

        if(c->green > 0 && c->green < 3){
            novaCor.green =(int) (3 / 0.7);
        }else if(c->green / 0.7 > 255){
            novaCor.green = 255;
        }else{
            novaCor.green = (int) (c->green / 0.7);
        }

        if(c->blue > 0 && c->blue < 3){
            novaCor.blue =(int) (3 / 0.7);
        }else if(c->blue / 0.7 > 255){
            novaCor.blue = 255;
        }else{
            novaCor.blue = (int) (c->blue / 0.7);
        }
    }
    return novaCor;
}
