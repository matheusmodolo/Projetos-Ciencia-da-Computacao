#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int red;
    int green;
    int blue;
}Cor;

int getVermelho( const Cor *c );

int getVerde( const Cor *c );

int getAzul( const Cor *c );

int main(){

    Cor color;

    printf("Vermelho: ");
    scanf("%d", &color.red);
    printf("Verde: ");
    scanf("%d", &color.green);
    printf("Azul: ");
    scanf("%d", &color.blue);

    printf("Cor: rgb( %d, %d, %d )\n", getVermelho(&color), getVerde(&color), getAzul(&color));
    printf("getVermelho(): %d\n", getVermelho(&color));
    printf("getVerde(): %d\n", getVerde(&color));
    printf("getAzul(): %d", getAzul(&color));




    return 0;
}
int getVermelho( const Cor *c ){

    if(c->red>255){
        return 255;
    }else if (c->red<0){
        return 0;
    }else{
        return c->red;
    }

}

int getVerde( const Cor *c ){

    if(c->green>255){
        return 255;
    }else if(c->green < 0){
        return 0;
    }else{
        return c->green;
    }
}

int getAzul( const Cor *c ){

    if(c->blue>255){
        return 255;
    }else if(c->blue<0){
        return 0;
    }else{
        return c->blue;
    }

}
