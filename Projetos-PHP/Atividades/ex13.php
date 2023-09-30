<?php

$n1 = 5;
$n2 = 4;
$avOp = 10;

if ($avOp < 0) {
  $media = ($n1 + $n2) / 2;
  if ($media >= 6) {
    echo "APROVADO!";
  } else if ($media >= 5 && $media < 6) {
    echo "RECUPERAÇÃO.";
  } else {
    echo "REPROVADO.";
  }
} else {
  if ($n1 < $n2) {
    $n1 = $avOp;
  } else {
    $n2 = $avOp;
  }

  $media = ($n1 + $n2) / 2;
  if ($media >= 6) {
    echo "APROVADO!";
  } else if ($media >= 5 && $media < 6) {
    echo "RECUPERAÇÃO.";
  } else {
    echo "REPROVADO.";
  }
}
