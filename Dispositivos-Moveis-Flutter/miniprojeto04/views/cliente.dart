import 'package:flutter/material.dart';

class ClienteView extends StatelessWidget {
  const ClienteView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 185, 201, 65),
        title: const Text("Cliente"),
        centerTitle: true,
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: const EdgeInsets.all(16),
          child: Column(
            children: [
              Row(
                children: [
                  Image.asset('assets/images/detalhe_Cliente.png'),
                  const Padding(
                    padding: EdgeInsets.only(left: 10),
                    child: Text(
                      "Cliente",
                      style: TextStyle(
                        fontSize: 20,
                        color: Color.fromARGB(255, 185, 201, 65),
                      ),
                    ),
                  ),
                ],
              ),
              const SizedBox(
                height: 16,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Image.asset('assets/images/cliente1.png'),
                ],
              ),
              const Text("Empresa de desenvolviemtno de Software"),
              const SizedBox(height: 16),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Image.asset('assets/images/cliente2.png'),
                ],
              ),
              const Text("Empresa de consultoria"),
            ],
          ),
        ),
      ),
    );
  }
}
