<?php

$h1 = 1;
$h2 = 2;
$m1 = 3;
$m2 = 4;

if ($h1 > $h2) {
    if ($m1 > $m2) {
        echo $h1 + $m2 . "<br> " . $h2 * $m1;
    } else {
        echo $h1 + $m1 . "<br>" . $h2 * $m2;
    }
} else {
    if ($m1 > $m2) {
        echo $h2 + $m2 . "<br>" . $h1 * $m1;
    } else {
        echo $h2 + $m1 . "<br>" . $h1 * $m2;
    }
}
