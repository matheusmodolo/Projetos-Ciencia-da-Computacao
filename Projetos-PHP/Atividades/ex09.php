<?php

$lados = 1;

switch ($lados) {
    case 3:
        echo "TRIANGULO";
        break;
    case 4:
        echo "QUADRADO";
        break;
    case 5:
        echo "PENTAGONO";
        break;
    default:
        echo 'Poligono NÃO identificado...';
        break;
}
