import 'package:flutter/material.dart';

class ContatoView extends StatelessWidget {
  const ContatoView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 97, 189, 140),
        title: const Text("Contato"),
        centerTitle: true,
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: const EdgeInsets.all(16),
          child: Column(
            children: [
              Row(
                children: [
                  Image.asset('assets/images/detalhe_contato.png'),
                  const Padding(
                    padding: EdgeInsets.only(left: 10),
                    child: Text(
                      "Contatos",
                      style: TextStyle(
                        fontSize: 20,
                        color: Color.fromARGB(255, 97, 189, 140),
                      ),
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 16),
              const Text("atendimento@atmconsultoria.gmail.com"),
              const SizedBox(height: 16),
              const Text("Telefone: (19) 3631-2022"),
              const SizedBox(height: 16),
              const Text("WhatsApp: (19) 98234-6543"),
            ],
          ),
        ),
      ),
    );
  }
}
