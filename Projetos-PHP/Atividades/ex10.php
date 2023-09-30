<?php

$l1 = 1;
$l2 = 1;
$l3 = 1;

if ($l1 == $l2 && $l1 == $l3) {
    echo "Triângulo Equilátero";
} else if ($l1 == $l2 || $l1 == $l3 || $l2 == $l3) {
    echo "Triângulo Isósceles";
} else {
    echo "Triângulo Escaleno";
}
