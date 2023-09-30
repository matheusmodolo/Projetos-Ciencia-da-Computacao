import 'package:flutter/material.dart';
import 'views/home.dart';

void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: Home(),
    theme: ThemeData(
      primaryColor: const Color(0xff795548),
      scaffoldBackgroundColor: const Color(0xfff5e9b9),
    ),
  ));
}
