<?php

$peso = 50.9;
$altura = 1.70;

$imc = $peso / ($altura * $altura);

if ($imc < 18.5) {
  echo "IMC: " . number_format($imc, 2, '.') . ".<br>Você está abaixo do peso ideal.";
} else if ($imc >= 18.5 && $imc <= 24.9) {
  echo "IMC: " . number_format($imc, 2, '.') . ".<br>Parabéns! Você está em seu peso ideal.";
} else if ($imc >= 25.0 && $imc <= 29.9) {
  echo "IMC: " . number_format($imc, 2, '.') . ".<br>Você está em sobrepeso.";
} else if ($imc >= 30.0 && $imc <= 34.9) {
  echo "IMC: " . number_format($imc, 2, '.') . ".<br>Obesidade grau I.";
} else if ($imc >= 35.0 && $imc <= 39.9) {
  echo "IMC: " . number_format($imc, 2, '.') . ".<br>Obesidade grau II.";
} else {
  echo "IMC: " . number_format($imc, 2, '.') . ".<br>Obesidade grau III.";
}
