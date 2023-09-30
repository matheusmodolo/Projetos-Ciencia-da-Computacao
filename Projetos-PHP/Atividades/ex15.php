<?php

$idade = 22;

if ($idade < 16) {
  echo "Não eleitor.";
} else if ($idade == 16 || $idade == 17 || $idade > 65) {
  echo "Eleitor Facultativo.";
} else if ($idade >= 18 && $idade <= 65) {
  echo "Eleitor Obrigatório.";
}
