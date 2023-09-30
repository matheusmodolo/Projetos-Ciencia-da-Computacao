import 'dart:math';
import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  final List<String> _frases = [
    "Você não desperdiça seu talento, pois não tem nenhum.",
    "Não se esqueça que ela já te esqueceu.",
    "Era paixão até virar responsabilidade.",
    "Você é a criança inteligente da família que não deu certo.",
    "Só se frustra quem acredita que dará certo.",
    "Nunca desista. Alguém precisa ser o exemplo de fracasso.",
    "Todo traumatizado um dia foi um motivado.",
    "Toda desistência evita um trauma.",
    "O que chamam de dias ruins você chama de rotina.",
    "Não deixe que um otimista te engane.",
    "Não chame de fracasso o que tinha tudo pra dar errado.",
    "Não pense nos seus defeitos. Eles sâo muitos e você não tem esse tempo todo.",
    "Não falam das suas qualidades porque você não tem.",
    "Claro que é difícil, você não tem talento.",
    "Se esforce ao máximo. Fracasse e ainda fique cansado.",
    "Mostre que as críticas são falsas: Você é ainda pior.",
    "Otimista é um pessimista sem experiência.",
    "Mude de ideia. Tome uma decisão ainda pior."
  ];

  String _frasegerada = "Clique abaixo para gerar uma frase!";

  void gerarFrase() {
    int numeroSorteado = Random().nextInt(_frases.length);
    setState(() {
      _frasegerada = _frases[numeroSorteado];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
            title: const Text("Coach Desmotivacional"),
            backgroundColor: const Color(0xff002080),
            centerTitle: true),
        body: Container(
          width: double.infinity,
          color: Colors.white,
          padding: const EdgeInsets.all(16),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.asset("images/coach.png"),
              Text(_frasegerada,
                  style: const TextStyle(
                      fontSize: 18,
                      fontStyle: FontStyle.italic,
                      color: Colors.black),
                  textAlign: TextAlign.justify),
              ElevatedButton(
                onPressed: gerarFrase,
                child: const Text("NOVA FRASE"),
                style: ElevatedButton.styleFrom(
                    primary: Color(0xff002080),
                    textStyle: TextStyle(
                        fontSize: 20,
                        fontWeight: FontWeight.bold,
                        color: Colors.white)),
              )
            ],
          ),
        ));
  }
}
