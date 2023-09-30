<?php

$a1 = 1;
$a2 = 1;
$a3 = 1;

if ($a1 == 90 || $a2 == 90 || $a3 == 90) {
    echo "Triângulo retângulo";
} else if ($a1 > 90 || $a2 > 90 || $a3 > 90) {
    echo "Triângulo obtusângulo";
} else if ($a1 == $a2 && $a1 == $a3) {
    echo "Triângulo acutângulo";
}
