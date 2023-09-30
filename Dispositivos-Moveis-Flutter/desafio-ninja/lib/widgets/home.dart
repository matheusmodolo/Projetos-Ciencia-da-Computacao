import 'dart:math';
import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  String frase = "Faça sua escolha!";

  String _resultado = "";
  String _appImage = "padrao";

  void _jogadaApp(String jogador) {
    List<String> jogadas = ["agua", "fogo", "neve"];
    int app = Random().nextInt(3);

    switch (jogadas[app]) {
      case "agua":
        _appImage = "agua";
        if (jogador == "agua") {
          setState(() {
            _resultado = "EMPATE";
          });
        } else if (jogador == "fogo") {
          setState(() {
            _resultado = "DERROTA";
          });
        } else {
          setState(() {
            _resultado = "VITÓRIA";
          });
        }
        break;
      case "fogo":
        _appImage = "fogo";
        if (jogador == "agua") {
          setState(() {
            _resultado = "VITÓRIA";
          });
        } else if (jogador == "fogo") {
          setState(() {
            _resultado = "EMPATE";
          });
        } else {
          setState(() {
            _resultado = "DERROTA";
          });
        }
        break;
      case "neve":
        _appImage = "neve";
        if (jogador == "agua") {
          setState(() {
            _resultado = "DERROTA";
          });
        } else if (jogador == "fogo") {
          setState(() {
            _resultado = "VITÓRIA";
          });
        } else {
          setState(() {
            _resultado = "EMPATE";
          });
        }
        break;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Desafio-Ninja",
            style: TextStyle(
              fontSize: 28,
              fontWeight: FontWeight.w900,
              color: Color(0xFFFe5c146),
            )),
        centerTitle: true,
        backgroundColor: Color.fromARGB(255, 183, 54, 52),
        elevation: 15,
      ),
      body: Container(
        padding: EdgeInsets.all(15),
        width: double.infinity,
        color: Color(0xffFe7e0aa),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Image.asset("images/$_appImage.png"),
            Text(
              frase,
              style: const TextStyle(
                fontSize: 32,
                fontStyle: FontStyle.normal,
                fontWeight: FontWeight.bold,
                color: Colors.black,
              ),
              textAlign: TextAlign.center,
            ),
            Row(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
              GestureDetector(
                onTap: () => _jogadaApp("agua"),
                child: Image.asset("images/agua.png"),
              ),
              GestureDetector(
                onTap: () => _jogadaApp("fogo"),
                child: Image.asset("images/fogo.png"),
              ),
              GestureDetector(
                onTap: () => _jogadaApp("neve"),
                child: Image.asset("images/neve.png"),
              ),
            ]),
            Text(
              _resultado,
              style: TextStyle(fontSize: 32),
            ),
          ],
        ),
      ),
    );
  }
}
